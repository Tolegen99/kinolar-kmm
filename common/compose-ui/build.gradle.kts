plugins {
    id("multiplatform-compose-setup")
    id("android-setup")
}

kotlin {
    sourceSets {
        named("commonMain") {
            dependencies {
                implementation(project(":common:utils"))
                implementation(project(":common:root"))
                implementation(project(":common:main"))
                implementation(Deps.ArkIvanov.Decompose.decompose)
                implementation(Deps.ArkIvanov.Decompose.extensionsComposeJetbrains)
                implementation(Deps.Desktop.DatePicker.lGoodDatePicker)
                implementation(Deps.JetBrains.Date.date)
                implementation(Deps.Network.Ktor.clientCio)
                implementation(compose.desktop.currentOs)
            }
        }
    }
}