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
import me.yusrisahrul.moviecatalogue.data.source.local.entity.MovieEntity
import me.yusrisahrul.moviecatalogue.utils.Constant

class FavoriteMoviePagedListAdapter internal constructor(
    private val listener: (MovieEntity) -> Unit
) :
    PagedListAdapter<MovieEntity, FavoriteMoviePagedListAdapter.FavoriteMovieViewHolder>(
        DIFF_CALLBACK
    ) {

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<MovieEntity>() {
            override fun areItemsTheSame(oldItem: MovieEntity, newItem: MovieEntity): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: MovieEntity, newItem: MovieEntity): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteMovieViewHolder {
        return FavoriteMovieViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_grid,
                parent,
                false
            )
        )
    }


    override fun onBindViewHolder(holderFavorite: FavoriteMovieViewHolder, position: Int) {
        val movie = getItem(position)
        if (movie != null) {
            holderFavorite.bind(movie, listener)
        }
    }

    class FavoriteMovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(movie: MovieEntity, listener: (MovieEntity) -> Unit) {
            with(itemView) {
                tv_rating.text = movie.vote_average
                tv_item_title.text = movie.title
                tv_item_release.text = movie.release_date
                Glide.with(context)
                    .load(Constant.BASE_IMG_URL + movie.poster_path)
                    .apply(
                        RequestOptions.placeholderOf(R.drawable.ic_loading)
                            .error(R.drawable.ic_error)
                    )
                    .into(img_cover_item)

                setOnClickListener { listener(movie) }
            }
        }
    }
}