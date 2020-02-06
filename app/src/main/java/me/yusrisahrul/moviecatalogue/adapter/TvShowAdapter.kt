package me.yusrisahrul.moviecatalogue.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.item_grid.view.*
import me.yusrisahrul.moviecatalogue.R
import me.yusrisahrul.moviecatalogue.model.TvShow

class TvShowAdapter(private val context: Context,
                    private val items: List<TvShow>,
                    private val listener : (TvShow) -> Unit) : RecyclerView.Adapter<TvShowAdapter.TvShowViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowViewHolder {
        return TvShowViewHolder(
            LayoutInflater.from(context).inflate(
            R.layout.item_grid,
            parent,
            false))
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: TvShowViewHolder, position: Int) {
        holder.bind(items[position], listener)
    }

    class TvShowViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        fun bind(tvShow : TvShow, listener: (TvShow) -> Unit) {
            with(itemView) {
                tv_rating.text = tvShow.rating
                tv_item_title.text = tvShow.title
                tv_item_release.text = tvShow.release
                Glide.with(context)
                    .load(tvShow.imagePath)
                    .apply(
                        RequestOptions.placeholderOf(R.drawable.ic_loading)
                        .error(R.drawable.ic_error))
                    .into(img_cover_item)

                setOnClickListener { listener(tvShow) }
            }
        }
    }
}