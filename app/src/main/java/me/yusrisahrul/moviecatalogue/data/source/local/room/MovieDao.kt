package me.yusrisahrul.moviecatalogue.data.source.local.room

import androidx.lifecycle.LiveData
import androidx.room.*
import me.yusrisahrul.moviecatalogue.data.source.local.entity.MovieEntity
import me.yusrisahrul.moviecatalogue.data.source.local.entity.TvShowEntity

@Dao
interface MovieDao {
    @Query("SELECT * FROM movieentity")
    fun getMovies() : LiveData<List<MovieEntity>>

    @Query("SELECT * FROM tvshowentity")
    fun getTvShows() : LiveData<List<TvShowEntity>>

    @Query("SELECT * FROM movieentity where bookmarked = 1")
    fun getBookmarkedMovie(): LiveData<List<MovieEntity>>

    @Query("SELECT * FROM tvshowentity where bookmarked = 1")
    fun getBookmarkedTvShow(): LiveData<List<TvShowEntity>>

    @Query("SELECT * FROM movieentity WHERE id = :id")
    fun getMovieById(id: String?): LiveData<MovieEntity>

    @Query("SELECT * FROM tvshowentity WHERE id = :id")
    fun getTvShowById(id: String?): LiveData<TvShowEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovies(movies: List<MovieEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTvShows(tvShows: List<TvShowEntity>)

    @Update
    fun updateMovie(movie: MovieEntity)

    @Update
    fun updateTvShow(tvShow: TvShowEntity)

}