package me.yusrisahrul.moviecatalogue.data.source

import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import me.yusrisahrul.moviecatalogue.data.source.remote.RemoteDataSource
import me.yusrisahrul.moviecatalogue.data.model.Movie
import me.yusrisahrul.moviecatalogue.data.model.TvShow
import me.yusrisahrul.moviecatalogue.data.source.local.LocalDataSource
import me.yusrisahrul.moviecatalogue.data.source.local.entity.MovieEntity
import me.yusrisahrul.moviecatalogue.data.source.local.entity.TvShowEntity
import me.yusrisahrul.moviecatalogue.data.source.remote.ApiResponse
import me.yusrisahrul.moviecatalogue.utils.AppExecutors
import me.yusrisahrul.moviecatalogue.vo.Resource

class FakeRepository constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
) : DataSource {
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
    }

    override fun getAllTvShows(): LiveData<Resource<List<TvShowEntity>>> {
        return object : NetworkBoundResource<List<TvShowEntity>, List<TvShow>>(appExecutors) {
            override fun loadFromDB(): LiveData<List<TvShowEntity>> =
                localDataSource.getAllTvShows()

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

    override fun getFavoritedMovies(): LiveData<PagedList<MovieEntity>> {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(4)
            .setPageSize(4)
            .build()
        return LivePagedListBuilder(localDataSource.getBookmarkedMovies(), config).build()
    }

    override fun getFavoritedTvShows(): LiveData<PagedList<TvShowEntity>> {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(4)
            .setPageSize(4)
            .build()
        return LivePagedListBuilder(localDataSource.getBookmarkedTvShows(), config).build()
    }


}