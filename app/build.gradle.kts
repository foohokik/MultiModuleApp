plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.kapt)
}

android {
    namespace = "com.example.testmodularityapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.testmodularityapp"
        minSdk = 27
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildFeatures.viewBinding = true


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
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    implementation(libs.androidx.fragment)

    implementation(libs.dagger)
    kapt (libs.dagger.compiler)

    implementation(libs.navigation.fragment)
    implementation(libs.navigation.ui)

    implementation(project(":module-injector"))
    implementation(project(":core_utils"))
    implementation(project(":core_database"))
    implementation(project(":core_network"))
    implementation(project(":search_feature_api"))
    implementation(project(":search_feature_impl"))
    implementation(project(":full_vacancy_feature_impl"))
    implementation(project(":full_vacancy_feature_api"))
    implementation(project(":favorite_feature_api"))
    implementation(project(":favorite_feature_impl"))
    implementation(project(":auth_feature_impl"))
    implementation(project(":auth_feature_api"))
    implementation(project(":responses_feature_api"))
    implementation(project(":responses_feature_impl"))
    implementation(project(":profile_feature_impl"))
    implementation(project(":profile_feature_api"))



}