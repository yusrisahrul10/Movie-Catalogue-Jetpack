package me.yusrisahrul.moviecatalogue.ui.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import me.yusrisahrul.moviecatalogue.data.source.Repository
import me.yusrisahrul.moviecatalogue.data.model.Movie

class MovieViewModel(private val repository: Repository) : ViewModel() {

    fun getMovies() : LiveData<List<Movie>> = repository.getAllMovies()

}