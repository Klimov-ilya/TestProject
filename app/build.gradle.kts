plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-parcelize")
}

android.run {
    compileSdk = ConfigData.compileSdkVersion

    defaultConfig {
        applicationId = ConfigData.applicationId
        minSdk = ConfigData.minSdkVersion
        targetSdk = ConfigData.targetSdkVersion
        versionCode = ConfigData.versionCode
        versionName = ConfigData.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = ConfigData.JavaVersion
        targetCompatibility = ConfigData.JavaVersion
    }
    kotlinOptions {
        jvmTarget = ConfigData.jvmTarget
    }
    buildFeatures {
        viewBinding = ConfigData.isEnableViewBinding
    }
}

dependencies {
    implementation(project(":recipe"))
    implementation(project(":dashboard"))
    implementation(project(":core"))
    implementation(project(":welcome"))
}