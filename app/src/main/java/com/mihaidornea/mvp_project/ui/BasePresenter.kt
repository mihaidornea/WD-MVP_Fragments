package com.mihaidornea.mvp_project.ui

interface BasePresenter<T> {
    fun takeView(view : T)
    fun dropView()

}