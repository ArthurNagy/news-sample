package me.arthurnagy.news.core.network

import me.arthurnagy.news.core.data.article.Article

data class ArticlesResponse(
    val totalResults: Int,
    val articles: List<Article>
)