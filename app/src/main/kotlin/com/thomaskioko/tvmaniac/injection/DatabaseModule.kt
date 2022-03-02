package com.thomaskioko.tvmaniac.injection

import android.content.Context
import com.thomaskioko.tvmaniac.core.db.DriverFactory
import com.thomaskioko.tvmaniac.core.db.TvManiacDatabaseFactory
import com.thomaskioko.tvmaniac.datasource.cache.TvManiacDatabase
import com.thomaskioko.tvmaniac.details.api.cache.ShowCategoryCache
import com.thomaskioko.tvmaniac.details.implementation.cache.ShowCategoryCacheImpl
import com.thomaskioko.tvmaniac.details.implementation.cache.TvShowCacheImpl
import com.thomaskioko.tvmaniac.discover.api.cache.CategoryCache
import com.thomaskioko.tvmaniac.discover.api.cache.DiscoverCategoryCache
import com.thomaskioko.tvmaniac.discover.implementation.CategoryCacheImpl
import com.thomaskioko.tvmaniac.discover.implementation.DiscoverCategoryCacheImpl
import com.thomaskioko.tvmaniac.episodes.api.EpisodesCache
import com.thomaskioko.tvmaniac.episodes.implementation.EpisodesCacheImpl
import com.thomaskioko.tvmaniac.genre.api.GenreCache
import com.thomaskioko.tvmaniac.genre.implementation.GenreCacheImpl
import com.thomaskioko.tvmaniac.lastairepisodes.api.LastEpisodeAirCache
import com.thomaskioko.tvmaniac.lastairepisodes.implementation.LastEpisodeAirCacheImpl
import com.thomaskioko.tvmaniac.seasonepisodes.api.SeasonWithEpisodesCache
import com.thomaskioko.tvmaniac.seasonepisodes.implementation.SeasonWithEpisodesCacheImpl
import com.thomaskioko.tvmaniac.seasons.api.SeasonsCache
import com.thomaskioko.tvmaniac.seasons.implementation.SeasonsCacheImpl
import com.thomaskioko.tvmaniac.showcommon.api.cache.TvShowCache
import com.thomaskioko.tvmaniac.similar.api.SimilarShowCache
import com.thomaskioko.tvmaniac.similar.implementation.SimilarShowCacheImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideDriverFactory(@ApplicationContext context: Context): DriverFactory {
        return DriverFactory(context = context)
    }

    @Singleton
    @Provides
    fun provideTvShowDatabase(driverFactory: DriverFactory): TvManiacDatabase {
        return TvManiacDatabaseFactory(driverFactory).createDatabase()
    }

    @Singleton
    @Provides
    fun provideTvShowCache(database: TvManiacDatabase): TvShowCache {
        return TvShowCacheImpl(database)
    }

    @Singleton
    @Provides
    fun provideTvShowSeasonCache(database: TvManiacDatabase): SeasonsCache {
        return SeasonsCacheImpl(database)
    }

    @Singleton
    @Provides
    fun provideEpisodesCache(database: TvManiacDatabase): EpisodesCache {
        return EpisodesCacheImpl(database)
    }

    @Singleton
    @Provides
    fun provideGenreCache(database: TvManiacDatabase): GenreCache {
        return GenreCacheImpl(database)
    }

    @Singleton
    @Provides
    fun provideCategoryCache(database: TvManiacDatabase): CategoryCache {
        return CategoryCacheImpl(database)
    }

    @Singleton
    @Provides
    fun provideShowCategoryCache(database: TvManiacDatabase): ShowCategoryCache {
        return ShowCategoryCacheImpl(database)
    }

    @Singleton
    @Provides
    fun provideEpisodeAirCache(database: TvManiacDatabase): LastEpisodeAirCache {
        return LastEpisodeAirCacheImpl(database)
    }

    @Singleton
    @Provides
    fun provideSimilarShowCache(database: TvManiacDatabase): SimilarShowCache {
        return SimilarShowCacheImpl(database)
    }

    @Singleton
    @Provides
    fun provideSeasonWithEpisodesCache(database: TvManiacDatabase): SeasonWithEpisodesCache {
        return SeasonWithEpisodesCacheImpl(database)
    }

    @Singleton
    @Provides
    fun provideSeasonWithDiscoverCategoryCache(database: TvManiacDatabase): DiscoverCategoryCache {
        return DiscoverCategoryCacheImpl(database)
    }
}
