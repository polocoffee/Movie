package com.banklannister.movie.movie_list.presentation

import com.banklannister.movie.movie_list.domain.model.Movie

data class MovieListState(
    val isLoading: Boolean = false,
    val popularMovieListPage: Int = 1,
    val upcomingMovieListPage: Int = 1,

    val isCurrentPopular: Boolean = true,

    val popularMovieList: List<Movie> = emptyList(),
    val upcomingMovieList: List<Movie> = emptyList(),
)