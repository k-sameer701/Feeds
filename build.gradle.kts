// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
//    alias(libs.plugins.jetbrains.kotlin.android) apply false
    alias(libs.plugins.org.jetbrains.kotlin.android) apply false

    // DAGGER-HILT
    alias(libs.plugins.dagger.hilt) apply false
    // SERIALIZATION
    alias(libs.plugins.jetbrains.kotlin.serialization) apply false
    // COMPOSE-COMPILER
    alias(libs.plugins.compose.compiler) apply false
}