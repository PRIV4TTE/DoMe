plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.gms.google-services")
}

android {
    namespace = "com.example.dome"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.dome"
        minSdk = 21
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        kotlinCompilerExtensionVersion = "1.4.3"
    }
}

dependencies {
        implementation("androidx.core:core-ktx:1.7.0")
        implementation("androidx.appcompat:appcompat:1.4.0")
        implementation("androidx.compose.ui:ui:1.1.0-beta03")
        implementation("androidx.compose.foundation:foundation:1.1.0-beta03")
        implementation("androidx.compose.material:material:1.1.0-beta03")
        implementation("androidx.compose.runtime:runtime:1.1.0-beta03")
        implementation("androidx.compose.animation:animation:1.1.0-beta03")
        implementation("androidx.compose.material3:material3:1.2.0-alpha01")
        implementation("com.google.android.material:material:1.4.0")
        implementation("com.google.android.material:compose-theme-adapter:1.1.0")
        implementation("com.google.accompanist:accompanist-appcompat-theme:0.20.0")
        implementation("androidx.constraintlayout:constraintlayout:2.1.2")
        testImplementation("junit:junit:4.13.2")
        androidTestImplementation("androidx.test.ext:junit:1.1.3")
        androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
        implementation(platform("com.google.firebase:firebase-bom:32.6.0"))
        implementation("com.google.firebase:firebase-analytics")
    }

