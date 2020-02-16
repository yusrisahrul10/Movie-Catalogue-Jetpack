package me.yusrisahrul.moviecatalogue.di

import android.content.Context
import me.yusrisahrul.moviecatalogue.data.source.Repository
import me.yusrisahrul.moviecatalogue.data.source.local.LocalDataSource
import me.yusrisahrul.moviecatalogue.data.source.local.room.MovieDatabase
import me.yusrisahrul.moviecatalogue.data.source.remote.RemoteDataSource
import me.yusrisahrul.moviecatalogue.data.source.network.ApiClient
import me.yusrisahrul.moviecatalogue.data.source.network.ApiInterface
import me.yusrisahrul.moviecatalogue.utils.AppExecutors

object Injection {
    fun provideRepository(context: Context): Repository {

        val database = MovieDatabase.getInstance(context)


        val remoteDataSource = RemoteDataSource.getInstance(
            ApiClient().getClient().create(ApiInterface::class.java)
        )
        val localDataSource = LocalDataSource.getInstance(database.movieDao())
        val appExecutors = AppExecutors()

        return Repository.getInstance(remoteDataSource, localDataSource, appExecutors)
    }
}