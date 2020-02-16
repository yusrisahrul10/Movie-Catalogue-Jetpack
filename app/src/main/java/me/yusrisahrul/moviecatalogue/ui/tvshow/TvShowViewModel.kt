package me.yusrisahrul.moviecatalogue.ui.tvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import me.yusrisahrul.moviecatalogue.data.source.Repository
import me.yusrisahrul.moviecatalogue.data.source.local.entity.TvShowEntity
import me.yusrisahrul.moviecatalogue.vo.Resource

class TvShowViewModel(private val repository: Repository) : ViewModel() {

    fun getTvShows(): LiveData<Resource<List<TvShowEntity>>> = repository.getAllTvShows()

    fun getFavoriteTvShows(): LiveData<PagedList<TvShowEntity>> = repository.getFavoritedTvShows()

}