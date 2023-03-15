package kz.tolegen.kinolarkmm.common.root.integration

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.value.Value
import com.arkivanov.essenty.parcelable.Parcelable
import com.arkivanov.essenty.parcelable.Parcelize
import com.arkivanov.mvikotlin.core.store.StoreFactory
import com.badoo.reaktive.base.Consumer
import kz.tolegen.kinolarkmm.common.main.Main
import kz.tolegen.kinolarkmm.common.api.Api
import kz.tolegen.kinolarkmm.common.main.integration.MainComponent
import kz.tolegen.kinolarkmm.common.root.Root
import kz.tolegen.kinolarkmm.common.root.Root.Child
import kz.tolegen.kinolarkmm.common.utils.Consumer

class RootComponent internal constructor(
    componentContext: ComponentContext,
    private val main: (ComponentContext, Consumer<Main.Output>) -> MainComponent

) : Root, ComponentContext by componentContext {

    constructor(
        componentContext: ComponentContext,
        storeFactory: StoreFactory,
        api: Api
    ) : this(
        componentContext = componentContext,
        main = { childContext, output ->
            MainComponent(
                componentContext = childContext,
                output = output,
                api = api,
                storeFactory = storeFactory,
            )
        }
    )

    private val navigation = StackNavigation<Configuration>()

    private val stack = childStack(
        source = navigation,
        initialConfiguration = Configuration.Main,
        handleBackButton = true,
        childFactory = ::createChild
    )

    override val childStack: Value<ChildStack<*, Child>> = stack

    private fun createChild(configuration: Configuration, componentContext: ComponentContext): Child =
        when (configuration) {
            Configuration.Main -> Child.Main(
                main(
                    componentContext,
                    Consumer(::onMainOutput)
                )
            )
        }

    private fun onMainOutput(output: Main.Output): Unit =
        when (output) {
            is Main.Output.Stub -> TODO()
        }

    private sealed class Configuration : Parcelable {
        @Parcelize
        object Main : Configuration()
    }
}