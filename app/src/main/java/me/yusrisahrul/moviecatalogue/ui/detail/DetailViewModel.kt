package me.yusrisahrul.moviecatalogue.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import me.yusrisahrul.moviecatalogue.data.source.Repository
import me.yusrisahrul.moviecatalogue.data.model.Movie
import me.yusrisahrul.moviecatalogue.data.model.TvShow

class DetailViewModel(private val repository: Repository) : ViewModel() {
    private var movieId : String? = null
    private var tvShowId : String? = null

    fun setSelectedMovie(movieId: String?) {
        this.movieId = movieId
    }

    fun setSelectedTvShow(tvShowId: String?) {
        this.tvShowId = tvShowId
    }

    fun getMovies(): LiveData<Movie> = repository.getDetailMovie(movieId)

    fun getTvShows(): LiveData<TvShow> = repository.getDetailTvShow(tvShowId)

}