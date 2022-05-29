plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    compileSdk = ConfigData.compileSdkVersion

    defaultConfig {
        minSdk = ConfigData.minSdkVersion
        targetSdk = ConfigData.targetSdkVersion

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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

    api(CoreLibs.core)
    api(CoreLibs.appcompat)
    api(DesignLibs.material)

    api(NavigationLibs.cicerone)

    api(NetworkLibs.retrofit)
    api(NetworkLibs.loggingInterceptor)
    api(NetworkLibs.retrofitMoshi)
    api(NetworkLibs.moshi)

    api(JetpackLibs.viewModelKtx)
    api(JetpackLibs.livedataKtx)
    api(JetpackLibs.lifecycle)

    api(DiLibs.koin)
}