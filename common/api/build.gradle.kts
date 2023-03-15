plugins {
    id("multiplatform-setup")
    id("android-setup")
    kotlin("plugin.serialization") version "1.7.0"
}

kotlin {
    sourceSets {
        named("commonMain") {
            dependencies {
                implementation(project(":common:entity"))
                implementation(Deps.ArkIvanov.Decompose.decompose)
                implementation(Deps.ArkIvanov.MVIKotlin.mvikotlin)
                implementation(Deps.ArkIvanov.MVIKotlin.mvikotlinExtensionsReaktive)
                implementation(Deps.Badoo.Reaktive.reaktive)
                implementation(Deps.Network.Ktor.clientCore)
                implementation(Deps.Network.Ktor.clientSerialization) // check for usage
                implementation(Deps.Network.Ktor.clientCio)
                implementation(Deps.Network.Ktor.contentNegotiation)
                implementation(Deps.Network.Ktor.clientAuth)
                implementation(Deps.Network.Ktor.clientLogging)
                implementation(Deps.Network.Logback.classic)
                implementation(Deps.JetBrains.Kotlinx.Serialization.serialization)
                implementation(Deps.Napier.napier)
            }
        }
    }
}
