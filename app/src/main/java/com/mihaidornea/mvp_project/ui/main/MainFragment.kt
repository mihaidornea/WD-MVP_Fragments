package com.mihaidornea.mvp_project.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.mihaidornea.mvp_project.R
import com.mihaidornea.mvp_project.replaceWith
import com.mihaidornea.mvp_project.ui.phone.PhoneVerificationFragment
import com.mihaidornea.mvp_project.ui.phone.PhoneVerificationPresenter
import kotlinx.android.synthetic.main.fragment_login.*

class MainFragment : Fragment(), MainContract.View {
    private var presenter: MainContract.Presenter? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeUIComponents()
    }

    override fun onStart() {
        super.onStart()
        presenter?.takeView(this)
    }

    override fun onStop() {
        super.onStop()
        presenter?.dropView()
    }

    override fun setPresenter(presenter: MainContract.Presenter) {
        this.presenter = presenter
    }

    private fun initializeUIComponents() {
        fr_login_btn_login.setOnClickListener {
            presenter?.loadNextScreen()
        }
        fr_login_tv_forgot_password.setOnClickListener {
            activity?.let { act ->
                act replaceWith PhoneVerificationFragment()
            }
        }
    }

    override fun navigateNextScreen() {
        activity?.let { act ->
            val fragment = PhoneVerificationFragment()
            fragment.setPresenter(PhoneVerificationPresenter())
            act replaceWith fragment
        }
    }

    override fun navigatePreviousScreen() {
        activity?.finish()
    }
}