package kz.tolegen.kinolarkmm.common.watch.list

import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value

interface WatchList {

    val childStack: Value<ChildStack<*, Child>>

    val models: Value<Model>

    sealed class Child {
        object Stub: Child()
    }

    sealed class Output {
        object Stub: Output()
    }

    data class Model(
        val movies: List<String> //TODO() change to MovieData
    )
}