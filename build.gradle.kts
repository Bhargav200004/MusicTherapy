// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.2.2" apply false
    id("org.jetbrains.kotlin.android") version "1.9.0" apply false
    id("org.jetbrains.kotlin.plugin.serialization") version "1.7.10"
    //For Dagger hilt for dependency injection
    id("com.google.dagger.hilt.android") version "2.48" apply false
    //for ksp tool (Kotlin Annotation Process)
    id("com.google.devtools.ksp") version "1.9.10-1.0.13" apply false
}