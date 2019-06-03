package com.mihaidornea.mvp_project.ui.news

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.mihaidornea.mvp_project.R
import com.mihaidornea.mvp_project.models.article.Article
import kotlinx.android.synthetic.main.fragment_news.*

class NewsFragment : Fragment(), NewsContract.View {

    private var presenter: NewsContract.Presenter? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.fragment_news, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadUIElements()
    }

    override fun onStart() {
        super.onStart()
        presenter?.takeView(this)
        presenter?.getNews()
    }

    override fun onStop() {
        super.onStop()
        presenter?.dropView()
    }

    fun loadUIElements() {
        fr_news_rv_news.layoutManager = LinearLayoutManager(context)
        fr_news_rv_news.adapter = NewsAdapter()
    }

    override fun setPresenter(presenter: NewsContract.Presenter) {
        this.presenter = presenter
    }

    override fun navigateNextScreen() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun navigatePreviousScreen() {
        activity?.onBackPressed()
    }

    override fun displayNews(articles: MutableList<Article>) {
        (fr_news_rv_news?.adapter as NewsAdapter).updateData(articles)
    }

    override fun displayToast(string: String) {
        Toast.makeText(context, string, Toast.LENGTH_SHORT).show()
    }
}