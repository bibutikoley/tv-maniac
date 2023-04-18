package com.thomaskioko.tvmaniac.trakt.profile.implementation.cache

import app.cash.sqldelight.coroutines.asFlow
import app.cash.sqldelight.coroutines.mapToOne
import com.thomaskioko.tvmaniac.core.db.TvManiacDatabase
import com.thomaskioko.tvmaniac.core.db.User_stats
import com.thomaskioko.tvmaniac.trakt.profile.api.cache.StatsCache
import com.thomaskioko.tvmaniac.util.model.AppCoroutineDispatchers
import kotlinx.coroutines.flow.Flow
import me.tatarka.inject.annotations.Inject

@Inject
class StatsCacheImpl(
    private val database: TvManiacDatabase,
    private val dispatchers: AppCoroutineDispatchers,
) : StatsCache {

    override fun insert(stats: User_stats) {
        database.user_statsQueries.insertOrReplace(
            user_slug = stats.user_slug,
            months = stats.months,
            days = stats.days,
            hours = stats.hours,
            collected_shows = stats.collected_shows,
            episodes_watched = stats.episodes_watched
        )
    }

    override fun observeStats(): Flow<User_stats> {
        return database.user_statsQueries.select()
            .asFlow()
            .mapToOne(dispatchers.io)
    }
}