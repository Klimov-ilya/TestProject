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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = ConfigData.jvmTarget
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    implementation(CoreLibs.core)
    implementation(CoreLibs.appcompat)
    implementation(DesignLibs.material)
    implementation(DesignLibs.constraint)
    implementation(JetpackLibs.livedataKtx)
    implementation(JetpackLibs.viewModelKtx)
    implementation(NavigationLibs.cicerone)

    implementation(NetworkLibs.loggingInterceptor)
    implementation(NetworkLibs.retrofit)
    implementation(NetworkLibs.retrofitMoshi)
    implementation(NetworkLibs.moshi)

    implementation(DiLibs.koin)
}