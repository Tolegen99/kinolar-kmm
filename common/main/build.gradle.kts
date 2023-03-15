plugins {
    id("multiplatform-setup")
    id("android-setup")
    id("kotlin-parcelize")
}

kotlin {

    sourceSets {
        named("commonMain") {
            dependencies {
                implementation(project(":common:api"))
                implementation(project(":common:utils"))
                implementation(project(":common:home-flow"))
                implementation(project(":common:search-flow"))
                implementation(project(":common:watch-list-flow"))
                implementation(Deps.JetBrains.Date.date)
                implementation(Deps.JetBrains.Kotlinx.Coroutines.coroutines)
                implementation(Deps.JetBrains.Kotlinx.Coroutines.coroutinesSwing)
                implementation(Deps.ArkIvanov.MVIKotlin.mvikotlin)
                implementation(Deps.ArkIvanov.MVIKotlin.mvikotlinExtensionsReaktive)
                implementation(Deps.ArkIvanov.Decompose.decompose)
                implementation(Deps.Badoo.Reaktive.reaktive)
                implementation(Deps.Badoo.Reaktive.utils)
            }
        }
    }
}
