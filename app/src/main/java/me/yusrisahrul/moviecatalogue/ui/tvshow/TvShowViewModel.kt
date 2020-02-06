package me.yusrisahrul.moviecatalogue.ui.tvshow

import androidx.lifecycle.ViewModel
import me.yusrisahrul.moviecatalogue.model.TvShow
import me.yusrisahrul.moviecatalogue.utils.DataDummy

class TvShowViewModel : ViewModel() {

    fun getTvShows() : List<TvShow> = DataDummy().generateDummyTvShows()

}