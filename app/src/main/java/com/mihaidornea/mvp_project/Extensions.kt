package com.mihaidornea.mvp_project

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentTransaction
import com.mihaidornea.mvp_project.ui.main.MainActivity

infix fun <T : FragmentActivity> T.replaceWithAnimation(fragment: Fragment) {
    val containerId = when (this) {
        is MainActivity -> R.id.act_main_fl_content
        else -> -1
    }

    supportFragmentManager.beginTransaction()
        .setCustomAnimations(
            R.anim.enter_from_right,
            R.anim.exit_to_left,
            R.anim.enter_from_left,
            R.anim.exit_to_right
        )
        .replace(containerId, fragment)
        .addToBackStack(fragment::class.java.simpleName)
        .commit()
}

infix fun <T : FragmentActivity> T.replaceWith(fragment: Fragment) {
    val containerId = when (this) {
        is MainActivity -> R.id.act_main_fl_content
        else -> -1
    }

    supportFragmentManager.beginTransaction()
        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
        .replace(containerId, fragment)
        .addToBackStack(fragment::class.java.simpleName)
        .commit()
}

infix fun <T : FragmentActivity> T.replaceWithNoBackStack(fragment: Fragment) {
    val containerId = when (this) {
        is MainActivity -> R.id.act_main_fl_content
        else -> -1
    }

    supportFragmentManager.beginTransaction()
        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
        .replace(containerId, fragment)
        .commit()
}

infix fun <T : FragmentActivity> T.replaceWithNoBackStackAnimation(fragment: Fragment) {
    val containerId = when (this) {
        is MainActivity -> R.id.act_main_fl_content
        else -> -1
    }

    supportFragmentManager.beginTransaction()
        .setCustomAnimations(
            R.anim.enter_from_left,
            R.anim.exit_to_right,
            R.anim.enter_from_right,
            R.anim.exit_to_left
        )
        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
        .replace(containerId, fragment)
        .commit()
}