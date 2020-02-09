package me.yusrisahrul.moviecatalogue.ui.tvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import me.yusrisahrul.moviecatalogue.data.source.Repository
import me.yusrisahrul.moviecatalogue.data.model.TvShow

class TvShowViewModel(private val repository: Repository) : ViewModel() {

    fun getTvShows() : LiveData<List<TvShow>> = repository.getAllTvShows()

}