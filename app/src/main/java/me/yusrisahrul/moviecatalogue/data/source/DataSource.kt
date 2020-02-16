package me.yusrisahrul.moviecatalogue.data.source

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import me.yusrisahrul.moviecatalogue.data.source.local.entity.MovieEntity
import me.yusrisahrul.moviecatalogue.data.source.local.entity.TvShowEntity
import me.yusrisahrul.moviecatalogue.vo.Resource

interface DataSource {
    fun getAllMovies(): LiveData<Resource<List<MovieEntity>>>
    fun getAllTvShows(): LiveData<Resource<List<TvShowEntity>>>
    fun getDetailMovie(movieId: String?): LiveData<Resource<MovieEntity>>
    fun getDetailTvShow(tvShowId: String?): LiveData<Resource<TvShowEntity>>
    fun setMovieFavorite(movie: MovieEntity, state: Boolean?)
    fun setTvShowFavorite(tvShow: TvShowEntity, state: Boolean?)
    fun getFavoritedMovies(): LiveData<PagedList<MovieEntity>>
    fun getFavoritedTvShows(): LiveData<PagedList<TvShowEntity>>
}