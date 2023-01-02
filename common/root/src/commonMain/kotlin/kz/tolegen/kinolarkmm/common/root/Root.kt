package kz.tolegen.kinolarkmm.common.root

import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value
import kz.tolegen.kinolarkmm.common.main.integration.MainComponent

interface Root {

    val childStack: Value<ChildStack<*, Child>>

    sealed class Child {
        data class Main(val component: MainComponent) : Child()
    }
}