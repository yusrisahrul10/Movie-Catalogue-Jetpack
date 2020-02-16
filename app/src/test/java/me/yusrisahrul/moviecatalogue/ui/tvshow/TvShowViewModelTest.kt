package me.yusrisahrul.moviecatalogue.ui.tvshow

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.nhaarman.mockitokotlin2.verify
import me.yusrisahrul.moviecatalogue.data.source.Repository
import me.yusrisahrul.moviecatalogue.data.source.local.entity.TvShowEntity
import me.yusrisahrul.moviecatalogue.utils.DataDummy
import me.yusrisahrul.moviecatalogue.vo.Resource
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class TvShowViewModelTest {

    private lateinit var viewModel: TvShowViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()


    @Mock
    private lateinit var repository: Repository

    @Mock
    private lateinit var observer: Observer<Resource<List<TvShowEntity>>>

    @Before
    fun setUp() {
        viewModel = TvShowViewModel(repository)
    }

    @Test
    fun getTvShows() {
        val dummyTvShows = Resource.success(DataDummy().generateDummyTvShows())
        val courses = MutableLiveData<Resource<List<TvShowEntity>>>()

        courses.value = dummyTvShows
        Mockito.`when`(repository.getAllTvShows()).thenReturn(courses)
        val tvShow = viewModel.getTvShows().value?.data
        verify(repository).getAllTvShows()
        assertNotNull(tvShow)
        assertEquals(10, tvShow?.size)

        viewModel.getTvShows().observeForever(observer)
        verify(observer).onChanged(dummyTvShows)
    }
}