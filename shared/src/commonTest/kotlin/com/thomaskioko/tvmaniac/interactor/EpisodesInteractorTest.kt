package com.thomaskioko.tvmaniac.interactor

import app.cash.turbine.test
import com.thomaskioko.tvmaniac.MockData.getEpisodeList
import com.thomaskioko.tvmaniac.MockData.getEpisodesBySeasonId
import com.thomaskioko.tvmaniac.datasource.repository.episode.EpisodeRepository
import com.thomaskioko.tvmaniac.util.runBlockingTest
import io.kotest.matchers.shouldBe
import io.mockk.coEvery
import io.mockk.mockk
import kotlin.test.Test

internal class EpisodesInteractorTest {

    private val repository: EpisodeRepository = mockk()
    private val interactor = EpisodesInteractor(repository)
    private val query: EpisodeQuery = EpisodeQuery(
        tvShowId = 84958,
        seasonId = 114355,
        seasonNumber = 1
    )

    @Test
    fun wheneverInteractorIsInvoked_ExpectedDataIsReturned() = runBlockingTest {
        coEvery {
            repository.observeSeasonEpisodes(
                tvShowId = query.tvShowId,
                seasonNumber = query.seasonNumber,
                seasonId = query.seasonId
            )
        } returns getEpisodesBySeasonId()

        interactor.invoke(query).test {
            awaitItem() shouldBe getEpisodeList()
            awaitComplete()
        }
    }
}
