package kz.tolegen.kinolarkmm.android

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        val root = todoRoot(defaultComponentContext())

        setContent {
            ComposeAppTheme {
                Surface(color = MaterialTheme.colors.background) {
//                    TodoRootContent(root)
                }
            }
        }
    }

//    private fun todoRoot(componentContext: ComponentContext): TodoRoot =
//        TodoRootComponent(
//            componentContext = componentContext,
//            storeFactory = LoggingStoreFactory(TimeTravelStoreFactory()),
//            database = DefaultTodoSharedDatabase(TodoDatabaseDriver(context = this))
//        )
}