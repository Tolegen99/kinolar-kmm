plugins {
    `kotlin-dsl`
}

repositories {
    mavenLocal()
    google()
    mavenCentral()
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
}

dependencies {
//    implementation(Deps.JetBrains.Compose.gradlePlugin)
//    implementation(Deps.JetBrains.Kotlin.gradlePlugin)
//    implementation(Deps.Android.Tools.Build.gradlePlugin)
//    implementation(Deps.Squareup.SQLDelight.gradlePlugin)
    implementation("org.jetbrains.compose:compose-gradle-plugin:1.2.0-rc02")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.7.10")
    implementation("com.android.tools.build:gradle:7.2.2")
    implementation("com.squareup.sqldelight:gradle-plugin:1.5.3")
}

kotlin {
    // Add Deps to compilation, so it will become available in main project
    sourceSets.getByName("main").kotlin.srcDir("buildSrc/src/main/kotlin")
}
