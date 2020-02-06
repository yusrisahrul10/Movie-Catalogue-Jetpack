package me.yusrisahrul.moviecatalogue.ui.detail

import me.yusrisahrul.moviecatalogue.utils.DataDummy
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class DetailViewModelTest {

    private lateinit var viewModel: DetailViewModel
    private val dummyMovies = DataDummy().generateDummyMovies()[0]
    private val dummyTvShow = DataDummy().generateDummyTvShows()[0]

    private val movieId = dummyMovies.movieId
    private val tvShowId = dummyTvShow.tvShowId

    @Before
    fun setUp() {
        viewModel = DetailViewModel()
        viewModel.setSelectedMovie(movieId)
        viewModel.setSelectedTvShow(tvShowId)
    }

    @Test
    fun getMovies() {
        viewModel.setSelectedMovie(dummyMovies.movieId)
        val movieEntity = viewModel.getMovies()
        assertNotNull(movieEntity)
        assertEquals(dummyMovies.movieId, movieEntity.movieId)
        assertEquals(dummyMovies.imagePath, movieEntity.imagePath)
        assertEquals(dummyMovies.overview, movieEntity.overview)
        assertEquals(dummyMovies.rating, movieEntity.rating)
        assertEquals(dummyMovies.title, movieEntity.title)
        assertEquals(dummyMovies.release, movieEntity.release)
    }

    @Test
    fun getTvShows() {
        viewModel.setSelectedMovie(dummyTvShow.tvShowId)
        val tvShowEntity = viewModel.getTvShows()
        assertNotNull(tvShowEntity)
        assertEquals(dummyTvShow.tvShowId, tvShowEntity.tvShowId)
        assertEquals(dummyTvShow.imagePath, tvShowEntity.imagePath)
        assertEquals(dummyTvShow.overview, tvShowEntity.overview)
        assertEquals(dummyTvShow.rating, tvShowEntity.rating)
        assertEquals(dummyTvShow.title, tvShowEntity.title)
        assertEquals(dummyTvShow.release, tvShowEntity.release)
    }
}