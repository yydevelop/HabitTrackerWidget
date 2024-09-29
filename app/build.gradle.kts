plugins {
    alias(libs.plugins.android.application) // これが必要な場合は残します
    alias(libs.plugins.kotlin.android) // これが必要な場合は残します
    alias(libs.plugins.kotlin.kapt)
}
//plugins {
//    id("com.android.application")
//    kotlin("android")
//    kotlin("kapt")
//
////    alias(libs.plugins.android.application) // これが必要な場合は残します
////    alias(libs.plugins.kotlin.android) // これが必要な場合は残します
//
//}

android {
    namespace = "com.example.habitrackerwidget"
    compileSdk = 35
    buildToolsVersion = "35.0.0"

    defaultConfig {
        applicationId = "com.example.habitrackerwidget"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"
    }

    sourceSets {
        getByName("main").manifest.srcFile("src/main/AndroidManifest.xml")
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
        // JVM Toolchainを使用してJavaバージョンを指定
        java {
            toolchain {
                languageVersion.set(JavaLanguageVersion.of(17))
            }
        }
    }

    kotlinOptions {
        jvmTarget = "17"
    }
}
kapt {
    javacOptions {
        option("-source", "17")
        option("-target", "17")
    }
}
//dependencyResolutionManagement {
//    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
//    repositories {
//        google()
//        mavenCentral()
//    }
//}
dependencies {
//    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.9.24")
    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.9.0")

    implementation("androidx.core:core-ktx:1.10.1")
    implementation("androidx.activity:activity-compose:1.7.2")
    implementation("androidx.compose.ui:ui:1.5.0")
    implementation("androidx.compose.material3:material3:1.1.0")
    implementation("androidx.compose.ui:ui-tooling-preview:1.5.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")
    implementation("androidx.compose.foundation:foundation-layout:1.5.0")
    implementation("androidx.compose.foundation:foundation:1.5.0")

    // Roomライブラリの依存関係
//    implementation("androidx.room:room-runtime:2.6.0-alpha01")
//    kapt("androidx.room:room-compiler:2.6.0-alpha01")
//    implementation("androidx.room:room-ktx:2.6.0-alpha01")
    implementation("androidx.room:room-runtime:2.5.0")
    kapt("androidx.room:room-compiler:2.5.0")
    implementation("androidx.room:room-ktx:2.5.0")

    debugImplementation("androidx.compose.ui:ui-tooling:1.5.0")
    debugImplementation("androidx.compose.ui:ui-test-manifest:1.5.0")
}
