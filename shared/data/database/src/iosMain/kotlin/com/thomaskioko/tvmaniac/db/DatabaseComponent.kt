package com.thomaskioko.tvmaniac.db

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.native.NativeSqliteDriver
import com.thomaskioko.tvmaniac.base.scope.ApplicationScope
import com.thomaskioko.tvmaniac.core.db.Show
import com.thomaskioko.tvmaniac.core.db.TvManiacDatabase
import me.tatarka.inject.annotations.Provides

actual interface DatabaseComponent {

    @ApplicationScope
    @Provides
    fun provideSqlDriver(): SqlDriver = NativeSqliteDriver(TvManiacDatabase.Schema, "tvShows.db")

    @ApplicationScope
    @Provides
    fun provideTvManiacDatabase(
        sqlDriver: SqlDriver
    ): TvManiacDatabase = TvManiacDatabase(
        driver = sqlDriver,
        showAdapter = Show.Adapter(
            genresAdapter = stringColumnAdapter,
        ),
    )
}