package me.yusrisahrul.moviecatalogue.ui.movie

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_movie.*
import me.yusrisahrul.moviecatalogue.R
import me.yusrisahrul.moviecatalogue.adapter.MovieAdapter
import me.yusrisahrul.moviecatalogue.model.Movie
import me.yusrisahrul.moviecatalogue.ui.detail.DetailActivity

class MovieFragment : Fragment() {

//    private lateinit var movieViewModel: MovieViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_movie, container, false)

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if (activity != null) {
            val viewModel = ViewModelProvider(this,
                ViewModelProvider.NewInstanceFactory())[MovieViewModel::class.java]
            val movies = viewModel.getMovies()
            val movieAdapter = MovieAdapter(requireContext(), movies)
            { item: Movie -> getItemClicked(item) }

            with(rv_movie) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = movieAdapter
            }
        }
    }

    private fun getItemClicked(item: Movie) {
        val intent = Intent(activity, DetailActivity::class.java)
        intent.putExtra("movie_id", item.movieId)
        startActivity(intent)
    }
}