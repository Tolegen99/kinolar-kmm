package kz.tolegen.kinolarkmm.common.home.flow.integration

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
import kz.tolegen.kinolarkmm.common.home.flow.HomeFlow
import kz.tolegen.kinolarkmm.common.home.flow.HomeFlow.Child
import kz.tolegen.kinolarkmm.common.home.flow.HomeFlow.Model
import kz.tolegen.kinolarkmm.common.home.flow.store.HomeFlowStore
import kz.tolegen.kinolarkmm.common.home.flow.store.HomeFlowStoreProvider
import kz.tolegen.kinolarkmm.common.utils.asValue

class HomeFlowComponent(
    componentContext: ComponentContext,
    private val output: Consumer<HomeFlow.Output>,
    storeFactory: StoreFactory,
) : HomeFlow, ComponentContext by componentContext {

    private val store = instanceKeeper.getStore {
        HomeFlowStoreProvider(
            storeFactory = storeFactory
        ).provide()
    }

    override val models: Value<Model> = store.asValue().map(stateToModel)

    override fun bottomNavItemClicked(index: Int) {
        store.accept(HomeFlowStore.Intent.ChangeSelectedBottomNavItem(index))
    }

    private val navigation = StackNavigation<Configuration>()

    private val stack =
        childStack(
            source = navigation,
            initialConfiguration = Configuration.Stub,
            handleBackButton = true,
            childFactory = ::createChild,
            key = "HomeRouter"
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