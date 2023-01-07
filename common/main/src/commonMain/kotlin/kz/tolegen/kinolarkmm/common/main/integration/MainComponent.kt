package kz.tolegen.kinolarkmm.common.main.integration

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.navigate
import com.arkivanov.decompose.value.Value
import com.arkivanov.decompose.value.operator.map
import com.arkivanov.essenty.parcelable.Parcelable
import com.arkivanov.essenty.parcelable.Parcelize
import com.arkivanov.mvikotlin.core.instancekeeper.getStore
import com.arkivanov.mvikotlin.core.store.StoreFactory
import com.badoo.reaktive.base.Consumer
import kz.tolegen.kinolarkmm.common.home.flow.HomeFlow
import kz.tolegen.kinolarkmm.common.home.flow.integration.HomeFlowComponent
import kz.tolegen.kinolarkmm.common.main.Main
import kz.tolegen.kinolarkmm.common.main.Main.*
import kz.tolegen.kinolarkmm.common.main.store.MainStore
import kz.tolegen.kinolarkmm.common.main.store.MainStoreProvider
import kz.tolegen.kinolarkmm.common.search.flow.SearchFlow
import kz.tolegen.kinolarkmm.common.search.flow.integration.SearchFlowComponent
import kz.tolegen.kinolarkmm.common.utils.asValue
import kz.tolegen.kinolarkmm.common.watch.list.flow.WatchListFlow
import kz.tolegen.kinolarkmm.common.watch.list.flow.integration.WatchListFlowComponent
import kz.tolegen.kinolarkmm.common.utils.Consumer

class MainComponent internal constructor(
    componentContext: ComponentContext,
    private val output: Consumer<Output>,
    storeFactory: StoreFactory,
    private val homeFlow: (ComponentContext, Consumer<HomeFlow.Output>) -> HomeFlow,
    private val searchFlow: (ComponentContext, Consumer<SearchFlow.Output>) -> SearchFlow,
    private val watchListFlow: (ComponentContext, Consumer<WatchListFlow.Output>) -> WatchListFlow,
) : Main, ComponentContext by componentContext {

    private val store = instanceKeeper.getStore {
        MainStoreProvider(
            storeFactory = storeFactory
        ).provide()
    }

    override val models: Value<Model> = store.asValue().map(stateToModel)

    constructor(
        componentContext: ComponentContext,
        output: Consumer<Output>,
        storeFactory: StoreFactory
    ) : this(
        componentContext = componentContext,
        output = output,
        storeFactory = storeFactory,
        homeFlow = { childContext, output ->
            HomeFlowComponent(
                componentContext = childContext,
                output = output,
                storeFactory = storeFactory
            )
        },
        searchFlow = { childContext, output ->
            SearchFlowComponent(
                componentContext = childContext,
                output = output,
                storeFactory = storeFactory
            )
        },
        watchListFlow = { childContext, output ->
            WatchListFlowComponent(
                componentContext = childContext,
                output = output,
                storeFactory = storeFactory
            )
        }
    )

    private fun <C : Any> StackNavigation<C>.replaceAll(configuration: C) {
        navigate {
            listOf(configuration)
        }
    }


    override fun bottomNavItemClicked(index: Int) {
        navigation.replaceAll(
            when (index) {
                0 -> Configuration.HomeFlowConf
                1 -> Configuration.SearchFlowConf
                2 -> Configuration.WatchListFlowConf
                else -> Configuration.HomeFlowConf//TODO() WTF
            }
        )
        store.accept(MainStore.Intent.ChangeSelectedBottomNavItem(index))
    }

    private val navigation = StackNavigation<Configuration>()

    private val stack =
        childStack(
            source = navigation,
            initialConfiguration = Configuration.HomeFlowConf,
            handleBackButton = true,
            childFactory = ::createChild,
            key = "MainRouter"
        )

    override val childStack: Value<ChildStack<*, Child>> = stack

    private fun createChild(configuration: Configuration, componentContext: ComponentContext): Child {
        return when (configuration) {
            is Configuration.HomeFlowConf -> Child.HomeFlowCh(homeFlow(componentContext, Consumer(::onHomeFlowOutput)))
            is Configuration.SearchFlowConf -> Child.SearchFlowCh(
                searchFlow(
                    componentContext,
                    Consumer(::onSearchFlowOutput)
                )
            )

            is Configuration.WatchListFlowConf -> Child.WatchListFlowCh(
                watchListFlow(
                    componentContext,
                    Consumer(::onWatchListFlowOutput)
                )
            )
        }
    }

    private fun onHomeFlowOutput(output: HomeFlow.Output): Unit =
        when (output) {
            else -> {}
        }

    private fun onSearchFlowOutput(output: SearchFlow.Output): Unit =
        when (output) {
            else -> {}
        }

    private fun onWatchListFlowOutput(output: WatchListFlow.Output): Unit =
        when (output) {
            else -> {}
        }


    private sealed class Configuration : Parcelable {
        @Parcelize
        object HomeFlowConf : Configuration()
        @Parcelize
        object SearchFlowConf : Configuration()
        @Parcelize
        object WatchListFlowConf : Configuration()
    }

}