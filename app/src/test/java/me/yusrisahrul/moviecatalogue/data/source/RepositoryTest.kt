package me.yusrisahrul.moviecatalogue.data.source

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.doAnswer
import com.nhaarman.mockitokotlin2.eq
import com.nhaarman.mockitokotlin2.verify
import me.yusrisahrul.moviecatalogue.data.source.remote.RemoteDataSource
import me.yusrisahrul.moviecatalogue.utils.DataDummy
import me.yusrisahrul.moviecatalogue.utils.LiveDataTestUtil
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito

class RepositoryTest {


    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = Mockito.mock(RemoteDataSource::class.java)

    private val repository = FakeRepository(remote)

    private val movieResponses = DataDummy().generateRemoteDummyMovies()
    private val movieId = movieResponses[0].id
    private val tvShowResponses = DataDummy().generateRemoteDummyTvShows()
    private val tvShowId = tvShowResponses[0].id

    private val dummyMovies = DataDummy().generateRemoteDummyMovies()[0]
    private val dummyTvShow = DataDummy().generateRemoteDummyTvShows()[0]

    @Test
    fun getAllMovies() {
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSource.LoadListMovieCallback)
                .onAllMoviesReceived(movieResponses)
            null
        }.`when`(remote).getListMovie(any())
        val movieEntities = LiveDataTestUtil.getValue(repository.getAllMovies())
        verify(remote).getListMovie(any())
        assertNotNull(movieEntities)
        assertEquals(movieResponses.size.toLong(), movieEntities.size.toLong())
    }


    @Test
    fun getDetailMovie() {
        doAnswer { invocation ->
            (invocation.arguments[1] as RemoteDataSource.LoadDetailMovieCallback)
                .onDetailMovieReceived(dummyMovies)
            null
        }.`when`(remote).getDetailMovie(eq(movieId), any())

        val movieEntities = LiveDataTestUtil.getValue(repository.getDetailMovie(movieId))

        verify(remote).getDetailMovie(eq(movieId), any())
        assertNotNull(movieEntities)
        assertNotNull(movieEntities.title)
        assertEquals(dummyMovies.title, movieEntities.title)
    }

    @Test
    fun getAllTvShows() {
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSource.LoadListTvShowCallback)
                .onAllTvShowsReceived(tvShowResponses)
            null
        }.`when`(remote).getListTvShow(any())
        val tvShowEntities = LiveDataTestUtil.getValue(repository.getAllTvShows())
        verify(remote).getListTvShow(any())
        assertNotNull(tvShowEntities)
        assertEquals(tvShowResponses.size.toLong(), tvShowEntities.size.toLong())
    }

    @Test
    fun getDetailTvShow() {
        doAnswer { invocation ->
            (invocation.arguments[1] as RemoteDataSource.LoadDetailTvShowCallback)
                .onDetailTvShowsReceived(dummyTvShow)
            null
        }.`when`(remote).getDetailTvShow(eq(tvShowId), any())

        val tvShowEntities = LiveDataTestUtil.getValue(repository.getDetailTvShow(tvShowId))

        verify(remote).getDetailTvShow(eq(tvShowId), any())
        assertNotNull(tvShowEntities)
        assertNotNull(tvShowEntities.name)
        assertEquals(dummyTvShow.name, tvShowEntities.name)
    }
}