package me.yusrisahrul.moviecatalogue.di

import me.yusrisahrul.moviecatalogue.data.source.Repository
import me.yusrisahrul.moviecatalogue.data.source.remote.RemoteDataSource
import me.yusrisahrul.moviecatalogue.data.source.network.ApiClient
import me.yusrisahrul.moviecatalogue.data.source.network.ApiInterface

object Injection {
    fun provideRepository(): Repository {

        val remoteDataSource = RemoteDataSource.getInstance(
            ApiClient().getClient().create(ApiInterface::class.java))

        return Repository.getInstance(remoteDataSource)
    }
}