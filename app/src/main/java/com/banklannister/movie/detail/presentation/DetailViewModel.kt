package com.banklannister.movie.detail.presentation

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.banklannister.movie.movie_list.domain.repository.MovieListRepository
import com.banklannister.movie.movie_list.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val movieListRepository: MovieListRepository,
    private val saveStateHandle: SavedStateHandle
) : ViewModel() {

    private val movieId = saveStateHandle.get<Int>("movieId")
    private var _detailState = MutableStateFlow(DetailState())
    val detailState = _detailState.asStateFlow()


    init {
        getDetailMovie(movieId ?: -1)
    }

    private fun getDetailMovie(id: Int) {
        viewModelScope.launch {
            _detailState.update {
                it.copy(
                    isLoading = true
                )
            }

            movieListRepository.getMovie(id).collectLatest { result ->
                when (result) {
                    is Resource.Error -> {
                        _detailState.update { it.copy(isLoading = false) }
                    }

                    is Resource.Loading -> {
                        _detailState.update { it.copy(isLoading = result.isLoading) }
                    }

                    is Resource.Success -> {
                        result.data?.let { movies ->
                            _detailState.update {
                                it.copy(movie = movies)
                            }
                        }
                    }
                }
            }
        }
    }

}