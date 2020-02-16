package me.yusrisahrul.moviecatalogue.ui.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import me.yusrisahrul.moviecatalogue.data.source.Repository
import me.yusrisahrul.moviecatalogue.data.source.local.entity.MovieEntity
import me.yusrisahrul.moviecatalogue.vo.Resource

class MovieViewModel(private val repository: Repository) : ViewModel() {

    fun getMovies(): LiveData<Resource<List<MovieEntity>>> = repository.getAllMovies()

    fun getFavoriteMovies(): LiveData<PagedList<MovieEntity>> = repository.getFavoritedMovies()
}