package me.yusrisahrul.moviecatalogue.ui.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.nhaarman.mockitokotlin2.verify
import me.yusrisahrul.moviecatalogue.data.source.Repository
import me.yusrisahrul.moviecatalogue.data.source.local.entity.MovieEntity
import me.yusrisahrul.moviecatalogue.data.source.local.entity.TvShowEntity
import me.yusrisahrul.moviecatalogue.utils.DataDummy
import me.yusrisahrul.moviecatalogue.vo.Resource
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.mockito.Mock
import org.mockito.Mockito.`when`

@Suppress("CAST_NEVER_SUCCEEDS")
class DetailViewModelTest {

    private lateinit var viewModel: DetailViewModel
    private val dummyMovies = DataDummy().generateDummyMovies()[0]
    private val dummyTvShow = DataDummy().generateDummyTvShows()[0]

    private val movieId = dummyMovies.id
    private val tvShowId = dummyTvShow.id

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var repository: Repository

    @Mock
    private lateinit var movieObserver: Observer<Resource<MovieEntity>>

    @Mock
    private lateinit var tvShowObserver: Observer<Resource<TvShowEntity>>

    @Before
    fun setUp() {
        if (::repository.isInitialized) {
            viewModel = DetailViewModel(repository)
            viewModel.setSelectedMovie(movieId)
            viewModel.setSelectedTvShow(tvShowId)
        }
    }

    @Test
    fun getMovies() {
        val dummyDetailMovie =
            Resource.success(DataDummy().generateDummyDetailMovie(dummyMovies, true))
        val movie = MutableLiveData<Resource<MovieEntity>>()
        movie.value = dummyDetailMovie

        if (::repository.isInitialized) {
            `when`(repository.getDetailMovie(movieId)).thenReturn(movie)
            val movieEntity = viewModel.getMovies().value as MovieEntity
            verify(repository).getDetailMovie(movieId)
            assertNotNull(movieEntity)
            assertEquals(dummyMovies.id, movieEntity.id)
            assertEquals(dummyMovies.poster_path, movieEntity.poster_path)
            assertEquals(dummyMovies.overview, movieEntity.overview)
            assertEquals(dummyMovies.vote_average, movieEntity.vote_average)
            assertEquals(dummyMovies.title, movieEntity.title)
            assertEquals(dummyMovies.release_date, movieEntity.release_date)

            viewModel.getMovies().observeForever(movieObserver)
            verify(movieObserver).onChanged(dummyDetailMovie)
        }

    }

    @Test
    fun getTvShows() {
        val dummyDetailTvShow =
            Resource.success(DataDummy().generateDummyDetaiTvShow(dummyTvShow, true))
        val tvShow = MutableLiveData<Resource<TvShowEntity>>()
        tvShow.value = dummyDetailTvShow

        if (::repository.isInitialized) {
            `when`(repository.getDetailTvShow(tvShowId)).thenReturn(tvShow)
            val tvShowEntity = viewModel.getTvShows().value as TvShowEntity
            assertNotNull(tvShowEntity)
            assertEquals(dummyTvShow.id, tvShowEntity.id)
            assertEquals(dummyTvShow.poster_path, tvShowEntity.poster_path)
            assertEquals(dummyTvShow.overview, tvShowEntity.overview)
            assertEquals(dummyTvShow.vote_average, tvShowEntity.vote_average)
            assertEquals(dummyTvShow.name, tvShowEntity.name)
            assertEquals(dummyTvShow.first_air_date, tvShowEntity.first_air_date)

            viewModel.getTvShows().observeForever(tvShowObserver)
            verify(tvShowObserver).onChanged(dummyDetailTvShow)
        }

    }
}