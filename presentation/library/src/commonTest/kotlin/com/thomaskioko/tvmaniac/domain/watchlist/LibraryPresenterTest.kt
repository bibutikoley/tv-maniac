package com.thomaskioko.tvmaniac.domain.watchlist

import com.thomaskioko.tvmaniac.presentation.watchlist.LibraryContent
import com.thomaskioko.tvmaniac.presentation.watchlist.LibraryPresenter
import com.thomaskioko.tvmaniac.presentation.watchlist.LoadingShows
import com.thomaskioko.tvmaniac.watchlist.testing.FakeLibraryRepository
import com.thomaskioko.tvmaniac.watchlist.testing.watchlistResult
import io.kotest.matchers.shouldBe
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import kotlin.test.AfterTest
import kotlin.test.BeforeTest
import kotlin.test.Ignore
import kotlin.test.Test

@Ignore
@OptIn(ExperimentalCoroutinesApi::class)
class LibraryPresenterTest {

    private val repository = FakeLibraryRepository()
    private val testDispatcher = StandardTestDispatcher()

    private lateinit var presenter: LibraryPresenter

    @BeforeTest
    fun setUp() {
        Dispatchers.setMain(testDispatcher)
        /* screenModel = LibraryPresenter(repository)*/
    }

    @AfterTest
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun initial_state_emits_expected_result() = runTest {
        repository.setFollowedResult(watchlistResult)

        presenter.state shouldBe LoadingShows
        presenter.state shouldBe LibraryContent(list = libraryItems)
    }
}
