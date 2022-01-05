package com.thomaskioko.tvmaniac.datasource.repository.seasons

import com.thomaskioko.tvmaniac.datasource.cache.SelectSeasonsByShowId
import com.thomaskioko.tvmaniac.datasource.repository.util.Resource
import kotlinx.coroutines.flow.Flow

interface SeasonsRepository {

    fun observeShowSeasons(tvShowId: Int): Flow<Resource<List<SelectSeasonsByShowId>>>
}
