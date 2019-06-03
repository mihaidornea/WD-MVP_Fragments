package com.mihaidornea.mvp_project.injection

import com.mihaidornea.mvp_project.Constants
import com.mihaidornea.mvp_project.repository.Repository
import com.mihaidornea.mvp_project.repository.remote.RemoteDataSource
import com.mihaidornea.mvp_project.repository.remote.RemoteDataSourceImpl
import com.mihaidornea.mvp_project.utils.DateUtils
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object AppModules {

    private val repository = module {
        single { Repository() }
    }

    private val utils = module {
        single { DateUtils(get()) }
    }

    private val retrofit = module {
        single {
             Retrofit.Builder()
                .baseUrl( Constants.url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build().create(RemoteDataSource::class.java)
        }
    }

    private val remoteDataSource = module {
        single {
            RemoteDataSourceImpl()
        }
    }

    val modules = listOf(repository, utils, retrofit, remoteDataSource)
}