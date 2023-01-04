package kz.tolegen.kinolarkmm.common.main.integration

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.value.Value
import com.arkivanov.decompose.value.operator.map
import com.arkivanov.essenty.parcelable.Parcelable
import com.arkivanov.essenty.parcelable.Parcelize
import com.arkivanov.mvikotlin.core.instancekeeper.getStore
import com.arkivanov.mvikotlin.core.store.StoreFactory
import com.badoo.reaktive.base.Consumer
import kz.tolegen.kinolarkmm.common.main.Main
import kz.tolegen.kinolarkmm.common.main.Main.Child
import kz.tolegen.kinolarkmm.common.main.Main.Model
import kz.tolegen.kinolarkmm.common.main.store.MainStore
import kz.tolegen.kinolarkmm.common.main.store.MainStoreProvider
import kz.tolegen.kinolarkmm.common.utils.asValue

class MainComponent(
    componentContext: ComponentContext,
    private val output: Consumer<Main.Output>,
    storeFactory: StoreFactory,
) : Main, ComponentContext by componentContext {

    private val store = instanceKeeper.getStore {
        MainStoreProvider(
            storeFactory = storeFactory
        ).provide()
    }

    override val models: Value<Model> = store.asValue().map(stateToModel)

    override fun bottomNavItemClicked(index: Int) {
        store.accept(MainStore.Intent.ChangeSelectedBottomNavItem(index))
    }

    private val navigation = StackNavigation<Configuration>()

    private val stack =
        childStack(
            source = navigation,
            initialConfiguration = Configuration.Stub,
            handleBackButton = true,
            childFactory = ::createChild,
            key = "MainRouter"
        )

    override val childStack: Value<ChildStack<*, Child>> = stack

    private fun createChild(configuration: Configuration, componentContext: ComponentContext): Child {
        return when (configuration) {
            is Configuration.Stub -> Child.Stub
        }
    }

    private sealed class Configuration : Parcelable {
        @Parcelize
        object Stub : Configuration()
    }

}