package me.yusrisahrul.moviecatalogue.ui.tvshow

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_tv_show.*
import me.yusrisahrul.moviecatalogue.R
import me.yusrisahrul.moviecatalogue.adapter.TvShowAdapter
import me.yusrisahrul.moviecatalogue.data.model.TvShow
import me.yusrisahrul.moviecatalogue.ui.detail.DetailActivity
import me.yusrisahrul.moviecatalogue.viewmodel.ViewModelFactory

class TvShowFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_tv_show, container, false)

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if (activity != null) {
            progress_bar_tv_show.visibility = View.VISIBLE
            val factory = ViewModelFactory.getInstance()

            val viewModel = ViewModelProvider(this,
                factory)[TvShowViewModel::class.java]
            viewModel.getTvShows().observe(viewLifecycleOwner, Observer {
                progress_bar_tv_show.visibility = View.GONE
                val tvShowAdapter = TvShowAdapter(requireContext(), it)
                { item: TvShow -> getItemClicked(item) }

                with(rv_tv_show) {
                    layoutManager = LinearLayoutManager(context)
                    setHasFixedSize(true)
                    adapter = tvShowAdapter
                }
            })
            //val tvShow = viewModel.getTvShows()

        }
    }

    private fun getItemClicked(item: TvShow) {
        val intent = Intent(activity, DetailActivity::class.java)
        intent.putExtra("tv_show_id", item.id)
        startActivity(intent)
    }
}