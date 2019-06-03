package com.mihaidornea.mvp_project.repository.remote

import com.mcxiaoke.koi.log.logd
import com.mihaidornea.mvp_project.Constants
import com.mihaidornea.mvp_project.models.NewsApiResponse
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import org.koin.core.KoinComponent
import org.koin.core.inject
import retrofit2.Response

class RemoteDataSourceImpl : KoinComponent {

    private val api by inject<RemoteDataSource>()

    fun getNews(sources: String, callback: RemoteDataCallback<NewsApiResponse>) {
        api.getNews(sources, Constants.apiKey)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : SingleObserver<Response<NewsApiResponse>> {
                override fun onSuccess(t: Response<NewsApiResponse>) {
                    if (t.isSuccessful) {
                        callback.onSuccess(t.body())
                        logd("TAG", "Success!" + t.body().toString())
                    } else {
                        callback.onError(t.errorBody().toString())
                    }
                }

                override fun onSubscribe(d: Disposable) {
                    callback.onError("Subscription!")
                }

                override fun onError(e: Throwable) {
                    callback.onError(e.message ?: "")
                }

            })
    }

}
