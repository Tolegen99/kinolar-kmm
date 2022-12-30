object Deps {

    object JetpackComposeWorkaround {
        private const val VERSION: String = "1.2.1"
        const val material = "androidx.compose.material:material:$VERSION"
    }

    object JetBrains {
        object Kotlin {
            // __KOTLIN_COMPOSE_VERSION__
            private const val VERSION = "1.7.10"
            const val gradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$VERSION"
            const val testCommon = "org.jetbrains.kotlin:kotlin-test-common:$VERSION"
            const val testJunit = "org.jetbrains.kotlin:kotlin-test-junit:$VERSION"
            const val testJs = "org.jetbrains.kotlin:kotlin-test-js:$VERSION"
            const val testAnnotationsCommon = "org.jetbrains.kotlin:kotlin-test-annotations-common:$VERSION"
        }

        object Date {
            private const val VERSION = "0.4.0"
            const val date = "org.jetbrains.kotlinx:kotlinx-datetime:$VERSION"
        }

        object Kotlinx {
            object Serialization {
                private const val VERSION = "1.4.0"
                private const val VERSION_PLUGIN = "1.7.10"
                const val serialization = "org.jetbrains.kotlinx:kotlinx-serialization-json:$VERSION"
                const val serializationPlugin = "org.jetbrains.kotlin:kotlin-serialization:$VERSION_PLUGIN"
            }

            object Coroutines {
                private const val VERSION = "1.6.4"
                const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$VERSION"
                const val coroutinesSwing = "org.jetbrains.kotlinx:kotlinx-coroutines-swing:$VERSION"
            }
        }

        object Compose {
            // __LATEST_COMPOSE_RELEASE_VERSION__
            private const val VERSION = "1.2.0-rc02"
            const val gradlePlugin = "org.jetbrains.compose:compose-gradle-plugin:$VERSION"
        }
    }

    object Android {
        object Tools {
            object Build {
                private const val VERSION = "7.2.2"
                const val gradlePlugin = "com.android.tools.build:gradle:$VERSION"
            }
        }
    }

    object AndroidX {
        object AppCompat {
            private const val VERSION = "1.5.1"
            const val appCompat = "androidx.appcompat:appcompat:$VERSION"
        }

        object Activity {
            private const val VERSION = "1.6.0"
            const val activityCompose = "androidx.activity:activity-compose:$VERSION"
        }
    }

    object Desktop {
        object DatePicker {
            private const val VERSION = "11.2.1"
            const val lGoodDatePicker = "com.github.lgooddatepicker:LGoodDatePicker:$VERSION"
        }
    }

    object ArkIvanov {
        object MVIKotlin {
            private const val VERSION = "3.0.2"
            const val rx = "com.arkivanov.mvikotlin:rx:$VERSION"
            const val mvikotlin = "com.arkivanov.mvikotlin:mvikotlin:$VERSION"
            const val mvikotlinMain = "com.arkivanov.mvikotlin:mvikotlin-main:$VERSION"
            const val mvikotlinLogging = "com.arkivanov.mvikotlin:mvikotlin-logging:$VERSION"
            const val mvikotlinTimeTravel = "com.arkivanov.mvikotlin:mvikotlin-timetravel:$VERSION"
            const val mvikotlinExtensionsReaktive = "com.arkivanov.mvikotlin:mvikotlin-extensions-reaktive:$VERSION"
        }

        object Decompose {
            private const val VERSION = "0.8.0"
            const val decompose = "com.arkivanov.decompose:decompose:$VERSION"
            const val extensionsComposeJetpack = "com.arkivanov.decompose:extensions-compose-jetpack:$VERSION"
            const val extensionsComposeJetbrains = "com.arkivanov.decompose:extensions-compose-jetbrains:$VERSION"
        }
    }

    object Badoo {
        object Reaktive {
            private const val VERSION = "1.2.2"
            const val reaktive = "com.badoo.reaktive:reaktive:$VERSION"
            const val reaktiveTesting = "com.badoo.reaktive:reaktive-testing:$VERSION"
            const val utils = "com.badoo.reaktive:utils:$VERSION"
            const val coroutinesInterop = "com.badoo.reaktive:coroutines-interop:$VERSION"
        }
    }

    object Squareup {
        object SQLDelight {
            private const val VERSION = "1.5.3"

            const val gradlePlugin = "com.squareup.sqldelight:gradle-plugin:$VERSION"
            const val androidDriver = "com.squareup.sqldelight:android-driver:$VERSION"
            const val sqliteDriver = "com.squareup.sqldelight:sqlite-driver:$VERSION"
            const val nativeDriver = "com.squareup.sqldelight:native-driver:$VERSION"
            const val sqljsDriver = "com.squareup.sqldelight:sqljs-driver:$VERSION"
        }
    }

    object Bcrypt {
        private const val VERSION = "2.3.0"

        const val bcrypt = "de.nycode:bcrypt:$VERSION"
    }

    object Napier {
        private const val VERSION = "2.6.1"

        const val napier = "io.github.aakira:napier:$VERSION"
    }

    object Settings {
        private const val VERSION = "1.0.0-RC"
        const val settings = "com.russhwolf:multiplatform-settings:$VERSION"
    }


    object Network {
        object Ktor {
            private const val VERSION = "2.1.3"

            const val network = "io.ktor:ktor-network:$VERSION"
            const val clientCore = "io.ktor:ktor-client-core:$VERSION"
            const val clientSerialization = "io.ktor:ktor-serialization-kotlinx-json:$VERSION"
            const val clientCio = "io.ktor:ktor-client-cio:$VERSION"
            const val clientAuth = "io.ktor:ktor-client-auth:$VERSION"
            const val clientLogging = "io.ktor:ktor-client-logging:$VERSION"
            const val utils = "io.ktor:ktor-utils:$VERSION"
            const val io = "io.ktor:ktor-io:$VERSION"
            const val contentNegotiation = "io.ktor:ktor-client-content-negotiation:$VERSION"
        }

        object Logback {
            private const val VERSION = "1.4.3"

            const val classic = "ch.qos.logback:logback-classic:$VERSION"
        }
    }

    object JxMapViewer {
        private const val VERSION = "2.6"

        const val jxMapViewer = "org.jxmapviewer:jxmapviewer2:$VERSION"
    }

    object UUID {
        private const val VERSION = "0.5.0"

        const val uuid = "com.benasher44:uuid:$VERSION"
    }
}
