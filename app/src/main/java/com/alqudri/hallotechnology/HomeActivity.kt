package com.alqudri.hallotechnology

import android.graphics.Rect
import android.os.Bundle
import android.view.View
import android.view.ViewTreeObserver.OnGlobalLayoutListener
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.internal.ContextUtils.getActivity
import kotlinx.android.synthetic.main.activity_home.*
import net.yslibrary.android.keyboardvisibilityevent.KeyboardVisibilityEvent


class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val navController = NavHostFragment.findNavController(navHomeFragment)
//        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_NOTHING);
        bottomNavigation.setupWithNavController(navController)
//        baseContext.getV

        KeyboardVisibilityEvent.setEventListener(
            this
        ) {
            if (it) { // if more than 100 pixels, its probably a keyboard...
                //ok now we know the keyboard is up...
                bottomNavigation.setVisibility(View.GONE)
                bottomAppBar.setVisibility(View.GONE)
            } else {
                //ok now we know the keyboard is down...
                bottomNavigation.setVisibility(View.VISIBLE)
                bottomAppBar.setVisibility(View.VISIBLE)
            }
        }

//        bottomNavigation.getViewTreeObserver().addOnGlobalLayoutListener(OnGlobalLayoutListener {
//            val r = Rect()
//            bottomNavigation.getWindowVisibleDisplayFrame(r)
////            this.getW
//            val heightDiff: Int = bottomAppBar.getRootView().getHeight() - (r.bottom - r.top)
//            if (heightDiff > 100) { // if more than 100 pixels, its probably a keyboard...
//                //ok now we know the keyboard is up...
//                bottomNavigation.setVisibility(View.GONE)
//                bottomAppBar.setVisibility(View.GONE)
//            } else {
//                //ok now we know the keyboard is down...
//                bottomNavigation.setVisibility(View.VISIBLE)
//                bottomAppBar.setVisibility(View.VISIBLE)
//            }
//        })
    }
}