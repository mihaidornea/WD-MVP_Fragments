package com.mihaidornea.mvp_project.ui.phone

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.mihaidornea.mvp_project.R
import com.mihaidornea.mvp_project.replaceWithAnimation
import com.mihaidornea.mvp_project.ui.otp.OtpVerificationFragment
import com.mihaidornea.mvp_project.ui.otp.OtpVerificationPresenter
import kotlinx.android.synthetic.main.fragment_verify_phone_number.*

class PhoneVerificationFragment : Fragment(), PhoneVerificationContract.View{
    private var presenter: PhoneVerificationContract.Presenter? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.fragment_verify_phone_number, container, false)
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

    override fun setPresenter(presenter: PhoneVerificationContract.Presenter) {
        this.presenter = presenter
    }

    private fun initializeUIComponents() {
        fr_verify_phone_number_btn_next.setOnClickListener{
            presenter?.loadNextScreen()
        }
        fr_verify_phone_number_iv_back.setOnClickListener {
            presenter?.loadPreviousScreen()
        }
    }

    override fun navigateNextScreen() {
        activity?.let{act ->
            val fragment = OtpVerificationFragment()
            fragment.setPresenter(OtpVerificationPresenter())
            act replaceWithAnimation fragment
        }
    }

    override fun navigatePreviousScreen() {
        activity?.onBackPressed()
    }
}
