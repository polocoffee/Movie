package com.banklannister.movie.movie_list.data.repository

import coil.network.HttpException
import com.banklannister.movie.movie_list.data.local.movie.MovieDatabase
import com.banklannister.movie.movie_list.data.mappers.toMovie
import com.banklannister.movie.movie_list.data.mappers.toMovieEntity
import com.banklannister.movie.movie_list.data.remote.MovieApi
import com.banklannister.movie.movie_list.domain.model.Movie
import com.banklannister.movie.movie_list.domain.repository.MovieListRepository
import com.banklannister.movie.movie_list.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import javax.inject.Inject

class MovieListRepositoryImpl @Inject constructor(
    private val movieApi: MovieApi,
    private val movieDatabase: MovieDatabase

) : MovieListRepository {

    override suspend fun getMovieList(
        fetchFromRemote: Boolean,
        category: String,
        page: Int
    ): Flow<Resource<List<Movie>>> {
        return flow {
            emit(Resource.Loading(true))

            val localMovieList = movieDatabase.movieDao.getMovieListByCategory(category)

            val shouldLoadDataFromLocal = localMovieList.isNotEmpty() && !fetchFromRemote

            if (shouldLoadDataFromLocal) {
                emit(
                    Resource.Success(
                        data = localMovieList.map { movieEntity ->
                            movieEntity.toMovie(category)
                        }
                    ))

                emit(Resource.Loading(false))
                return@flow
            }

            val movieListFromApi = try {
                movieApi.getMovieList(category, page)
            } catch (e: IOException) {
                e.printStackTrace()
                emit(Resource.Error(message = "Internet Error"))
                return@flow
            } catch (e: HttpException) {
                e.printStackTrace()
                emit(Resource.Error(message = "Internet Error"))
                return@flow
            } catch (e: Exception) {
                e.printStackTrace()
                emit(Resource.Error(message = "Internet Error"))
                return@flow
            }


            val movieEntities = movieListFromApi.results.let {
                it.map { movieDto ->
                    movieDto.toMovieEntity(category)
                }
            }
            movieDatabase.movieDao.upsertMovieList(movieEntities)
            emit(
                Resource.Success(
                    movieEntities.map { it.toMovie(category) }
                ))

            emit(Resource.Loading(false))

        }
    }

    override suspend fun getMovie(id: Int): Flow<Resource<Movie>> {
        return flow {
            emit(Resource.Loading(true))

            val movieEntities = movieDatabase.movieDao.getMovieById(id)

            if (movieEntities != null) {
                emit(
                    Resource.Success(
                        movieEntities.toMovie(movieEntities.category))
                )
                emit (Resource.Loading(false))
            }
            emit(Resource.Error("Error"))
        }
    }
}