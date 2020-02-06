package me.yusrisahrul.moviecatalogue.ui.tvshow

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_tv_show.*
import me.yusrisahrul.moviecatalogue.R
import me.yusrisahrul.moviecatalogue.adapter.TvShowAdapter
import me.yusrisahrul.moviecatalogue.model.TvShow
import me.yusrisahrul.moviecatalogue.ui.detail.DetailActivity

class TvShowFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_tv_show, container, false)

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if (activity != null) {
            val viewModel = ViewModelProvider(this,
                ViewModelProvider.NewInstanceFactory())[TvShowViewModel::class.java]
            val tvShow = viewModel.getTvShows()
            val tvShowAdapter = TvShowAdapter(requireContext(), tvShow)
            { item: TvShow -> getItemClicked(item) }

            with(rv_tv_show) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = tvShowAdapter
            }
        }
    }

    private fun getItemClicked(item: TvShow) {
        val intent = Intent(activity, DetailActivity::class.java)
        intent.putExtra("tv_show_id", item.tvShowId)
        startActivity(intent)
    }
}