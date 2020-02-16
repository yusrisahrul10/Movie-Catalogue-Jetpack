package me.yusrisahrul.moviecatalogue.data.source.remote

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
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

        fun getInstance(apiInterface: ApiInterface): RemoteDataSource =
            instance ?: synchronized(this) {
                instance ?: RemoteDataSource(apiInterface)
            }
    }

    fun getListMovie(): LiveData<ApiResponse<List<Movie>?>> {
        EspressoIdlingResource.increment()
        val resultMovie = MutableLiveData<ApiResponse<List<Movie>?>>()
        val call = apiInterface.getTopMovies(BuildConfig.API_Key)
        call.subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Observer<ResponseMovie> {
                override fun onComplete() {

                }

                override fun onSubscribe(d: Disposable?) {

                }

                override fun onNext(value: ResponseMovie?) {
                    resultMovie.value = ApiResponse.success(value?.results)
                    EspressoIdlingResource.decrement()
                }

                override fun onError(e: Throwable?) {
                }

            })
        return resultMovie
    }

    fun getListTvShow(): LiveData<ApiResponse<List<TvShow>?>> {
        EspressoIdlingResource.increment()
        val resultTvShow = MutableLiveData<ApiResponse<List<TvShow>?>>()
        val call = apiInterface.getTopTvShows(BuildConfig.API_Key)
        call.subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Observer<ResponseTvShow> {
                override fun onComplete() {

                }

                override fun onSubscribe(d: Disposable?) {

                }

                override fun onNext(value: ResponseTvShow?) {
                    resultTvShow.value = ApiResponse.success(value?.results)
                    EspressoIdlingResource.decrement()
                }

                override fun onError(e: Throwable?) {
                }

            })
        return resultTvShow
    }


}