package com.mihaidornea.mvp_project.models

import com.mihaidornea.mvp_project.models.article.Article

data class NewsApiResponse (
    var status: String,
    var totalResults: Int,
    var articles: MutableList<Article>
)
