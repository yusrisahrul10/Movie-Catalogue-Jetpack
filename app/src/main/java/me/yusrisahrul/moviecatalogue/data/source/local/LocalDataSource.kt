package me.yusrisahrul.moviecatalogue.data.source.local

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import me.yusrisahrul.moviecatalogue.data.source.local.entity.MovieEntity
import me.yusrisahrul.moviecatalogue.data.source.local.entity.TvShowEntity
import me.yusrisahrul.moviecatalogue.data.source.local.room.MovieDao

class LocalDataSource private constructor(private val mMovieDao: MovieDao) {

    companion object {
        private var INSTANCE: LocalDataSource? = null

        fun getInstance(mMovieDao: MovieDao): LocalDataSource =
            INSTANCE ?: LocalDataSource(mMovieDao)
    }

    fun getAllMovies(): LiveData<List<MovieEntity>> = mMovieDao.getMovies()

    fun getAllTvShows(): LiveData<List<TvShowEntity>> = mMovieDao.getTvShows()

    fun getBookmarkedMovies(): DataSource.Factory<Int, MovieEntity> = mMovieDao.getBookmarkedMovie()

    fun getBookmarkedTvShows(): DataSource.Factory<Int, TvShowEntity> =
        mMovieDao.getBookmarkedTvShow()

    fun getDetailMovie(id: String?): LiveData<MovieEntity> = mMovieDao.getMovieById(id)

    fun getDetailTvShow(id: String?): LiveData<TvShowEntity> = mMovieDao.getTvShowById(id)

    fun insertMovies(movies: List<MovieEntity>) = mMovieDao.insertMovies(movies)

    fun insertTvShows(tvShows: List<TvShowEntity>) = mMovieDao.insertTvShows(tvShows)

    fun setMovieBookmark(movie: MovieEntity, newState: Boolean?) {
        movie.bookmarked = newState
        mMovieDao.updateMovie(movie)
    }

    fun setTvShowBookmark(tvShow: TvShowEntity, newState: Boolean?) {
        tvShow.bookmarked = newState
        mMovieDao.updateTvShow(tvShow)
    }

}