package kz.tolegen.kinolarkmm.android

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.defaultComponentContext
import com.arkivanov.mvikotlin.logging.store.LoggingStoreFactory
import com.arkivanov.mvikotlin.timetravel.store.TimeTravelStoreFactory
import kz.tolegen.kinolarkmm.common.root.integration.RootComponent
import kz.tolegen.kinolarkmm.common.ui.root.RootContent

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val root = root(defaultComponentContext())

        setContent {
            Surface(modifier = Modifier.fillMaxSize()) {
                MaterialTheme {
                    RootContent(root)
                }
            }
        }
    }

    private fun root(componentContext: ComponentContext) =
        RootComponent(
            componentContext = componentContext,
            storeFactory = LoggingStoreFactory(TimeTravelStoreFactory()),
        )
}