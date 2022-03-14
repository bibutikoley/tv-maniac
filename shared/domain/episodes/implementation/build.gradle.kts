import util.libs

plugins {
    `kmm-domain-plugin`
}

android {
    namespace = "com.thomaskioko.tvmaniac.episodes.implementation"
}

dependencies {
    commonMainImplementation(projects.shared.remote)
    commonMainImplementation(projects.shared.domain.episodes.api)
    commonMainImplementation(libs.kermit)
    commonMainImplementation(libs.koin.core)
    commonMainImplementation(libs.squareup.sqldelight.extensions)

    testImplementation(libs.testing.mockk.core)

    commonTestImplementation(kotlin("test"))
    commonTestImplementation(projects.shared.coreTest)
    commonTestImplementation(libs.testing.turbine)
    commonTestImplementation(libs.testing.kotest.assertions)
    commonTestImplementation(libs.testing.mockk.common)
}
