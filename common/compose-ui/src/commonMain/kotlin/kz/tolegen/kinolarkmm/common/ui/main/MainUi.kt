package kz.tolegen.kinolarkmm.common.ui.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.extensions.compose.jetbrains.subscribeAsState
import kz.tolegen.kinolarkmm.common.main.integration.MainComponent
import kz.tolegen.kinolarkmm.common.ui.theme.AppTheme

@Composable
fun MainContent(component: MainComponent) {
    val model by component.models.subscribeAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(AppTheme.colors.background)
    ) {
    }
}