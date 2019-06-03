package com.mihaidornea.mvp_project.ui.news

import com.mihaidornea.mvp_project.models.NewsApiResponse
import com.mihaidornea.mvp_project.repository.Repository
import com.mihaidornea.mvp_project.repository.remote.RemoteDataCallback
import org.koin.core.KoinComponent
import org.koin.core.inject

class NewsPresenter : NewsContract.Presenter, KoinComponent, RemoteDataCallback<NewsApiResponse> {

    private val repo by inject<Repository>()
    private var view: NewsContract.View? = null

    override fun takeView(view: NewsContract.View) {
        this.view = view
    }

    override fun dropView() {
        view = null
    }

    override fun loadNextScreen() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun loadPreviousScreen() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getNews() {
        repo.getNews("bbc-news", this)
    }

    override fun onSuccess(data: NewsApiResponse?) {
        data?.articles?.let { view?.displayNews(it) }
    }

    override fun onError(errorString: String) {
        view?.displayToast(errorString)
    }
}