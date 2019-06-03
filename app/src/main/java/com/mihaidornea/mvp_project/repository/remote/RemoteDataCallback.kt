package com.mihaidornea.mvp_project.repository.remote

interface RemoteDataCallback<T> {

    fun onSuccess(data : T?)
    fun onError(errorString : String)

}