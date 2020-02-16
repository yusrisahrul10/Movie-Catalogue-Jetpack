package me.yusrisahrul.moviecatalogue.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.item_grid.view.*
import me.yusrisahrul.moviecatalogue.R
import me.yusrisahrul.moviecatalogue.data.source.local.entity.TvShowEntity
import me.yusrisahrul.moviecatalogue.utils.Constant

class FavoriteTvShowPagedListAdapter internal constructor(
    private val listener: (TvShowEntity) -> Unit
) :
    PagedListAdapter<TvShowEntity, FavoriteTvShowPagedListAdapter.FavoriteTvShowViewHolder>(
        DIFF_CALLBACK
    ) {

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<TvShowEntity>() {
            override fun areItemsTheSame(oldItem: TvShowEntity, newItem: TvShowEntity): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: TvShowEntity, newItem: TvShowEntity): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteTvShowViewHolder {
        return FavoriteTvShowViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_grid,
                parent,
                false
            )
        )
    }


    override fun onBindViewHolder(holderFavorite: FavoriteTvShowViewHolder, position: Int) {
        val tvShow = getItem(position)
        if (tvShow != null) {
            holderFavorite.bind(tvShow, listener)
        }
    }

    class FavoriteTvShowViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(tvShow: TvShowEntity, listener: (TvShowEntity) -> Unit) {
            with(itemView) {
                tv_rating.text = tvShow.vote_average
                tv_item_title.text = tvShow.name
                tv_item_release.text = tvShow.first_air_date
                Glide.with(context)
                    .load(Constant.BASE_IMG_URL + tvShow.poster_path)
                    .apply(
                        RequestOptions.placeholderOf(R.drawable.ic_loading)
                            .error(R.drawable.ic_error)
                    )
                    .into(img_cover_item)

                setOnClickListener { listener(tvShow) }
            }
        }
    }
}