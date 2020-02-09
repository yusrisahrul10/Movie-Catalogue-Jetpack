package me.yusrisahrul.moviecatalogue.data.source.remote

import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import me.yusrisahrul.moviecatalogue.BuildConfig
import me.yusrisahrul.moviecatalogue.data.model.Movie
import me.yusrisahrul.moviecatalogue.data.model.ResponseMovie
import me.yusrisahrul.moviecatalogue.data.model.ResponseTvShow
import me.yusrisahrul.moviecatalogue.data.model.TvShow
import me.yusrisahrul.moviecatalogue.data.source.network.ApiInterface
import me.yusrisahrul.moviecatalogue.utils.EspressoIdlingResource

class RemoteDataSource private constructor(private val apiInterface: ApiInterface) {
    companion object {
        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(apiInterface: ApiInterface) : RemoteDataSource =
            instance ?: synchronized(this) {
                instance?: RemoteDataSource(apiInterface)
            }
    }

    fun getListMovie(loadListMovieCallback : LoadListMovieCallback) {
        EspressoIdlingResource.increment()
        val call = apiInterface.getTopMovies(BuildConfig.API_Key)
        call.subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Observer<ResponseMovie>{
                override fun onComplete() {

                }

                override fun onSubscribe(d: Disposable?) {

                }

                override fun onNext(value: ResponseMovie?) {
                    loadListMovieCallback.onAllMoviesReceived(value?.results)
                    EspressoIdlingResource.decrement()
                }

                override fun onError(e: Throwable?) {
                    loadListMovieCallback.onAllMoviesNotReceived(e?.message.toString())
                }

            })
    }

    fun getDetailMovie(movieId : String?, detailMovieCallback: LoadDetailMovieCallback) {
        EspressoIdlingResource.increment()
        val call = apiInterface.getDetailMovie(movieId, BuildConfig.API_Key)
        call.subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Observer<Movie>{
                override fun onComplete() {

                }

                override fun onSubscribe(d: Disposable?) {

                }

                override fun onNext(value: Movie?) {
                    detailMovieCallback.onDetailMovieReceived(value)
                    EspressoIdlingResource.decrement()
                }

                override fun onError(e: Throwable?) {
                    detailMovieCallback.onDetailMovieNotReceived(e?.message.toString())
                }

            })
    }

    fun getDetailTvShow(tvShowId : String?, detailTvShowCallback: LoadDetailTvShowCallback) {
        EspressoIdlingResource.increment()
        val call = apiInterface.getDetailTvShow(tvShowId, BuildConfig.API_Key)
        call.subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Observer<TvShow>{
                override fun onComplete() {

                }

                override fun onSubscribe(d: Disposable?) {

                }

                override fun onNext(value: TvShow?) {
                    detailTvShowCallback.onDetailTvShowsReceived(value)
                    EspressoIdlingResource.decrement()
                }

                override fun onError(e: Throwable?) {
                    detailTvShowCallback.onDetailTvShowsNotReceived(e?.message.toString())
                }

            })
    }

    fun getListTvShow(loadListTvShowCallback: LoadListTvShowCallback) {
        EspressoIdlingResource.increment()
        val call = apiInterface.getTopTvShows(BuildConfig.API_Key)
        call.subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Observer<ResponseTvShow>{
                override fun onComplete() {

                }

                override fun onSubscribe(d: Disposable?) {

                }

                override fun onNext(value: ResponseTvShow?) {
                    loadListTvShowCallback.onAllTvShowsReceived(value?.results)
                    EspressoIdlingResource.decrement()
                }

                override fun onError(e: Throwable?) {
                    loadListTvShowCallback.onAllTvShowsNotReceived(e?.message.toString())
                }

            })
    }

    interface LoadListMovieCallback {
        fun onAllMoviesReceived(responseMovie : List<Movie>?)
        fun onAllMoviesNotReceived(message : String)
    }

    interface LoadListTvShowCallback {
        fun onAllTvShowsReceived(responseTvShow : List<TvShow>?)
        fun onAllTvShowsNotReceived(message : String)
    }

    interface LoadDetailMovieCallback {
        fun onDetailMovieReceived(responseMovie : Movie?)
        fun onDetailMovieNotReceived(message : String)
    }

    interface LoadDetailTvShowCallback {
        fun onDetailTvShowsReceived(responseTvShow : TvShow?)
        fun onDetailTvShowsNotReceived(message : String)
    }
}