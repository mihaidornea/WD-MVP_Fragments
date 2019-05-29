package com.mihaidornea.mvp_project.ui.main

import com.mihaidornea.mvp_project.ui.BasePresenter
import com.mihaidornea.mvp_project.ui.BaseView

interface MainContract {

    interface Presenter : BasePresenter<View> {
    }

    interface View : BaseView<Presenter> {
    }
}