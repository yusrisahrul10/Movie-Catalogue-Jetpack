package me.yusrisahrul.moviecatalogue.data.source.network

import io.reactivex.Observable
import me.yusrisahrul.moviecatalogue.data.model.Movie
import me.yusrisahrul.moviecatalogue.data.model.ResponseMovie
import me.yusrisahrul.moviecatalogue.data.model.ResponseTvShow
import me.yusrisahrul.moviecatalogue.data.model.TvShow
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiInterface {
    @GET("movie/top_rated")
    fun getTopMovies(
        @Query("api_key") apiKey : String
    ) : Observable<ResponseMovie>

    @GET("tv/top_rated")
    fun getTopTvShows(
        @Query("api_key") apiKey : String
    ) : Observable<ResponseTvShow>

    @GET("movie/{movie_id}")
    fun getDetailMovie(
        @Path("movie_id") movieId : String?,
        @Query("api_key") apiKey: String
    ) : Observable<Movie>

    @GET("tv/{tv_id}")
    fun getDetailTvShow(
        @Path("tv_id") tvId : String?,
        @Query("api_key") apiKey: String
    ) : Observable<TvShow>
}