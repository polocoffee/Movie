package com.banklannister.movie.movie_list.util

sealed class Screen(val route: String) {

    object Home: Screen("main")
    object PopularMovie: Screen("popularMovie")
    object UpcomingMovie: Screen("upcomingMovie")
    object Detail: Screen("detail")
}