plugins {
    id(Plugins.androidApplication)
    id(Plugins.kotlinAndroid)
    id(Plugins.googleServices)
    id(Plugins.firebaseCrashlytics)
    kotlin(Plugins.kapt)
    id(Plugins.hilt)
    id(Plugins.navigation)
}

android {
    compileSdk = ConfigData.compileSdkVersion

    defaultConfig {
        applicationId = "com.mksoftware101.personalnotes"
        minSdk = ConfigData.minSdkVersion
        targetSdk = ConfigData.targetSdkVersion
        versionCode = ConfigData.versionCode
        versionName = ConfigData.versionName

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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        dataBinding = true
    }
}

dependencies {
    implementation(Deps.coreKtx)
    implementation(Deps.appCompat)
    implementation(Deps.material)
    implementation(Deps.constraintLayout)
    implementation(Deps.fragmentKtx)
    implementation(Deps.swipeRefreshLayout)
    implementation(Deps.coreSplashScreen)

    // Logging
    implementation(Deps.logging)

    // Firebase
    implementation(platform(Deps.Firebase.bom))
    implementation(Deps.Firebase.analyticsKtx)
    implementation(Deps.Firebase.crashlyticsKtx)

    // Hilt
    implementation(Deps.DI.hilt)
    kapt(Deps.DI.hiltCompiler)

    // DB
    implementation(Deps.DB.room)
    annotationProcessor(Deps.DB.roomCompiler)
    kapt(Deps.DB.roomCompiler)
    implementation(Deps.DB.roomKtx)

    // Coroutines
    implementation(Deps.Coroutines.core)
    implementation(Deps.Coroutines.android)

    // Lifecycle
    implementation(Deps.Lifecycle.viewModelKtx)

    // Navigation
    implementation(Deps.Navigation.fragmentKtx)
    implementation(Deps.Navigation.uiKtx)

    // Binding collection adapter
    implementation(Deps.BindingCollectionAdapter.core)
    implementation(Deps.BindingCollectionAdapter.recyclerView)

    // Tests
    testImplementation(TestDeps.junit)
    androidTestImplementation(TestDeps.androidExtJunit)
    androidTestImplementation(TestDeps.espresso)
}

kapt {
    correctErrorTypes = true
}