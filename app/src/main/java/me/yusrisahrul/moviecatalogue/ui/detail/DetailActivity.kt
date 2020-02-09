package me.yusrisahrul.moviecatalogue.ui.detail

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import me.yusrisahrul.moviecatalogue.R

import kotlinx.android.synthetic.main.activity_detail.*
import me.yusrisahrul.moviecatalogue.data.model.Movie
import me.yusrisahrul.moviecatalogue.data.model.TvShow
import me.yusrisahrul.moviecatalogue.utils.Constant
import me.yusrisahrul.moviecatalogue.viewmodel.ViewModelFactory

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        setSupportActionBar(toolbar)

        progress_bar_detail.visibility = View.VISIBLE
        val factory = ViewModelFactory.getInstance()

        val viewModel = ViewModelProvider(this,
            factory)[DetailViewModel::class.java]

        val extras: Bundle? = intent.extras

        val movieId = extras?.getString("movie_id")
        val tvShowId = extras?.getString("tv_show_id")

        if (movieId != null) {
            viewModel.setSelectedMovie(movieId)
            viewModel.getMovies().observe(this, Observer {
                progress_bar_detail.visibility = View.GONE
                initDataMovie(it)
            })
        } else if (tvShowId != null) {
            viewModel.setSelectedTvShow(tvShowId)
            viewModel.getTvShows().observe(this, Observer {
                progress_bar_detail.visibility = View.GONE
                initDataTvShow(it)
            })
        }

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun initDataMovie(movie : Movie) {
        tv_title_detail.text = movie.title
        tv_rating_detail.text = movie.vote_average
        tv_overview_detail.text = movie.overview
        tv_release_detail.text = movie.release_date
        Glide.with(this)
            .load(Constant.BASE_IMG_URL + movie.poster_path)
            .apply(
                RequestOptions.placeholderOf(R.drawable.ic_loading)
                    .error(R.drawable.ic_error))
            .into(img_cover_detail)
        supportActionBar?.title = movie.title
    }

    private fun initDataTvShow(tvShow : TvShow) {
        tv_title_detail.text = tvShow.name
        tv_rating_detail.text = tvShow.vote_average
        tv_overview_detail.text = tvShow.overview
        tv_release_detail.text = tvShow.first_air_date
        Glide.with(this)
            .load(Constant.BASE_IMG_URL + tvShow.poster_path)
            .apply(
                RequestOptions.placeholderOf(R.drawable.ic_loading)
                    .error(R.drawable.ic_error))
            .into(img_cover_detail)
        supportActionBar?.title = tvShow.name
    }

}
