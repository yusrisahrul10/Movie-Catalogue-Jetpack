package me.yusrisahrul.moviecatalogue.ui.movie

import androidx.lifecycle.ViewModel
import me.yusrisahrul.moviecatalogue.model.Movie
import me.yusrisahrul.moviecatalogue.utils.DataDummy

class MovieViewModel : ViewModel() {

    fun getMovies() : List<Movie> = DataDummy().generateDummyMovies()

}