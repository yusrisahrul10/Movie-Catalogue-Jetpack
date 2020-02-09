package me.yusrisahrul.moviecatalogue.ui.movie

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.nhaarman.mockitokotlin2.verify
import me.yusrisahrul.moviecatalogue.data.source.Repository
import me.yusrisahrul.moviecatalogue.data.model.Movie
import me.yusrisahrul.moviecatalogue.utils.DataDummy
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MovieViewModelTest {

    private lateinit var viewModel: MovieViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()


    @Mock
    private lateinit var repository: Repository

    @Mock
    private lateinit var observer: Observer<List<Movie>>

    @Before
    fun setUp() {
        viewModel = MovieViewModel(repository)
    }
//
    @Test
    fun getMovies() {
    val dummyMovies = DataDummy().generateDummyMovies()
    val courses = MutableLiveData<List<Movie>>()
    courses.value = dummyMovies

    `when`(repository.getAllMovies()).thenReturn(courses)
    val movie = viewModel.getMovies().value
    verify(repository).getAllMovies()
    assertNotNull(movie)
    assertEquals(10, movie?.size)

    viewModel.getMovies().observeForever(observer)
    verify(observer).onChanged(dummyMovies)

    }
}