package me.yusrisahrul.moviecatalogue.ui.tvshow

import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class TvShowViewModelTest {

    private lateinit var viewModel: TvShowViewModel

    @Before
    fun setUp() {
        viewModel = TvShowViewModel()
    }

    @Test
    fun getTvShows() {
        val tvShowsEntities = viewModel.getTvShows()
        assertNotNull(tvShowsEntities)
        assertEquals(10, tvShowsEntities.size)
    }
}