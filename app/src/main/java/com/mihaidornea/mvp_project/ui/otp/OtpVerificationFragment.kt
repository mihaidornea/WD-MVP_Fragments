package com.mihaidornea.mvp_project.ui.otp

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.mihaidornea.mvp_project.R
import kotlinx.android.synthetic.main.fragment_otp_verification.*
import kotlinx.android.synthetic.main.fragment_verify_phone_number.*

class OtpVerificationFragment : Fragment(), OtpVerificationContract.View {
    private var presenter : OtpVerificationContract.Presenter? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.fragment_otp_verification, container, false)
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

    override fun setPresenter(presenter: OtpVerificationContract.Presenter) {
        this.presenter = presenter
    }

    private fun initializeUIComponents() {
        fr_otp_verification_iv_back.setOnClickListener{
            presenter?.loadPreviousScreen()
        }
    }

    override fun navigateNextScreen() {
    }

    override fun navigatePreviousScreen() {
        activity?.onBackPressed()
    }
}
