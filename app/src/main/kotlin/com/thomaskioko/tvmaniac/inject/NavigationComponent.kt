package com.thomaskioko.tvmaniac.inject

import com.thomaskioko.showdetails.ShowDetailsRegistryFeature
import com.thomaskioko.tvmaniac.common.navigation.Feature
import com.thomaskioko.tvmaniac.common.navigation.inject.VoyagerNavigationInitializer
import com.thomaskioko.tvmaniac.discover.DiscoverRegistryFeature
import com.thomaskioko.tvmaniac.profile.ProfileRegistryFeature
import com.thomaskioko.tvmaniac.search.SearchRegistryFeature
import com.thomaskioko.tvmaniac.seasondetails.SeasonDetailRegistryFeature
import com.thomaskioko.tvmaniac.settings.SettingsRegistryFeature
import com.thomaskioko.tvmaniac.showsgrid.LibraryRegistryFeature
import com.thomaskioko.tvmaniac.util.AppInitializer
import com.thomaskioko.tvmaniac.util.scope.ApplicationScope
import com.thomaskioko.tvmaniac.videoplayer.TrailersRegistryFeature
import com.thomaskioko.tvmaniac.watchlist.WatchlistRegistryFeature
import me.tatarka.inject.annotations.IntoSet
import me.tatarka.inject.annotations.Provides

interface NavigationComponent {

    @ApplicationScope
    @Provides
    @IntoSet
    fun provideNavigationInitializer(
        bind: VoyagerNavigationInitializer,
    ): AppInitializer = bind

    @Provides
    @IntoSet
    fun bindDiscoverRegistryFeature(
        feature: DiscoverRegistryFeature,
    ): Feature = feature

    @Provides
    @IntoSet
    fun bindProfileRegistryFeature(
        feature: ProfileRegistryFeature,
    ): Feature = feature

    @Provides
    @IntoSet
    fun bindSearchRegistryFeature(
        feature: SearchRegistryFeature,
    ): Feature = feature

    @Provides
    @IntoSet
    fun bindSettingsRegistryFeature(
        feature: SettingsRegistryFeature,
    ): Feature = feature

    @Provides
    @IntoSet
    fun bindSeasonDetailRegistryFeature(
        feature: SeasonDetailRegistryFeature,
    ): Feature = feature

    @Provides
    @IntoSet
    fun bindShowDetailsRegistryFeature(
        feature: ShowDetailsRegistryFeature,
    ): Feature = feature

    @Provides
    @IntoSet
    fun bindLibraryRegistryFeature(
        feature: LibraryRegistryFeature,
    ): Feature = feature

    @Provides
    @IntoSet
    fun bindTrailersRegistryFeature(
        feature: TrailersRegistryFeature,
    ): Feature = feature

    @Provides
    @IntoSet
    fun bindWatchlistFeature(
        feature: WatchlistRegistryFeature,
    ): Feature = feature
}
