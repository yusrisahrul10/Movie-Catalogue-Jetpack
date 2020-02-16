package me.yusrisahrul.moviecatalogue.data.source.network

import io.reactivex.Observable
import me.yusrisahrul.moviecatalogue.data.model.ResponseMovie
import me.yusrisahrul.moviecatalogue.data.model.ResponseTvShow
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    @GET("movie/top_rated")
    fun getTopMovies(
        @Query("api_key") apiKey: String
    ): Observable<ResponseMovie>

    @GET("tv/top_rated")
    fun getTopTvShows(
        @Query("api_key") apiKey: String
    ): Observable<ResponseTvShow>

}