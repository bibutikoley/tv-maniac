import util.libs

plugins {
    `kmm-domain-plugin`
}

dependencies {
    commonMainApi(projects.shared.core)
    commonMainApi(projects.shared.database)
    commonMainApi(libs.kotlin.coroutines.core)
}
android {
    namespace = "com.thomaskioko.tvmaniac.seasons.api"
}
