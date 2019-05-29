package com.mihaidornea.mvp_project.ui.main

class MainPresenter : MainContract.Presenter {
    private var view : MainContract.View? = null

    override fun takeView(view: MainContract.View) {
        this.view = view
    }

    override fun dropView() {
        view = null
    }

    override fun loadNextScreen() {
        //Validation of data etc
        view?.navigateNextScreen()
    }

    override fun loadPreviousScreen() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}