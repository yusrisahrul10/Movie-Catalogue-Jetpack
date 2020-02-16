package me.yusrisahrul.moviecatalogue.ui.detail

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import me.yusrisahrul.moviecatalogue.R

import kotlinx.android.synthetic.main.activity_detail.*
import me.yusrisahrul.moviecatalogue.data.source.local.entity.MovieEntity
import me.yusrisahrul.moviecatalogue.data.source.local.entity.TvShowEntity
import me.yusrisahrul.moviecatalogue.utils.Constant
import me.yusrisahrul.moviecatalogue.viewmodel.ViewModelFactory
import me.yusrisahrul.moviecatalogue.vo.Status

class DetailActivity : AppCompatActivity() {

    private lateinit var viewModel: DetailViewModel
    private var menu: Menu? = null
    private var movieId: String? = null
    private var tvShowId: String? = null
    private var movieEntity: MovieEntity? = null
    private var tvShowEntity: TvShowEntity? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        setSupportActionBar(toolbar)

        val factory = ViewModelFactory.getInstance(this)

        viewModel = ViewModelProvider(
            this,
            factory
        )[DetailViewModel::class.java]

        val extras: Bundle? = intent.extras

        movieId = extras?.getString("movie_id")
        tvShowId = extras?.getString("tv_show_id")

        if (movieId != null) {
            viewModel.setSelectedMovie(movieId)
            viewModel.getMovies().observe(this, Observer { detailMovie ->
                if (detailMovie != null) {
                    when (detailMovie.status) {
                        Status.LOADING -> progress_bar_detail.visibility = View.VISIBLE
                        Status.SUCCESS -> {
                            progress_bar_detail.visibility = View.GONE
                            movieEntity = detailMovie.data
                            initDataMovie(movieEntity)
                        }
                        Status.ERROR -> {
                            progress_bar_detail.visibility = View.GONE
                            Toast.makeText(
                                applicationContext,
                                "Terjadi kesalahan",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                }

            })
        } else if (tvShowId != null) {
            viewModel.setSelectedTvShow(tvShowId)
            viewModel.getTvShows().observe(this, Observer { detailTvShow ->
                if (detailTvShow != null) {
                    when (detailTvShow.status) {
                        Status.LOADING -> progress_bar_detail.visibility = View.VISIBLE
                        Status.SUCCESS -> {
                            progress_bar_detail.visibility = View.GONE
                            tvShowEntity = detailTvShow.data
                            initDataTvShow(tvShowEntity)
                        }
                        Status.ERROR -> {
                            progress_bar_detail.visibility = View.GONE
                            Toast.makeText(
                                applicationContext,
                                "Terjadi kesalahan",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                }
            })
        }

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun initDataMovie(movie: MovieEntity?) {
        tv_title_detail.text = movie?.title
        tv_rating_detail.text = movie?.vote_average
        tv_overview_detail.text = movie?.overview
        tv_release_detail.text = movie?.release_date
        Glide.with(this)
            .load(Constant.BASE_IMG_URL + movie?.poster_path)
            .apply(
                RequestOptions.placeholderOf(R.drawable.ic_loading)
                    .error(R.drawable.ic_error)
            )
            .into(img_cover_detail)
        supportActionBar?.title = movie?.title
    }

    private fun initDataTvShow(tvShow: TvShowEntity?) {
        tv_title_detail.text = tvShow?.name
        tv_rating_detail.text = tvShow?.vote_average
        tv_overview_detail.text = tvShow?.overview
        tv_release_detail.text = tvShow?.first_air_date
        Glide.with(this)
            .load(Constant.BASE_IMG_URL + tvShow?.poster_path)
            .apply(
                RequestOptions.placeholderOf(R.drawable.ic_loading)
                    .error(R.drawable.ic_error)
            )
            .into(img_cover_detail)
        supportActionBar?.title = tvShow?.name
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_detail, menu)
        this.menu = menu
        if (movieId != null) {
            viewModel.getMovies().observe(this, Observer { detailMovie ->
                if (detailMovie != null) {
                    when (detailMovie.status) {
                        Status.LOADING -> progress_bar_detail.visibility = View.VISIBLE
                        Status.SUCCESS -> if (detailMovie.data != null) {
                            progress_bar_detail.visibility = View.GONE
                            val state = detailMovie.data.bookmarked
                            setBookmarkState(state)
                        }
                        Status.ERROR -> {
                            progress_bar_detail.visibility = View.GONE
                            Toast.makeText(
                                applicationContext,
                                "Terjadi kesalahan",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                }

            })
        } else if (tvShowId != null) {
            viewModel.getTvShows().observe(this, Observer { detailTvShow ->
                if (detailTvShow != null) {
                    when (detailTvShow.status) {
                        Status.LOADING -> progress_bar_detail.visibility = View.VISIBLE
                        Status.SUCCESS -> if (detailTvShow.data != null) {
                            progress_bar_detail.visibility = View.GONE
                            val state = detailTvShow.data.bookmarked
                            setBookmarkState(state)
                        }
                        Status.ERROR -> {
                            progress_bar_detail.visibility = View.GONE
                            Toast.makeText(
                                applicationContext,
                                "Terjadi kesalahan",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                }

            })
        }

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.action_bookmark) {
            if (movieId != null) {
                viewModel.setFavoriteMovie(movieEntity)
                return true
            } else if (tvShowId != null) {
                viewModel.setFavoriteTvShow(tvShowEntity)
                return true
            }
        }
        return super.onOptionsItemSelected(item)

    }

    private fun setBookmarkState(state: Boolean?) {
        if (menu == null) return
        val menuItem = menu?.findItem(R.id.action_bookmark)
        if (state!!) {
            menuItem?.icon = ContextCompat.getDrawable(this, R.drawable.ic_bookmark)
        } else {
            menuItem?.icon = ContextCompat.getDrawable(this, R.drawable.ic_bookmark_selector)
        }
    }

}
