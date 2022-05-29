object CoreLibs {
    val core by lazy { "androidx.core:core-ktx:${Versions.CORE_VERSION}" }
    val appcompat by lazy { "androidx.appcompat:appcompat:${Versions.APPCOMPAT_VERSION}" }
}

object DesignLibs {
    val material by lazy { "com.google.android.material:material:${Versions.MATERIAL_VERSION}" }
    val constraint by lazy { "androidx.constraintlayout:constraintlayout:${Versions.CONSTRAINT_VERSION}" }
}

object ComposeLibs {
    val activityCompose by lazy { "androidx.activity:activity-compose:${Versions.COMPOSE_ACTIVITY_VERSION}" }
    val ui by lazy { "androidx.compose.ui:ui:${Versions.COMPOSE_VERSION}" }
    val material by lazy { "androidx.compose.material:material:${Versions.COMPOSE_VERSION}" }
    val uiToolingPreview by lazy { "androidx.compose.ui:ui-tooling-preview:${Versions.COMPOSE_VERSION}" }
    val uiTooling by lazy { "androidx.compose.ui:ui-tooling:${Versions.COMPOSE_VERSION}" }
}

object NetworkLibs {
    val retrofit by lazy { "com.squareup.retrofit2:retrofit:${Versions.RETROFIT_VERSION}" }
    val moshi by lazy { "com.squareup.moshi:moshi-kotlin:${Versions.MOSHI_VERSION}" }
    val retrofitMoshi by lazy { "com.squareup.retrofit2:converter-moshi:${Versions.RETROFIT_VERSION}" }
    val loggingInterceptor by lazy { "com.squareup.okhttp3:logging-interceptor:${Versions.LOGGING_INTERCEPTOR_VERSION}" }
}

object JetpackLibs {
    val lifecycle by lazy { "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.LIFECYCLE_KTX_VERSION}" }
    val livedataKtx by lazy { "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.LIFECYCLE_LIVEDATA_KTX_VERSION}" }
    val viewModelKtx by lazy { "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.LIFECYCLE_VIEW_MODEL_KTX_VERSION}" }
}

object DiLibs {
    val koin by lazy { "io.insert-koin:koin-android:${Versions.KOIN_ANDROID_VERSION}" }
}

object NavigationLibs {
    val cicerone by lazy { "com.github.terrakok:cicerone:${Versions.CICERONE_VERSION}" }
}