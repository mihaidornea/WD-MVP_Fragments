package com.mihaidornea.mvp_project.ui.phone

class PhoneVerificationPresenter : PhoneVerificationContract.Presenter {
    private var view : PhoneVerificationContract.View? = null

    override fun takeView(view: PhoneVerificationContract.View) {
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
