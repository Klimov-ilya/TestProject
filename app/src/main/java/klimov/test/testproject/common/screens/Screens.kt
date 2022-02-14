package klimov.test.testproject.common.screens

import com.github.terrakok.cicerone.androidx.FragmentScreen
import klimov.test.testproject.main.ui.MainFragment

object Screens {

    fun getMainFragment() = FragmentScreen { MainFragment.newInstance() }

}