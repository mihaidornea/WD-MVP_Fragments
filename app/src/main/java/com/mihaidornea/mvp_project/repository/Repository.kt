package com.mihaidornea.mvp_project.repository

import com.mihaidornea.mvp_project.models.NewsApiResponse
import com.mihaidornea.mvp_project.repository.remote.RemoteDataCallback
import com.mihaidornea.mvp_project.repository.remote.RemoteDataSourceImpl
import org.koin.core.KoinComponent
import org.koin.core.inject

class Repository : KoinComponent{

    val remoteDataSource by inject<RemoteDataSourceImpl>()

    fun getNews(sources: String, callback: RemoteDataCallback<NewsApiResponse>) {
        remoteDataSource.getNews(sources, callback)
    }
}
