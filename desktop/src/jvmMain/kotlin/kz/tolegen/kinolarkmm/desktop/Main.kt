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
import com.arkivanov.mvikotlin.timetravel.server.TimeTravelServer
import com.badoo.reaktive.coroutinesinterop.asScheduler
import com.badoo.reaktive.scheduler.overrideSchedulers
import io.ktor.client.engine.cio.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kz.tolegen.kinolarkmm.common.api.ApiImpl
import kz.tolegen.kinolarkmm.common.root.Root
import kz.tolegen.kinolarkmm.common.root.integration.RootComponent
import kz.tolegen.kinolarkmm.common.ui.root.RootContent
import javax.swing.SwingUtilities

@OptIn(ExperimentalCoroutinesApi::class)
fun main() = application {
    overrideSchedulers(main = Dispatchers.Main::asScheduler)
    val lifecycle = LifecycleRegistry()

    val windowState = rememberWindowState()

    val root = root(DefaultComponentContext(lifecycle = lifecycle))

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
    TimeTravelServer(
        runOnMainThread = {
            SwingUtilities.invokeLater(it)
        }
    ).start()
}

private fun root(componentContext: ComponentContext) =
    RootComponent(
        componentContext = componentContext,
        storeFactory = DefaultStoreFactory(),
        api = ApiImpl(httpClientEngine = CIO.create())
    )