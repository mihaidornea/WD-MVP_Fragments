package com.mihaidornea.mvp_project.ui.phone

import com.mihaidornea.mvp_project.ui.BasePresenter
import com.mihaidornea.mvp_project.ui.BaseView

interface PhoneVerificationContract {

    interface Presenter : BasePresenter<View> {
    }

    interface View : BaseView<Presenter> {
    }
}