plugins {
    id("multiplatform-setup")
    id("android-setup")
    kotlin("plugin.serialization") version "1.7.0"
}

kotlin {

    sourceSets {
        named("commonMain") {
            dependencies {
                implementation(project(":common:api"))
                implementation(project(":common:utils"))
                implementation(project(":common:entity"))
                implementation(Deps.ArkIvanov.Decompose.decompose)
                implementation(Deps.ArkIvanov.MVIKotlin.mvikotlin)
                implementation(Deps.ArkIvanov.MVIKotlin.mvikotlinExtensionsReaktive)
                implementation(Deps.Badoo.Reaktive.reaktive)
                implementation(Deps.Badoo.Reaktive.coroutinesInterop)
                implementation(Deps.Badoo.Reaktive.utils)
                implementation(Deps.Network.Ktor.clientCore)
            }
        }
    }
}