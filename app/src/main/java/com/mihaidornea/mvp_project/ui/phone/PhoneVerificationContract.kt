package com.mihaidornea.mvp_project.ui.phone

import com.mihaidornea.mvp_project.ui.BasePresenter
import com.mihaidornea.mvp_project.ui.BaseView

interface PhoneVerificationContract {

    interface Presenter : BasePresenter<View> {
        fun getData()
        fun loadNextScreen()
        fun loadPreviousScreen()
    }

    interface View : BaseView<Presenter> {
        fun showMessage(message: String)
        fun navigateNextScreen()
        fun navigatePreviousScreen()
    }
}