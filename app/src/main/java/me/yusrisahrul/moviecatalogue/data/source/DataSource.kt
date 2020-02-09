package me.yusrisahrul.moviecatalogue.data.source

import androidx.lifecycle.LiveData
import me.yusrisahrul.moviecatalogue.data.model.Movie
import me.yusrisahrul.moviecatalogue.data.model.TvShow

interface DataSource {
    fun getAllMovies() : LiveData<List<Movie>>
    fun getAllTvShows() : LiveData<List<TvShow>>
    fun getDetailMovie(movieId: String?) : LiveData<Movie>
    fun getDetailTvShow(tvShowId: String?) : LiveData<TvShow>
}