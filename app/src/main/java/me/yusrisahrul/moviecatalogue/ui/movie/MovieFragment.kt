package me.yusrisahrul.moviecatalogue.ui.movie

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_movie.*
import me.yusrisahrul.moviecatalogue.R
import me.yusrisahrul.moviecatalogue.adapter.MovieAdapter
import me.yusrisahrul.moviecatalogue.data.model. Movie
import me.yusrisahrul.moviecatalogue.data.source.local.entity.MovieEntity
import me.yusrisahrul.moviecatalogue.ui.detail.DetailActivity
import me.yusrisahrul.moviecatalogue.viewmodel.ViewModelFactory
import me.yusrisahrul.moviecatalogue.vo.Status

class MovieFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_movie, container, false)

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if (activity != null) {
            val factory = ViewModelFactory.getInstance(requireActivity())
            val viewModel = ViewModelProvider(this,
                factory)[MovieViewModel::class.java]
            viewModel.getMovies().observe(viewLifecycleOwner, Observer { movie ->
                if (movie != null) {
                    when (movie.status) {
                        Status.LOADING -> {
                            progress_bar_movie.visibility = View.VISIBLE
                        }
                        Status.SUCCESS -> {
                            progress_bar_movie.visibility = View.GONE
                            val movieAdapter = MovieAdapter(requireContext(), movie.data)
                            { item: MovieEntity -> getItemClicked(item) }

                            with(rv_movie) {
                                layoutManager = LinearLayoutManager(context)
                                setHasFixedSize(true)
                                adapter = movieAdapter
                            }
                        }
                        Status.ERROR -> {
                            progress_bar_movie.visibility = View.GONE
                            Toast.makeText(context, "Terjadi kesalahan", Toast.LENGTH_SHORT).show()
                        }
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