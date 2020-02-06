package me.yusrisahrul.moviecatalogue

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.rule.ActivityTestRule
import me.yusrisahrul.moviecatalogue.utils.DataDummy
import org.junit.Rule
import org.junit.Test

class MainActivityTest {
    private val dummyMovies = DataDummy().generateDummyMovies()
    private val dummyTvShows = DataDummy().generateDummyTvShows()

    @get:Rule
    var activityRule = ActivityTestRule(MainActivity::class.java)


    @Test
    fun loadMovies() {
        onView(withId(R.id.rv_movie)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movie)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyMovies.size))
    }

    @Test
    fun loadDetailMovie() {
        onView(withId(R.id.rv_movie)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(4, click()))
        onView(withId(R.id.tv_title_detail)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_title_detail)).check(matches(withText(dummyMovies[4].title)))
        onView(withId(R.id.tv_rating_detail)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_rating_detail)).check(matches(withText(dummyMovies[4].rating)))
        onView(withId(R.id.tv_release_detail)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_release_detail)).check(matches(withText(dummyMovies[4].release)))
        onView(withId(R.id.tv_overview_detail)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_overview_detail)).check(matches(withText(dummyMovies[4].overview)))
    }

    @Test
    fun loadTvShows() {
        onView(withId(R.id.navigation_tv_show)).perform(click())
        onView(withId(R.id.rv_tv_show)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_tv_show)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyTvShows.size))
    }

    @Test
    fun loadDetailTvShows() {
        onView(withId(R.id.navigation_tv_show)).perform(click())
        onView(withId(R.id.rv_tv_show)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(2, click()))
        onView(withId(R.id.tv_title_detail)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_title_detail)).check(matches(withText(dummyTvShows[2].title)))
        onView(withId(R.id.tv_rating_detail)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_rating_detail)).check(matches(withText(dummyTvShows[2].rating)))
        onView(withId(R.id.tv_release_detail)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_release_detail)).check(matches(withText(dummyTvShows[2].release)))
        onView(withId(R.id.tv_overview_detail)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_overview_detail)).check(matches(withText(dummyTvShows[2].overview)))
    }

}