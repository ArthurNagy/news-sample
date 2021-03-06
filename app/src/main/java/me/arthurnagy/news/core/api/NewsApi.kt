package me.arthurnagy.news.core.api

import kotlinx.coroutines.Deferred
import me.arthurnagy.news.core.data.model.Category
import me.arthurnagy.news.core.data.model.Country
import me.arthurnagy.news.core.data.model.SortType
import me.arthurnagy.news.core.data.source.Source
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {

    @GET("v2/top-headlines")
    fun getHeadlines(
        @Query("country") country: String = Country.USA.value,
        @Query("category") category: String = Category.TECHNOLOGY.value,
        @Query("page") page: Int = 0,
        @Query("pageSize") pageSize: Int = 20
    ): Deferred<ArticlesResponse>

    @GET("v2/everything")
    fun get(
        @Query("q") query: String? = null,
        @Query("sources") sources: List<Source>? = null,
        @Query("sortBy") sortType: String = SortType.POPULARITY.value,
        @Query("page") page: Int = 0
    ): Deferred<ArticlesResponse>

    @GET("v2/source")
    fun getSources(
        @Query("country") country: String = Country.USA.value,
        @Query("category") category: String = Category.TECHNOLOGY.value
    ): Deferred<SourceResponse>

}