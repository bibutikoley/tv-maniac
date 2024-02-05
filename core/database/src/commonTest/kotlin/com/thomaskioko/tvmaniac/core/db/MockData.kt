package com.thomaskioko.tvmaniac.core.db

import com.thomaskioko.tvmaniac.core.db.Episode as EpisodeCache
import com.thomaskioko.tvmaniac.db.Id

object MockData {

  fun getEpisodeCacheList() =
    listOf(
      EpisodeCache(
        id = Id(2534997),
        season_id = Id(114355),
        show_id = Id(123232),
        title = "Glorious Purpose",
        overview =
          "After stealing the Tesseract in Avengers: Endgame, Loki lands before the Time Variance Authority.",
        vote_count = 42,
        vote_average = 6.429,
        runtime = 45,
        episode_number = 1,
        image_url = "/yDWJYRAwMNKbIYT8ZB33qy84uzO.jpg",
      ),
      EpisodeCache(
        id = Id(2927202),
        season_id = Id(114355),
        show_id = Id(123232),
        title = "The Variant",
        overview =
          "Mobius puts Loki to work, but not everyone at TVA is thrilled about the God of Mischief's presence.",
        vote_count = 42,
        vote_average = 6.429,
        runtime = 45,
        episode_number = 1,
        image_url = "/yDWJYRAwMNKbIYT8ZB33qy84uzO.jpg",
      ),
    )

  fun getShow() =
    Tvshows(
      id = Id(84958),
      name = "Loki",
      overview =
        "After stealing the Tesseract during the events of “Avengers: Endgame,” " +
          "an alternate version of Loki is brought to the mysterious Time Variance " +
          "Authority, a bureaucratic organization that exists outside of time and " +
          "space and monitors the timeline. They give Loki a choice: face being " +
          "erased from existence due to being a “time variant”or help fix " +
          "the timeline and stop a greater threat.",
      language = "en",
      vote_count = 4958,
      popularity = 8.1,
      genre_ids = listOf(12, 14, 16, 18, 27, 28),
      first_air_date = "2019",
      status = "Ended",
      poster_path = "/yDWJYRAwMNKbIYT8ZB33qy84uzO.jpg",
      backdrop_path = "/yDWJYRAwMNKbIYT8ZB33qy84uzO.jpg",
      episode_numbers = "10",
      season_numbers = "1",
      vote_average = 8.1,
      last_air_date = "2019",
    )

  fun showList() =
    listOf(
      Tvshows(
        id = Id(84958),
        name = "Loki",
        overview =
          "After stealing the Tesseract during the events of “Avengers: Endgame,” " +
            "an alternate version of Loki is brought to the mysterious Time Variance " +
            "Authority, a bureaucratic organization that exists outside of time and " +
            "space and monitors the timeline. They give Loki a choice: face being " +
            "erased from existence due to being a “time variant”or help fix " +
            "the timeline and stop a greater threat.",
        language = "en",
        vote_count = 4958,
        popularity = 8.1,
        genre_ids = listOf(12, 14, 16, 18, 27, 28),
        first_air_date = "2019",
        status = "Ended",
        poster_path = "/yDWJYRAwMNKbIYT8ZB33qy84uzO.jpg",
        backdrop_path = "/yDWJYRAwMNKbIYT8ZB33qy84uzO.jpg",
        episode_numbers = "10",
        season_numbers = "1",
        vote_average = 8.1,
        last_air_date = "2019",
      ),
      Tvshows(
        id = Id(126280),
        name = "Sex/Life",
        overview =
          "A woman's daring sexual past collides with her married-with-kids " +
            "present when the bad-boy ex she can't stop fantasizing about crashes " +
            "back into her life.",
        language = "en",
        vote_count = 4958,
        popularity = 8.1,
        genre_ids = listOf(12, 14, 16, 18, 27, 28),
        first_air_date = "2019",
        status = "Ended",
        poster_path = "/yDWJYRAwMNKbIYT8ZB33qy84uzO.jpg",
        backdrop_path = "/yDWJYRAwMNKbIYT8ZB33qy84uzO.jpg",
        episode_numbers = "10",
        season_numbers = "1",
        vote_average = 8.1,
        last_air_date = "2019",
      ),
    )
}
