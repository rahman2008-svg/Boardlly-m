plugins {
alias(libs.plugins.android.application)
alias(libs.plugins.kotlin.compose)
alias(libs.plugins.google.devtools.ksp)
alias(libs.plugins.roborazzi)
alias(libs.plugins.secrets)
}

android {
namespace = "com.example"
compileSdk = 36

defaultConfig {
    applicationId = "com.aistudio.boardly.wbzkpt"
    minSdk = 24
    targetSdk = 36
    versionCode = 1
    versionName = "1.0"

    testInstrumentationRunner =
        "androidx.test.runner.AndroidJUnitRunner"
}

signingConfigs {
    create("debugConfig") {
        storeFile = file("${rootDir}/debug.keystore")
        storePassword = "android"
        keyAlias = "androiddebugkey"
        keyPassword = "android"
    }
}

buildTypes {
    release {
        isMinifyEnabled = false
        isShrinkResources = false
        isCrunchPngs = false

        proguardFiles(
            getDefaultProguardFile(
                "proguard-android-optimize.txt"
            ),
            "proguard-rules.pro"
        )

        signingConfig =
            signingConfigs.getByName("debugConfig")
    }

    debug {
        signingConfig =
            signingConfigs.getByName("debugConfig")
    }
}

compileOptions {
    sourceCompatibility =
        JavaVersion.VERSION_11

    targetCompatibility =
        JavaVersion.VERSION_11
}

buildFeatures {
    compose = true
    buildConfig = true
}

testOptions {
    unitTests {
        isIncludeAndroidResources = true
    }
}

packaging {
    resources {
        excludes +=
            "/META-INF/{AL2.0,LGPL2.1}"
    }
}

}

secrets {
propertiesFileName = ".env"
defaultPropertiesFileName = ".env.example"
}

dependencies {

implementation(platform(libs.androidx.compose.bom))
implementation(platform(libs.firebase.bom))

implementation(libs.androidx.activity.compose)
implementation(libs.androidx.compose.material3)
implementation(libs.androidx.compose.material.icons.core)
implementation(libs.androidx.compose.material.icons.extended)
implementation(libs.androidx.compose.ui)
implementation(libs.androidx.compose.ui.graphics)
implementation(libs.androidx.compose.ui.tooling.preview)

implementation(libs.androidx.core.ktx)

implementation(libs.androidx.lifecycle.runtime.ktx)
implementation(libs.androidx.lifecycle.runtime.compose)
implementation(libs.androidx.lifecycle.viewmodel.compose)

implementation(libs.androidx.room.runtime)
implementation(libs.androidx.room.ktx)

implementation(libs.coil.compose)

implementation(libs.retrofit)
implementation(libs.converter.moshi)

implementation(libs.okhttp)
implementation(libs.logging.interceptor)

implementation(libs.moshi.kotlin)

implementation(libs.kotlinx.coroutines.core)
implementation(libs.kotlinx.coroutines.android)

testImplementation(libs.junit)
testImplementation(libs.androidx.junit)
testImplementation(libs.androidx.core)
testImplementation(libs.kotlinx.coroutines.test)

testImplementation(libs.robolectric)
testImplementation(libs.roborazzi)
testImplementation(libs.roborazzi.compose)
testImplementation(libs.roborazzi.junit.rule)

testImplementation(
    libs.androidx.compose.ui.test.junit4
)

androidTestImplementation(
    platform(libs.androidx.compose.bom)
)

androidTestImplementation(
    libs.androidx.compose.ui.test.junit4
)

androidTestImplementation(
    libs.androidx.espresso.core
)

androidTestImplementation(
    libs.androidx.junit
)

androidTestImplementation(
    libs.androidx.runner
)

debugImplementation(
    libs.androidx.compose.ui.tooling
)

debugImplementation(
    libs.androidx.compose.ui.test.manifest
)

ksp(libs.androidx.room.compiler)
ksp(libs.moshi.kotlin.codegen)

}
