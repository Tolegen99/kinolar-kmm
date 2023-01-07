package kz.tolegen.kinolarkmm.common.ui.watchListFlow.watchList

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.arkivanov.decompose.extensions.compose.jetbrains.subscribeAsState
import kz.tolegen.kinolarkmm.common.watch.list.WatchList

@Composable
fun WatchListContent(component: WatchList) {
    val model by component.models.subscribeAsState()

    Box(modifier = Modifier.fillMaxSize().background(Color.Transparent)){
        Text("WatchList")
    }

}