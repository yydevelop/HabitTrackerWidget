// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
}
plugins {
    id("com.android.application")
    kotlin("android")
}
repositories {
    google()  // GoogleのMavenリポジトリを追加
    mavenCentral() // Maven Centralを追加
}
