package com.thomaskioko.tvmaniac.plugins

import com.thomaskioko.tvmaniac.extensions.configureKotlinJvm
import com.thomaskioko.tvmaniac.extensions.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.configurationcache.extensions.capitalized
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension
import org.jetbrains.kotlin.gradle.plugin.KotlinPlatformType
import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget

class KotlinMultiplatformConventionPlugin : Plugin<Project> {
  override fun apply(target: Project) = with(target) {
    with(pluginManager) {
      apply("org.jetbrains.kotlin.multiplatform")
    }

    version = libs.findVersion("shared-module-version")

    extensions.configure<KotlinMultiplatformExtension> {
      applyDefaultHierarchyTemplate()

      if (pluginManager.hasPlugin("com.android.library")) {
        androidTarget()
      }

      jvm()

      listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64(),
      ).forEach { target ->
        target.binaries.framework {
          baseName = path.substring(1).replace(':', '-')
        }
      }

      targets.all {
        sourceSets.all {
          languageSettings {
            listOf(
              "androidx.paging.ExperimentalPagingApi",
              "com.arkivanov.decompose.ExperimentalDecomposeApi",
              "kotlin.RequiresOptIn",
              "kotlin.experimental.ExperimentalObjCName",
              "kotlin.time.ExperimentalTime",
              "kotlinx.cinterop.BetaInteropApi",
              "kotlinx.cinterop.ExperimentalForeignApi",
              "kotlinx.coroutines.DelicateCoroutinesApi",
              "kotlinx.coroutines.ExperimentalCoroutinesApi",
              "kotlinx.coroutines.FlowPreview",
              "kotlinx.coroutines.InternalCoroutinesApi",
              "kotlinx.serialization.ExperimentalSerializationApi",
              "org.mobilenativefoundation.store.store5.ExperimentalStoreApi",
            ).forEach { optIn(it) }
          }
        }
      }

      targets.withType<KotlinNativeTarget>().configureEach {
        compilations.configureEach {
          compilerOptions.configure {
            freeCompilerArgs.add("-Xallocator=custom")
            freeCompilerArgs.add("-XXLanguage:+ImplicitSignedToUnsignedIntegerConversion")
            freeCompilerArgs.add("-Xadd-light-debug=enable")

            freeCompilerArgs.addAll(
              "-opt-in=kotlinx.cinterop.ExperimentalForeignApi",
              "-opt-in=kotlinx.cinterop.BetaInteropApi",
            )
          }
        }
      }
    }
    configureKotlinJvm()
  }
}

fun Project.addKspDependencyForAllTargets(dependencyNotation: Any) = addKspDependencyForAllTargets("", dependencyNotation)
private fun Project.addKspDependencyForAllTargets(
  configurationNameSuffix: String,
  dependencyNotation: Any,
) {
  val kmpExtension = extensions.getByType<KotlinMultiplatformExtension>()
  dependencies {
    kmpExtension.targets
      .asSequence()
      .filter { target ->
        // Don't add KSP for common target, only final platforms
        target.platformType != KotlinPlatformType.common
      }
      .forEach { target ->
        add(
          "ksp${target.targetName.capitalized()}$configurationNameSuffix",
          dependencyNotation,
        )
      }
  }
}
