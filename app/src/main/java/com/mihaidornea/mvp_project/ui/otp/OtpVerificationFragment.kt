package com.mihaidornea.mvp_project.ui.otp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.mihaidornea.mvp_project.R
import com.mihaidornea.mvp_project.ui.news.NewsFragment
import com.mihaidornea.mvp_project.ui.news.NewsPresenter
import com.mihaidornea.mvp_project.utils.replaceWithAnimation
import kotlinx.android.synthetic.main.fragment_otp_verification.*

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
        fr_otp_verification_pt_otp_code.setOnPinEnteredListener {
            navigateNextScreen()
        }
    }

    override fun navigateNextScreen() {
        activity?.let { act ->
            val fragment = NewsFragment()
            fragment.setPresenter(NewsPresenter())
            act replaceWithAnimation fragment
        }
    }

    override fun navigatePreviousScreen() {
        activity?.onBackPressed()
    }
}
