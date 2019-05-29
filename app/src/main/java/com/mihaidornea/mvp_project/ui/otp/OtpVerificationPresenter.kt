package com.mihaidornea.mvp_project.ui.otp

class OtpVerificationPresenter : OtpVerificationContract.Presenter {
    private var view : OtpVerificationContract.View? = null

    override fun takeView(view: OtpVerificationContract.View) {
        this.view = view
    }

    override fun dropView() {
        view = null
    }

    override fun loadNextScreen() {
        view?.navigateNextScreen()
    }

    override fun loadPreviousScreen() {
        view?.navigatePreviousScreen()
    }
}
