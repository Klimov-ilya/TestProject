package klimov.test.testproject.common

import android.os.Bundle
import com.github.terrakok.cicerone.androidx.AppNavigator
import klimov.test.testproject.R
import klimov.test.testproject.common.navigation.screens.Screens
import klimov.test.testproject.common.ui.BaseActivity
import klimov.test.testproject.databinding.ActivityMainBinding

class SingleActivity : BaseActivity<ActivityMainBinding>() {
    private val navigator = AppNavigator(this, R.id.container)

    override fun getLayoutBinding() = ActivityMainBinding.inflate(layoutInflater)

    override fun findViews(binding: ActivityMainBinding) {
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            router.newRootScreen(Screens.DashboardScreen())
        }
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigationHolder.setNavigator(navigator)
    }

    override fun onPause() {
        navigationHolder.removeNavigator()
        navigationHolder.removeNavigator()
        super.onPause()
    }

}