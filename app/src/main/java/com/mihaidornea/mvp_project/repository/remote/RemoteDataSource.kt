package com.mihaidornea.mvp_project.repository.remote

import com.mihaidornea.mvp_project.models.NewsApiResponse
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RemoteDataSource {

    @GET("top-headlines")
    fun getNews(
        @Query("sources") sources: String,
        @Query("apiKey") apiKey: String
    ) : Single<Response<NewsApiResponse>>

}