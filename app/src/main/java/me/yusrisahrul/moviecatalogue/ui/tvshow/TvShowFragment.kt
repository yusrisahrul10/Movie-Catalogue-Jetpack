package me.yusrisahrul.moviecatalogue.ui.tvshow

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
import kotlinx.android.synthetic.main.fragment_tv_show.*
import me.yusrisahrul.moviecatalogue.R
import me.yusrisahrul.moviecatalogue.adapter.TvShowAdapter
import me.yusrisahrul.moviecatalogue.data.source.local.entity.TvShowEntity
import me.yusrisahrul.moviecatalogue.ui.detail.DetailActivity
import me.yusrisahrul.moviecatalogue.viewmodel.ViewModelFactory
import me.yusrisahrul.moviecatalogue.vo.Status

class TvShowFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_tv_show, container, false)

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if (activity != null) {
            val factory = ViewModelFactory.getInstance(requireActivity())

            val viewModel = ViewModelProvider(
                this,
                factory
            )[TvShowViewModel::class.java]
            viewModel.getTvShows().observe(viewLifecycleOwner, Observer { tvShows ->
                if (tvShows != null) {
                    when (tvShows.status) {
                        Status.LOADING -> progress_bar_tv_show.visibility = View.VISIBLE
                        Status.SUCCESS -> {
                            progress_bar_tv_show.visibility = View.GONE
                            val tvShowAdapter = TvShowAdapter(requireContext(), tvShows.data)
                            { item: TvShowEntity -> getItemClicked(item) }

                            with(rv_tv_show) {
                                layoutManager = LinearLayoutManager(context)
                                setHasFixedSize(true)
                                adapter = tvShowAdapter
                            }
                        }
                        Status.ERROR -> {
                            progress_bar_tv_show.visibility = View.GONE
                            Toast.makeText(context, "Terjadi kesalahan", Toast.LENGTH_SHORT).show()
                        }
                    }
                }

            })
        }
    }

    private fun getItemClicked(item: TvShowEntity) {
        val intent = Intent(activity, DetailActivity::class.java)
        intent.putExtra("tv_show_id", item.id)
        startActivity(intent)
    }
}