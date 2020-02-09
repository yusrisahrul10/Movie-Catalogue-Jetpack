package me.yusrisahrul.moviecatalogue.data.source

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import me.yusrisahrul.moviecatalogue.data.source.remote.RemoteDataSource
import me.yusrisahrul.moviecatalogue.data.model.Movie
import me.yusrisahrul.moviecatalogue.data.model.TvShow

class FakeRepository (private val remoteDataSource: RemoteDataSource) : DataSource {

    override fun getAllMovies(): LiveData<List<Movie>> {
        val movieResults = MutableLiveData<List<Movie>>()
        remoteDataSource.getListMovie(object : RemoteDataSource.LoadListMovieCallback {
            override fun onAllMoviesReceived(responseMovie: List<Movie>?) {
                movieResults.postValue(responseMovie)
            }

            override fun onAllMoviesNotReceived(message: String) {

            }

        })

        return movieResults
    }

    override fun getAllTvShows(): LiveData<List<TvShow>> {
        val tvShowResults = MutableLiveData<List<TvShow>>()
        remoteDataSource.getListTvShow(object : RemoteDataSource.LoadListTvShowCallback {
            override fun onAllTvShowsReceived(responseTvShow: List<TvShow>?) {
                tvShowResults.postValue(responseTvShow)
            }

            override fun onAllTvShowsNotReceived(message: String) {

            }

        })
        return tvShowResults
    }

    override fun getDetailMovie(movieId: String?): LiveData<Movie> {
        val movieDetailResult = MutableLiveData<Movie>()
        remoteDataSource.getDetailMovie(movieId, object : RemoteDataSource.LoadDetailMovieCallback {
            override fun onDetailMovieReceived(responseMovie: Movie?) {
                movieDetailResult.postValue(responseMovie)
            }

            override fun onDetailMovieNotReceived(message: String) {

            }

        })
        return movieDetailResult
    }

    override fun getDetailTvShow(tvShowId: String?): LiveData<TvShow> {
        val tvShowDetailResult = MutableLiveData<TvShow>()
        remoteDataSource.getDetailTvShow(tvShowId, object : RemoteDataSource.LoadDetailTvShowCallback {
            override fun onDetailTvShowsReceived(responseTvShow: TvShow?) {
                tvShowDetailResult.postValue(responseTvShow)
            }

            override fun onDetailTvShowsNotReceived(message: String) {

            }

        })
        return tvShowDetailResult
    }


}