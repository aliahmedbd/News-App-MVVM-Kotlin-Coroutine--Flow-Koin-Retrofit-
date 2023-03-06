package com.example.newsapp

import android.content.Context
import androidx.test.platform.app.InstrumentationRegistry
import com.example.newsapp.util.clearSharedPreference
import com.example.newsapp.viewmodel.NewsViewModel
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class FavoriteNewsTest {

    private lateinit var context: Context
    private lateinit var articles: List<Article>
    private lateinit var article: Article
    private lateinit var viewModel: NewsViewModel

    @Before
    fun initialize() {
        context = InstrumentationRegistry.getInstrumentation().targetContext
        viewModel = NewsViewModel(null)
        article = Article(title = "Test Title", link = "www.testurl.com", id = "1")
        articles = listOf(article)
        this.context.clearSharedPreference()
    }

    @Test
    fun emptyArticleTest() {
        val news = NewsViewModel(null).getSavedArticles(context)
        assertEquals(0, news?.size)
    }

    @Test
    fun actualArticlesSizeTest() {
        viewModel.saveArticle(article, context)
        val news = NewsViewModel(null).getSavedArticles(context)
        assertEquals(1, news?.size)
    }

    @Test
    fun isNewsAlreadySaved() {
        viewModel.saveArticle(article, context)
        assertEquals(true, viewModel.isNewsAlreadySaved(article, context))
        assertEquals(false, viewModel.isNewsAlreadySaved(Article(), context))
    }

    @Test
    fun clearData() {
        this.context.clearSharedPreference()
    }
}