import org.jetbrains.compose.desktop.application.dsl.TargetFormat

plugins {
    kotlin("multiplatform") // kotlin("jvm") doesn't work well in IDEA/AndroidStudio (https://github.com/JetBrains/compose-jb/issues/22)
    id("org.jetbrains.compose")
}

kotlin {
    jvm {
        withJava()
    }

    sourceSets {
        named("jvmMain") {
            dependencies {
                implementation(project(":common:root"))
                implementation(project(":common:compose-ui"))
                implementation(project(":common:api"))
                implementation(compose.desktop.currentOs)
                implementation(Deps.Settings.settings)
                implementation(Deps.ArkIvanov.Decompose.decompose)
                implementation(Deps.ArkIvanov.Decompose.extensionsComposeJetbrains)
                implementation(Deps.ArkIvanov.MVIKotlin.mvikotlin)
                implementation(Deps.ArkIvanov.MVIKotlin.mvikotlinMain)
                implementation(Deps.ArkIvanov.MVIKotlin.mvikotlinLogging)
                implementation(Deps.ArkIvanov.MVIKotlin.mvikotlinTimeTravel)
                implementation(Deps.Badoo.Reaktive.reaktive)
                implementation(Deps.Badoo.Reaktive.coroutinesInterop)
                implementation(Deps.Network.Ktor.clientCio)
                implementation(Deps.Napier.napier)
            }
        }
    }
}

compose.desktop {
    application {
        mainClass = "kz.tolegen.kinolarkmm.desktop.MainKt"

        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "KinolarKmm"
            packageVersion = "1.0.0"

            modules("java.sql")

            windows {
                menuGroup = "KinolarKmm"
                // see https://wixtoolset.org/documentation/manual/v3/howtos/general/generate_guids.html
                upgradeUuid = "BF9CDA6A-1391-46D5-9ED5-383D6E68CCEB"
            }
        }
    }
}