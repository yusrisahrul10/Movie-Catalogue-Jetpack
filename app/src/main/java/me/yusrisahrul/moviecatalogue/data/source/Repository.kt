package me.yusrisahrul.moviecatalogue.data.source

import androidx.lifecycle.LiveData
import me.yusrisahrul.moviecatalogue.data.source.remote.RemoteDataSource
import me.yusrisahrul.moviecatalogue.data.model.Movie
import me.yusrisahrul.moviecatalogue.data.model.TvShow
import me.yusrisahrul.moviecatalogue.data.source.local.LocalDataSource
import me.yusrisahrul.moviecatalogue.data.source.local.entity.MovieEntity
import me.yusrisahrul.moviecatalogue.data.source.local.entity.TvShowEntity
import me.yusrisahrul.moviecatalogue.data.source.remote.ApiResponse
import me.yusrisahrul.moviecatalogue.utils.AppExecutors
import me.yusrisahrul.moviecatalogue.vo.Resource

class Repository private constructor(private val remoteDataSource: RemoteDataSource,
                                     private val localDataSource: LocalDataSource,
                                     private val appExecutors: AppExecutors) : DataSource {
    companion object {
        @Volatile
        private var instance: Repository? = null

        fun getInstance(remoteData: RemoteDataSource, localData: LocalDataSource, appExecutors: AppExecutors): Repository =
            instance ?: synchronized(this) {
                instance ?: Repository(remoteData, localData, appExecutors)
            }
    }

    override fun getAllMovies(): LiveData<Resource<List<MovieEntity>>> {
        return object : NetworkBoundResource<List<MovieEntity>, List<Movie>>(appExecutors) {
            override fun loadFromDB(): LiveData<List<MovieEntity>> = localDataSource.getAllMovies()

            override fun shouldFetch(data: List<MovieEntity>?): Boolean =
                data == null || data.isEmpty()

            override fun createCall(): LiveData<ApiResponse<List<Movie>?>> =
                remoteDataSource.getListMovie()

            override fun saveCallResult(data: List<Movie>?) {
                val movieList = ArrayList<MovieEntity>()
                for (response in data!!) {
                    val movie = MovieEntity(
                        response.id!!,
                        response.title,
                        response.poster_path,
                        response.overview,
                        response.release_date,
                        response.vote_average
                    )
                    movieList.add(movie)
                }
                localDataSource.insertMovies(movieList)
            }


        }.asLiveData()

//        val movieResults = MutableLiveData<List<Movie>>()
//        remoteDataSource.getListMovie(object : RemoteDataSource.LoadListMovieCallback {
//            override fun onAllMoviesReceived(responseMovie: List<Movie>?) {
//                movieResults.postValue(responseMovie)
//            }
//
//            override fun onAllMoviesNotReceived(message: String) {
//
//            }
//
//        })
//
//        return movieResults
    }

    override fun getAllTvShows(): LiveData<Resource<List<TvShowEntity>>> {
        return object : NetworkBoundResource<List<TvShowEntity>, List<TvShow>>(appExecutors) {
            override fun loadFromDB(): LiveData<List<TvShowEntity>> = localDataSource.getAllTvShows()

            override fun shouldFetch(data: List<TvShowEntity>?): Boolean =
                data == null || data.isEmpty()

            override fun createCall(): LiveData<ApiResponse<List<TvShow>?>> =
                remoteDataSource.getListTvShow()

            override fun saveCallResult(data: List<TvShow>?) {
                val tvShowList = ArrayList<TvShowEntity>()
                for (response in data!!) {
                    val tvShow = TvShowEntity(
                        response.id!!,
                        response.name,
                        response.poster_path,
                        response.overview,
                        response.first_air_date,
                        response.vote_average
                    )
                    tvShowList.add(tvShow)
                }
                localDataSource.insertTvShows(tvShowList)
            }

        }.asLiveData()
    }

    override fun getDetailMovie(movieId: String?): LiveData<Resource<MovieEntity>> {
        return object : NetworkBoundResource<MovieEntity, List<Movie>>(appExecutors) {
            override fun loadFromDB(): LiveData<MovieEntity> =
                localDataSource.getDetailMovie(movieId)

            override fun shouldFetch(data: MovieEntity?): Boolean =
                data == null

            override fun createCall(): LiveData<ApiResponse<List<Movie>?>> =
                remoteDataSource.getListMovie()

            override fun saveCallResult(data: List<Movie>?) {

            }

        }.asLiveData()
    }

    override fun getDetailTvShow(tvShowId: String?): LiveData<Resource<TvShowEntity>> {
        return object : NetworkBoundResource<TvShowEntity, List<TvShow>>(appExecutors) {
            override fun loadFromDB(): LiveData<TvShowEntity> =
                localDataSource.getDetailTvShow(tvShowId)

            override fun shouldFetch(data: TvShowEntity?): Boolean =
                data == null

            override fun createCall(): LiveData<ApiResponse<List<TvShow>?>> =
                remoteDataSource.getListTvShow()

            override fun saveCallResult(data: List<TvShow>?) {

            }

        }.asLiveData()
    }

    override fun setMovieFavorite(movie: MovieEntity, state: Boolean?) =
        appExecutors.diskIO().execute { localDataSource.setMovieBookmark(movie, state) }

    override fun setTvShowFavorite(tvShow: TvShowEntity, state: Boolean?) =
        appExecutors.diskIO().execute { localDataSource.setTvShowBookmark(tvShow, state) }

    override fun getFavoritedMovies(): LiveData<List<MovieEntity>> =
        localDataSource.getBookmarkedMovies()

    override fun getFavoritedTvShows(): LiveData<List<TvShowEntity>> =
        localDataSource.getBookmarkedTvShows()

//    override fun getAllTvShows(): LiveData<List<TvShow>> {
//        val tvShowResults = MutableLiveData<List<TvShow>>()
//        remoteDataSource.getListTvShow(object : RemoteDataSource.LoadListTvShowCallback {
//            override fun onAllTvShowsReceived(responseTvShow: List<TvShow>?) {
//                tvShowResults.postValue(responseTvShow)
//            }
//
//            override fun onAllTvShowsNotReceived(message: String) {
//
//            }
//
//        })
//        return tvShowResults
//    }
//
//    override fun getDetailMovie(movieId: String?): LiveData<Movie> {
//        val movieDetailResult = MutableLiveData<Movie>()
//        remoteDataSource.getDetailMovie(movieId, object : RemoteDataSource.LoadDetailMovieCallback {
//            override fun onDetailMovieReceived(responseMovie: Movie?) {
//                movieDetailResult.postValue(responseMovie)
//            }
//
//            override fun onDetailMovieNotReceived(message: String) {
//
//            }
//
//        })
//        return movieDetailResult
//    }
//
//    override fun getDetailTvShow(tvShowId: String?): LiveData<TvShow> {
//        val tvShowDetailResult = MutableLiveData<TvShow>()
//        remoteDataSource.getDetailTvShow(tvShowId, object : RemoteDataSource.LoadDetailTvShowCallback {
//            override fun onDetailTvShowsReceived(responseTvShow: TvShow?) {
//                tvShowDetailResult.postValue(responseTvShow)
//            }
//
//            override fun onDetailTvShowsNotReceived(message: String) {
//
//            }
//
//        })
//        return tvShowDetailResult
//    }


}