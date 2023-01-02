package kz.tolegen.kinolarkmm.common.main

import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value

interface Main {

    val childStack: Value<ChildStack<*, Child>>

    val models: Value<Model>

    sealed class Child {
        object Stub: Child()
    }

    sealed class Output {
        object Stub: Output()
    }

    data class Model(
        val stub: Boolean
    )
}