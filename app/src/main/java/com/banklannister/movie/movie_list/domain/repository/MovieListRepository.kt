package com.banklannister.movie.movie_list.domain.repository

import com.banklannister.movie.movie_list.domain.model.Movie
import com.banklannister.movie.movie_list.util.Resource
import kotlinx.coroutines.flow.Flow

interface MovieListRepository {


    suspend fun getMovieList(
        fetchFromRemote: Boolean, category: String,
        page: Int
    ): Flow<Resource<List<Movie>>>

    suspend fun getMovie(id: Int) : Flow<Resource<Movie>>


}