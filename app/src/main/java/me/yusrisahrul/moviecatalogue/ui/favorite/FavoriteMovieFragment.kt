package me.yusrisahrul.moviecatalogue.ui.favorite


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_favorite_movie.*
import kotlinx.android.synthetic.main.fragment_movie.*

import me.yusrisahrul.moviecatalogue.R
import me.yusrisahrul.moviecatalogue.adapter.MovieAdapter
import me.yusrisahrul.moviecatalogue.data.source.local.entity.MovieEntity
import me.yusrisahrul.moviecatalogue.ui.detail.DetailActivity
import me.yusrisahrul.moviecatalogue.ui.movie.MovieViewModel
import me.yusrisahrul.moviecatalogue.viewmodel.ViewModelFactory
import me.yusrisahrul.moviecatalogue.vo.Status


class FavoriteMovieFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_favorite_movie, container, false)

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if (activity != null) {
            val factory = ViewModelFactory.getInstance(requireActivity())
            val viewModel = ViewModelProvider(this,
                factory)[MovieViewModel::class.java]
            viewModel.getFavoriteMovies().observe(viewLifecycleOwner, Observer { movie ->
                if (movie != null) {
                    val movieAdapter = MovieAdapter(requireContext(), movie)
                    { item: MovieEntity -> getItemClicked(item) }

                    with(rv_favorite_movie) {
                        layoutManager = LinearLayoutManager(context)
                        setHasFixedSize(true)
                        adapter = movieAdapter
                    }
                }

            })
        }
    }

    private fun getItemClicked(item: MovieEntity) {
        val intent = Intent(activity, DetailActivity::class.java)
        intent.putExtra("movie_id", item.id)
        startActivity(intent)
    }
}
