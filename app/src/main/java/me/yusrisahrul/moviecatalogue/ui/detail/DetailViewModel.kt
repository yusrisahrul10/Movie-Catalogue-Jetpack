package me.yusrisahrul.moviecatalogue.ui.detail

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import me.yusrisahrul.moviecatalogue.data.source.Repository
import me.yusrisahrul.moviecatalogue.data.source.local.entity.MovieEntity
import me.yusrisahrul.moviecatalogue.data.source.local.entity.TvShowEntity
import me.yusrisahrul.moviecatalogue.vo.Resource

class DetailViewModel(private val repository: Repository) : ViewModel() {
    private var movieId : String? = null
    private var tvShowId : String? = null

    fun setSelectedMovie(movieId: String?) {
        this.movieId = movieId
    }

    fun setSelectedTvShow(tvShowId: String?) {
        this.tvShowId = tvShowId
    }

    fun getMovies(): LiveData<Resource<MovieEntity>> = repository.getDetailMovie(movieId)

    fun getTvShows(): LiveData<Resource<TvShowEntity>> = repository.getDetailTvShow(tvShowId)

    fun setFavoriteMovie(movieEntity: MovieEntity?) {
        if (movieEntity != null) {
            val newState = !movieEntity.bookmarked!!
            repository.setMovieFavorite(movieEntity, newState)
            Log.e("EXEXUTED", "set favorite movie")
        }
    }

    fun setFavoriteTvShow(tvShowEntity: TvShowEntity?) {
            if (tvShowEntity != null) {
                val newState = !tvShowEntity.bookmarked!!
                repository.setTvShowFavorite(tvShowEntity, newState)
        }
    }

}