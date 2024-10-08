plugins {
    alias(libs.plugins.android.application)
//    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.org.jetbrains.kotlin.android)
    // DAGGER-HILT
    id("kotlin-kapt")
    alias(libs.plugins.dagger.hilt)
    // COMPOSE-NAVIGATION
    alias(libs.plugins.jetbrains.kotlin.serialization)
    id("kotlin-parcelize") // needed only for non-primitive classes

    // COMPOSE-COMPILER
    alias(libs.plugins.compose.compiler)
}

android {
    namespace = "com.example.feeds"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.feeds"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

// DAGGER-HILT
// Allow references to generated code
kapt {
    correctErrorTypes = true
}


dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    // DAGGER-HILT
    implementation(libs.dagger.hilt.android)
    kapt(libs.dagger.hilt.compiler)

    // RETROFIT
    implementation(libs.retrofit){
        exclude(module = "okhttp")
    }
    implementation(libs.retrofit.converter.gson)
    implementation(libs.retrofit.okhttp)
    implementation(libs.retrofit.urlConnection)
    implementation(libs.retrofit.logging)

    // GSON
    implementation(libs.gson)

    // FIREBASE
    implementation(libs.firebase.crashlytics.buildtools)

    //  HILT VIEW MODEL
    implementation(libs.dagger.hilt.compose)

    // COIL
    implementation(libs.coil)

    // COMPOSE-NAVIGATION
    implementation(libs.androidx.navigation.compose)
    implementation(libs.kotlinx.serialization.json)

    // CONSTRAINT-LAYOUT
    implementation(libs.compose.constraint)

    // ROOM
    implementation(libs.room.runtime)
    annotationProcessor(libs.room.compiler)
    kapt(libs.room.kapt)
    implementation(libs.room.ktx)
}