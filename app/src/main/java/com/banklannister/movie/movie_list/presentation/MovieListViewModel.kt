package com.banklannister.movie.movie_list.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.banklannister.movie.movie_list.domain.repository.MovieListRepository
import com.banklannister.movie.movie_list.util.Category
import com.banklannister.movie.movie_list.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieListViewModel @Inject constructor(
    private val movieListRepository: MovieListRepository
) : ViewModel() {


    private var _movieListState = MutableStateFlow(MovieListState())
    val movieListState = _movieListState.asStateFlow()

    init {
        getPopularMovie(false)
        getUpcomingMovie(false)
    }

    fun onEvent(event: MovieListUiEvent) {
        when (event) {
            MovieListUiEvent.Navigate -> {
                _movieListState.update {
                    it.copy(isCurrentPopular = !movieListState.value.isCurrentPopular)

                }
            }

            is MovieListUiEvent.Paginate -> {
                if (event.category == Category.POPULAR) {
                    getPopularMovie(true)
                } else if (event.category == Category.UPCOMING) {
                    getUpcomingMovie(true)
                }
            }
        }
    }


    private fun getPopularMovie(fetchFromRemote: Boolean) {
        viewModelScope.launch {
            _movieListState.update {
                it.copy(isLoading = true)
            }
            movieListRepository.getMovieList(
                fetchFromRemote, Category.POPULAR,
                movieListState.value.popularMovieListPage
            ).collectLatest { result ->
                when (result) {
                    is Resource.Loading -> {
                        _movieListState.update {
                            it.copy(isLoading = result.isLoading)
                        }
                    }

                    is Resource.Success -> {
                        result.data?.let { popularMovie ->
                            _movieListState.update {
                                it.copy(
                                    popularMovieList = movieListState.value.popularMovieList + popularMovie.shuffled(),
                                    popularMovieListPage = movieListState.value.popularMovieListPage + 1
                                )
                            }
                        }
                    }

                    is Resource.Error -> {
                        _movieListState.update {
                            it.copy(isLoading = false)
                        }
                    }
                }
            }
        }
    }

    private fun getUpcomingMovie(fetchFromRemote: Boolean) {
        viewModelScope.launch {
            _movieListState.update {
                it.copy(isLoading = true)
            }
            movieListRepository.getMovieList(
                fetchFromRemote, Category.UPCOMING,
                movieListState.value.upcomingMovieListPage
            ).collectLatest { result ->
                when (result) {
                    is Resource.Loading -> {
                        _movieListState.update {
                            it.copy(isLoading = result.isLoading)
                        }
                    }

                    is Resource.Success -> {
                        result.data?.let { upcomingMovie ->
                            _movieListState.update {
                                it.copy(
                                    upcomingMovieList = movieListState.value.upcomingMovieList + upcomingMovie.shuffled(),
                                    upcomingMovieListPage = movieListState.value.upcomingMovieListPage + 1
                                )
                            }
                        }
                    }

                    is Resource.Error -> {
                        _movieListState.update {
                            it.copy(isLoading = false)
                        }
                    }
                }
            }
        }
    }


}