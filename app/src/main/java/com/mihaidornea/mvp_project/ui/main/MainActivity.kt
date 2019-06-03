package com.mihaidornea.mvp_project.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mihaidornea.mvp_project.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadFragment()
    }

    private fun loadFragment(){
        val fragment = MainFragment()
        fragment.setPresenter(MainPresenter())
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.act_main_fl_content, fragment)
        fragmentTransaction.commit()
    }
}
