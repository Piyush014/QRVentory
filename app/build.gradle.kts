plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.hilt)
    alias(libs.plugins.ksp)
    alias(libs.plugins.spotless) apply false
    id("com.google.gms.google-services")
}

val supportedAbis = setOf("armeabi-v7a", "arm64-v8a", "x86", "x86_64")

android {
    namespace = "com.dilip.qrventory"
    compileSdk =
        libs.versions.compileSdk
            .get()
            .toInt()

    defaultConfig {
        applicationId = "com.dilip.qrventory"
        minSdk = ProjectConfig.minSdk
        targetSdk = ProjectConfig.targetSdk
        versionCode = ProjectConfig.versionCode
        versionName = ProjectConfig.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
        vectorDrawables.useSupportLibrary = true

//        javaCompileOptions {
//            annotationProcessorOptions {
//                arguments += ["room.schemaLocation": "$projectDir/schemas".toString()]
//            }
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro",
            )
            signingConfig = signingConfigs.getByName("debug")
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
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(project(":core:common"))
    implementation(project(":core:data"))
    implementation(project(":core:domain"))
    implementation(project(":core:presentation"))

    // google scanner using lens
    implementation(libs.google.scanner)

    // qr generator
    implementation(libs.qr.generator)

    implementation(libs.androidx.appcompat)
    implementation(libs.core.ktx)
    implementation(libs.androidx.work)
    implementation(libs.lifecycle.runtime.ktx)

    implementation(platform(libs.compose.bom))
    implementation(libs.bundles.compose.android)
    implementation(libs.coil.compose)
    implementation(libs.compose.navigation)
    implementation(libs.splashscreen)

    implementation(libs.hilt.android)
    implementation(libs.hilt.navigation.compose)
    ksp(libs.hilt.compiler)

    // Room components
    implementation(libs.androidx.room.runtime)
    implementation(libs.androidx.room.ktx)
    ksp(libs.androidx.room.compiler)
    androidTestImplementation(libs.androidx.room.testing)

    implementation("androidx.compose.ui:ui:1.3.0")
    implementation("androidx.compose.material3:material3:1.0.0")
    // Material Design Components
    implementation("com.google.android.material:material:1.7.0")
    implementation("androidx.compose.foundation:foundation:1.7.4")
    implementation("com.google.accompanist:accompanist-pager:0.30.0")
    implementation("com.google.accompanist:accompanist-pager-indicators:0.30.0")

    implementation(platform("com.google.firebase:firebase-bom:33.4.0"))
    implementation("com.google.firebase:firebase-analytics")
    implementation("com.google.firebase:firebase-firestore:24.5.0")

    // DataStore Preferences
    implementation("androidx.datastore:datastore-preferences:1.0.0")
    implementation("com.google.firebase:firebase-auth")
    implementation("com.google.firebase:firebase-database-ktx")
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.compose.bom))
    androidTestImplementation(libs.compose.ui.test.junit)
    debugImplementation(libs.compose.ui.tooling)
    debugImplementation(libs.compose.ui.test.manifest)
}
