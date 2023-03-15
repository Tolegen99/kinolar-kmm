package kz.tolegen.kinolarkmm.common.watch.list.flow.integration

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
import kz.tolegen.kinolarkmm.common.utils.Consumer
import kz.tolegen.kinolarkmm.common.watch.list.flow.WatchListFlow
import kz.tolegen.kinolarkmm.common.watch.list.flow.store.WatchListFlowStore
import kz.tolegen.kinolarkmm.common.watch.list.flow.store.WatchListFlowStoreProvider
import kz.tolegen.kinolarkmm.common.utils.asValue
import kz.tolegen.kinolarkmm.common.watch.list.WatchList
import kz.tolegen.kinolarkmm.common.watch.list.flow.WatchListFlow.*
import kz.tolegen.kinolarkmm.common.watch.list.integration.WatchListComponent

class WatchListFlowComponent internal constructor(
    componentContext: ComponentContext,
    private val output: Consumer<Output>,
    storeFactory: StoreFactory,
    private val watchList: (ComponentContext, Consumer<WatchList.Output>) -> WatchList
) : WatchListFlow, ComponentContext by componentContext {

    private val store = instanceKeeper.getStore {
        WatchListFlowStoreProvider(
            storeFactory = storeFactory
        ).provide()
    }

    override val models: Value<Model> = store.asValue().map(stateToModel)

    constructor(
        componentContext: ComponentContext,
        output: Consumer<Output>,
        api: Api,
        storeFactory: StoreFactory
    ) : this(
        componentContext = componentContext,
        output = output,
        storeFactory = storeFactory,
        watchList = { childContext, output ->
            WatchListComponent(
                componentContext = componentContext,
                output = output,
                api = api,
                storeFactory = storeFactory
            )
        }
    )

    override fun bottomNavItemClicked(index: Int) {
        store.accept(WatchListFlowStore.Intent.ChangeSelectedBottomNavItem(index))
    }

    private val navigation = StackNavigation<Configuration>()

    private val stack =
        childStack(
            source = navigation,
            initialConfiguration = Configuration.WatchListConf,
            handleBackButton = true,
            childFactory = ::createChild,
            key = "WatchListFlowRouter"
        )

    override val childStack: Value<ChildStack<*, Child>> = stack

    private fun createChild(configuration: Configuration, componentContext: ComponentContext): Child {
        return when (configuration) {
            is Configuration.WatchListConf -> Child.WatchListCh(watchList(componentContext, Consumer(::onWatchListOutput)))
        }
    }

    private fun onWatchListOutput(output: WatchList.Output): Unit =
        when (output) {
            else -> {}
        }

    private sealed class Configuration : Parcelable {
        @Parcelize
        object WatchListConf : Configuration()
    }

}