plugins {
  alias(libs.plugins.tvmaniac.kmp)
}

tvmaniac {
  multiplatform {
    useKotlinInject()
  }
}

kotlin {
  sourceSets {
    commonMain {
      dependencies {
        implementation(projects.core.base)
        implementation(projects.data.shows.api)
        implementation(projects.data.featuredshows.api)
        implementation(projects.data.popularshows.api)
        implementation(projects.data.topratedshows.api)
        implementation(projects.data.trendingshows.api)
        implementation(projects.data.upcomingshows.api)
        implementation(projects.data.watchlist.api)

        api(libs.decompose.decompose)
        api(libs.essenty.lifecycle)
        api(libs.kotlinx.collections)

      }
    }

    commonTest {
      dependencies {
        implementation(projects.data.featuredshows.testing)
        implementation(projects.data.popularshows.testing)
        implementation(projects.data.topratedshows.testing)
        implementation(projects.data.trendingshows.testing)
        implementation(projects.data.upcomingshows.testing)
        implementation(projects.data.watchlist.testing)

        implementation(libs.bundles.unittest)
      }
    }
  }
}
