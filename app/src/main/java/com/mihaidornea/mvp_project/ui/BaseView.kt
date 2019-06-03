package com.mihaidornea.mvp_project.ui

interface BaseView<T> {

    fun setPresenter(presenter : T)
}