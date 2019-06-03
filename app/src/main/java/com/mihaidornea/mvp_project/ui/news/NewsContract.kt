package com.mihaidornea.mvp_project.ui.news

import com.mihaidornea.mvp_project.models.article.Article
import com.mihaidornea.mvp_project.ui.BasePresenter
import com.mihaidornea.mvp_project.ui.BaseView

interface NewsContract {

    interface Presenter : BasePresenter<View> {
        fun getNews()
        fun loadNextScreen()
        fun loadPreviousScreen()
    }

    interface View : BaseView<Presenter> {
        fun displayNews(articles: MutableList<Article>)
        fun navigateNextScreen()
        fun navigatePreviousScreen()
        fun displayToast(string: String)
    }
}