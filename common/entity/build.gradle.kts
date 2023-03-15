plugins {
    id("multiplatform-setup")
    id("android-setup")
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(Deps.JetBrains.Date.date)
                implementation(Deps.Settings.settings)
                implementation(Deps.JetBrains.Kotlinx.Serialization.serialization)

            }
        }
    }
}
