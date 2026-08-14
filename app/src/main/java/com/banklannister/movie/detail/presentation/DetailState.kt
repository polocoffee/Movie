package com.banklannister.movie.detail.presentation

import com.banklannister.movie.movie_list.domain.model.Movie

data class DetailState(
    val isLoading: Boolean = false,
    val movie: Movie? = null
)
