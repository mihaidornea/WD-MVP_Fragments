package com.mihaidornea.mvp_project.ui.phone

import com.mihaidornea.mvp_project.repository.Repository
import org.koin.core.KoinComponent
import org.koin.core.inject

class PhoneVerificationPresenter : PhoneVerificationContract.Presenter, KoinComponent {
    private var view: PhoneVerificationContract.View? = null
    private val repository by inject<Repository>()

    override fun takeView(view: PhoneVerificationContract.View) {
        this.view = view
    }

    override fun dropView() {
        view = null
    }

    override fun getData() {
    }

    override fun loadNextScreen() {
        (view as? PhoneVerificationFragment)
        view?.navigateNextScreen()
    }

    override fun loadPreviousScreen() {
        view?.navigatePreviousScreen()
    }
}
