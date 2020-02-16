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
import kotlinx.android.synthetic.main.fragment_favorite_tv_show.*

import me.yusrisahrul.moviecatalogue.R
import me.yusrisahrul.moviecatalogue.adapter.FavoriteTvShowPagedListAdapter
import me.yusrisahrul.moviecatalogue.data.source.local.entity.TvShowEntity
import me.yusrisahrul.moviecatalogue.ui.detail.DetailActivity
import me.yusrisahrul.moviecatalogue.ui.tvshow.TvShowViewModel
import me.yusrisahrul.moviecatalogue.viewmodel.ViewModelFactory

class FavoriteTvShowFragment : Fragment() {

    private lateinit var viewModel: TvShowViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_favorite_tv_show, container, false)

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if (activity != null) {
            val factory = ViewModelFactory.getInstance(requireActivity())
            viewModel = ViewModelProvider(
                this,
                factory
            )[TvShowViewModel::class.java]
            initFavorite(viewModel)
        }
    }

    private fun initFavorite(viewModel: TvShowViewModel) {
        viewModel.getFavoriteTvShows().observe(viewLifecycleOwner, Observer { tvShow ->
            if (tvShow != null) {
                val tvShowAdapter = FavoriteTvShowPagedListAdapter()
                { item: TvShowEntity -> getItemClicked(item) }

                tvShowAdapter.submitList(tvShow)

                with(rv_favorite_tv_show) {
                    layoutManager = LinearLayoutManager(context)
                    setHasFixedSize(true)
                    adapter = tvShowAdapter
                }
            }

        })
    }

    private fun getItemClicked(item: TvShowEntity) {
        val intent = Intent(activity, DetailActivity::class.java)
        intent.putExtra("tv_show_id", item.id)
        startActivity(intent)
    }

    override fun onResume() {
        super.onResume()

        initFavorite(viewModel)
    }
}
