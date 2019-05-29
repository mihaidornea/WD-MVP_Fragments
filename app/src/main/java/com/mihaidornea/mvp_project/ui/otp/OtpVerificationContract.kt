package com.mihaidornea.mvp_project.ui.otp

import com.mihaidornea.mvp_project.ui.BasePresenter
import com.mihaidornea.mvp_project.ui.BaseView

interface OtpVerificationContract {

    interface Presenter : BasePresenter<View> {

    }

    interface View : BaseView<Presenter> {

    }

}