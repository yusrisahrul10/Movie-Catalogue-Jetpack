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
import me.yusrisahrul.moviecatalogue.model.Movie

class MovieAdapter(private val context: Context,
                   private val items: List<Movie>,
                   private val listener : (Movie) -> Unit) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(
            LayoutInflater.from(context).inflate(
            R.layout.item_grid,
            parent,
            false))
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(items[position], listener)
    }

    class MovieViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        fun bind(movie : Movie, listener: (Movie) -> Unit) {
            with(itemView) {
                tv_rating.text = movie.rating
                tv_item_title.text = movie.title
                tv_item_release.text = movie.release
                Glide.with(context)
                    .load(movie.imagePath)
                    .apply(
                        RequestOptions.placeholderOf(R.drawable.ic_loading)
                        .error(R.drawable.ic_error))
                    .into(img_cover_item)

                setOnClickListener { listener(movie) }
            }
        }
    }
}