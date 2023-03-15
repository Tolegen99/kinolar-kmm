package kz.tolegen.kinolarkmm.common.watch.list

import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value
import kz.tolegen.kinolarkmm.common.api.entity.response.MovieResponse
import kz.tolegen.kinolarkmm.common.entity.entity.MovieData
import kz.tolegen.kinolarkmm.common.entity.entity.MovieDataStub

interface WatchList {

    val childStack: Value<ChildStack<*, Child>>

    val models: Value<Model>
    fun onClear()

    sealed class Child {
        object Stub: Child()
    }

    sealed class Output {
        object Stub: Output()
    }

    data class Model(
        val movies: List<MovieDataStub>
    )
}