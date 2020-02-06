package me.yusrisahrul.moviecatalogue.ui.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import me.yusrisahrul.moviecatalogue.R

import kotlinx.android.synthetic.main.activity_detail.*
import me.yusrisahrul.moviecatalogue.model.Movie
import me.yusrisahrul.moviecatalogue.model.TvShow

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        setSupportActionBar(toolbar)

        val viewModel = ViewModelProvider(this,
            ViewModelProvider.NewInstanceFactory())[DetailViewModel::class.java]

        val extras: Bundle? = intent.extras

        val movieId = extras?.getString("movie_id")
        val tvShowId = extras?.getString("tv_show_id")

        if (movieId != null) {
            viewModel.setSelectedMovie(movieId)
            initDataMovie(viewModel.getMovies())
        } else if (tvShowId != null) {
            viewModel.setSelectedTvShow(tvShowId)
            initDataTvShow(viewModel.getTvShows())
        }

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun initDataMovie(movie : Movie) {
        tv_title_detail.text = movie.title
        tv_rating_detail.text = movie.rating
        tv_overview_detail.text = movie.overview
        tv_release_detail.text = movie.release
        Glide.with(this)
            .load(movie.imagePath)
            .apply(
                RequestOptions.placeholderOf(R.drawable.ic_loading)
                    .error(R.drawable.ic_error))
            .into(img_cover_detail)
        supportActionBar?.title = movie.title
    }

    private fun initDataTvShow(tvShow : TvShow) {
        tv_title_detail.text = tvShow.title
        tv_rating_detail.text = tvShow.rating
        tv_overview_detail.text = tvShow.overview
        tv_release_detail.text = tvShow.release
        Glide.with(this)
            .load(tvShow.imagePath)
            .apply(
                RequestOptions.placeholderOf(R.drawable.ic_loading)
                    .error(R.drawable.ic_error))
            .into(img_cover_detail)
        supportActionBar?.title = tvShow.title
    }

}
