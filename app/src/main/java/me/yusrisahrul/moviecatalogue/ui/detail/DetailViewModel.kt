package me.yusrisahrul.moviecatalogue.ui.detail

import androidx.lifecycle.ViewModel
import me.yusrisahrul.moviecatalogue.model.Movie
import me.yusrisahrul.moviecatalogue.model.TvShow
import me.yusrisahrul.moviecatalogue.utils.DataDummy

class DetailViewModel : ViewModel() {
    private var movieId : String? = null
    private var tvShowId : String? = null

    fun setSelectedMovie(movieId: String?) {
        this.movieId = movieId
    }

    fun setSelectedTvShow(tvShowId: String?) {
        this.tvShowId = tvShowId
    }

    fun getMovies(): Movie {
        lateinit var movie: Movie
        val moviesEntities = DataDummy().generateDummyMovies()
        for (movieEntity in moviesEntities) {
            if (movieEntity.movieId == movieId) {
                movie = movieEntity
            }
        }
        return movie
    }

    fun getTvShows(): TvShow {
        lateinit var tvShow: TvShow
        val tvShowEntities = DataDummy().generateDummyTvShows()
        for (tvShowEntity in tvShowEntities) {
            if (tvShowEntity.tvShowId == tvShowId) {
                tvShow = tvShowEntity
            }
        }
        return tvShow
    }

}