plugins {
    id("multiplatform-compose-setup")
    id("android-setup")
}

kotlin {
    sourceSets {
        named("commonMain") {
            dependencies {
                implementation(project(":common:utils"))
                implementation(project(":common:entity"))
                implementation(project(":common:root"))
                implementation(project(":common:main"))
                implementation(project(":common:home-flow"))
                implementation(project(":common:search-flow"))
                implementation(project(":common:watch-list-flow"))
                implementation(project(":common:watch-list"))
                implementation(Deps.ArkIvanov.Decompose.decompose)
                implementation(Deps.ArkIvanov.Decompose.extensionsComposeJetbrains)
                implementation(Deps.Desktop.DatePicker.lGoodDatePicker)
                implementation(Deps.JetBrains.Date.date)
                implementation(Deps.Network.Ktor.clientCio)
                implementation(compose.desktop.currentOs)
            }
        }

        named("androidMain") {
            dependencies {
                // Workaround for https://github.com/JetBrains/compose-jb/issues/2340
                implementation("androidx.compose.foundation:foundation:${Deps.JetpackComposeWorkaround.VERSION}")
            }
        }
    }
}
android {
    sourceSets["main"].res.srcDirs(
        "src/commonMain/resources",
        "src/androidMain/resources"
    )
}