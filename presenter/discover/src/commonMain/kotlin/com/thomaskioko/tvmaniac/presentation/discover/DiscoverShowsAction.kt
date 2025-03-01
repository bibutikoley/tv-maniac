package com.thomaskioko.tvmaniac.presentation.discover

sealed interface DiscoverShowAction

data object ReloadData : DiscoverShowAction

data object SnackBarDismissed : DiscoverShowAction

data object UpComingClicked : DiscoverShowAction

data object TrendingClicked : DiscoverShowAction

data object PopularClicked : DiscoverShowAction

data object TopRatedClicked : DiscoverShowAction

data object RefreshData : DiscoverShowAction

data object AccountClicked : DiscoverShowAction

data class ShowClicked(val id: Long) : DiscoverShowAction

data class UpdateShowInLibrary(val id: Long, val inLibrary: Boolean) : DiscoverShowAction
