package kz.tolegen.kinolarkmm.desktop

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.DefaultComponentContext
import com.arkivanov.decompose.extensions.compose.jetbrains.lifecycle.LifecycleController
import com.arkivanov.essenty.lifecycle.LifecycleRegistry
import com.arkivanov.mvikotlin.main.store.DefaultStoreFactory
import com.badoo.reaktive.coroutinesinterop.asScheduler
import com.badoo.reaktive.scheduler.overrideSchedulers
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kz.tolegen.kinolarkmm.common.root.Root
import kz.tolegen.kinolarkmm.common.root.integration.RootComponent
import kz.tolegen.kinolarkmm.common.ui.root.RootContent

@OptIn(ExperimentalCoroutinesApi::class)
fun main() {
    overrideSchedulers(main = Dispatchers.Main::asScheduler)

    val lifecycle = LifecycleRegistry()
    val root = root(DefaultComponentContext(lifecycle = lifecycle))

    application {
        val windowState = rememberWindowState()
        LifecycleController(lifecycle, windowState)

        Window(
            onCloseRequest = ::exitApplication,
            state = windowState,
            title = "Kinolar-Kmm"
        ) {
            Surface(modifier = Modifier.fillMaxSize()) {
                MaterialTheme {
                    RootContent(root)
                }
            }
        }
    }
}

private fun root(componentContext: ComponentContext) =
    RootComponent(
        componentContext = componentContext,
        storeFactory = DefaultStoreFactory(),
    )