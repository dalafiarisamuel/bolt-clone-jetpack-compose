object Dependencies {
    private const val kotlinStandardLibrary =
        "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}"
    private const val ktx = "androidx.core:core-ktx:${Versions.ktx}"
    private const val androidxAnnotation =
        "androidx.annotation:annotation:${Versions.androidxAnnotation}"
    private const val kotlinCoroutineAndroid =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.kotlinCoroutineVersion}"
    private const val kotlinCoroutineCore =
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.kotlinCoroutineVersion}"
    private const val retrofit2 = "com.squareup.retrofit2:retrofit:${Versions.retrofit2}"
    private const val retrofitMoshiConverter =
        "com.squareup.retrofit2:converter-moshi:${Versions.retrofit2ConverterMoshi}"
    private const val moshiKotlin = "com.squareup.moshi:moshi-kotlin:${Versions.moshiKotlin}"
    private const val roomRuntime = "androidx.room:room-runtime:${Versions.room}"
    private const val roomKtx = "androidx.room:room-ktx:${Versions.room}"
    private const val hiltAndroid = "com.google.dagger:hilt-android:${Versions.hiltVersion}"
    private const val javaxInject = "javax.inject:javax.inject:${Versions.javaxInject}"
    private const val hiltWorker = "androidx.hilt:hilt-work:${Versions.hiltWorker}"
    private const val workManager = "androidx.work:work-runtime-ktx:${Versions.workManager}"
    private const val workManagerSupport = "androidx.work:work-gcm:${Versions.workManager}"
    private const val loggingInterceptor =
        "com.squareup.okhttp3:logging-interceptor:${Versions.loggingInterceptor}"
    private const val okHttp = "com.squareup.okhttp3:okhttp:${Versions.okHttp}"
    private const val retroMock = "co.infinum:retromock:${Versions.retroMock}"
    private const val androidLifecycleRuntime =
        "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.androidLifecycle}"
    private const val lifecycleViewModel =
        "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.androidLifecycle}"
    private const val lifecycleExtension =
        "androidx.lifecycle:lifecycle-extensions:${Versions.lifecycleExtension}"
    private const val androidxPagingRuntime =
        "androidx.paging:paging-runtime:${Versions.androidxPagingRuntime}"
    private const val splashscreen = "androidx.core:core-splashscreen:1.0.0-beta02"


    object ComposeDependencies {

        private const val composeUi = "androidx.compose.ui:ui:${Versions.composeVersion}"
        private const val composeMaterial =
            "androidx.compose.material:material:${Versions.composeVersion}"
        private const val composeRuntimeLiveData =
            "androidx.compose.runtime:runtime-livedata:${Versions.composeVersion}"
        private const val composeUiToolingPreview =
            "androidx.compose.ui:ui-tooling-preview:${Versions.composeVersion}"
        private const val composePaging = "androidx.paging:paging-compose:1.0.0-alpha14"
        private const val composeActivity = "androidx.activity:activity-compose:1.4.0"
        private const val composeViewModel = "androidx.lifecycle:lifecycle-viewmodel-compose:2.4.1"
        private const val coilCompose = "io.coil-kt:coil-compose:1.4.0"
        private const val composeNavigation = "androidx.navigation:navigation-compose:2.4.0"
        private const val composeConstraintLayout = "androidx.constraintlayout:constraintlayout-compose:1.0.1"

        val implementations = listOf(
            composeUi,
            composeMaterial,
            composeRuntimeLiveData,
            composeUiToolingPreview,
            composePaging,
            composeActivity,
            composeViewModel,
            coilCompose,
            composeNavigation,
            composeConstraintLayout
        )


    }

    val implementations = listOf(
        kotlinStandardLibrary,
        ktx,
        androidxAnnotation,
        kotlinCoroutineAndroid,
        kotlinCoroutineCore,
        hiltAndroid,
        javaxInject,
        /*hiltViewModel,*/
        hiltWorker,
        workManager,
        workManagerSupport,
        androidLifecycleRuntime,
        lifecycleViewModel,
        lifecycleExtension,
        androidxPagingRuntime,
        splashscreen
    ) + ComposeDependencies.implementations


    val remoteImplementation = listOf(
        kotlinStandardLibrary,
        ktx,
        androidxAnnotation,
        kotlinCoroutineAndroid,
        kotlinCoroutineCore,
        retrofit2,
        retrofitMoshiConverter,
        moshiKotlin,
        hiltAndroid,
        javaxInject,
        loggingInterceptor,
        okHttp,
        retroMock,
    )


    val cacheImplementation = listOf(
        kotlinStandardLibrary,
        ktx,
        hiltAndroid,
        roomRuntime,
        roomKtx,
        javaxInject,
        androidxAnnotation,
        kotlinCoroutineAndroid,
        kotlinCoroutineCore,
    )

    val domainImplementation = listOf(
        kotlinCoroutineCore,
        kotlinStandardLibrary,
        moshiKotlin,
        retrofitMoshiConverter,
        javaxInject,
    )

    val dataImplementation = listOf(
        kotlinCoroutineCore,
        kotlinStandardLibrary,
        javaxInject,
    )

    val coreImplementations = listOf(
        kotlinStandardLibrary,
        androidxAnnotation,
        kotlinCoroutineAndroid,
        kotlinCoroutineCore,
        retrofit2,
        retrofitMoshiConverter,
        moshiKotlin,
        roomRuntime,
        roomKtx,
        hiltAndroid,
        javaxInject,
        hiltWorker,
        workManager,
        workManagerSupport,
        loggingInterceptor,
        okHttp,
        retroMock
    )
}