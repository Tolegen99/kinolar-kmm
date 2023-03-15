package kz.tolegen.kinolarkmm.common.watch.list.integration

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
import kz.tolegen.kinolarkmm.common.api.Api
import kz.tolegen.kinolarkmm.common.watch.list.WatchList
import kz.tolegen.kinolarkmm.common.watch.list.WatchList.Child
import kz.tolegen.kinolarkmm.common.watch.list.WatchList.Model
import kz.tolegen.kinolarkmm.common.watch.list.store.WatchListStore
import kz.tolegen.kinolarkmm.common.watch.list.store.WatchListStoreProvider
import kz.tolegen.kinolarkmm.common.utils.asValue

class WatchListComponent(
    componentContext: ComponentContext,
    private val output: Consumer<WatchList.Output>,
    storeFactory: StoreFactory,
    api: Api
) : WatchList, ComponentContext by componentContext {

    private val store = instanceKeeper.getStore {
        WatchListStoreProvider(
            storeFactory = storeFactory,
            api = api
        ).provide()
    }

    override val models: Value<Model> = store.asValue().map(stateToModel)

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

    override fun onClear() {
        store.accept(WatchListStore.Intent.Clear)
    }

    private sealed class Configuration : Parcelable {
        @Parcelize
        object Stub : Configuration()
    }

}