package com.banklannister.movie.movie_list.presentation

sealed interface MovieListUiEvent {
    data class Paginate(val category: String): MovieListUiEvent
    object Navigate : MovieListUiEvent
}