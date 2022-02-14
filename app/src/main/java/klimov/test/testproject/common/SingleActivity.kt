package klimov.test.testproject.common

import android.os.Bundle
import com.github.terrakok.cicerone.androidx.AppNavigator
import klimov.test.testproject.App
import klimov.test.testproject.R
import klimov.test.testproject.common.screens.Screens
import klimov.test.testproject.common.ui.BaseActivity
import klimov.test.testproject.databinding.MainActivityBinding

class SingleActivity : BaseActivity<MainActivityBinding>() {
    private val navigator = AppNavigator(this, R.id.container)

    override fun getLayoutBinding() = MainActivityBinding.inflate(layoutInflater)

    override fun findViews(binding: MainActivityBinding) {
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            App.INSTANCE.router.navigateTo(Screens.getMainFragment())
        }
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        App.INSTANCE.navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        App.INSTANCE.navigatorHolder.removeNavigator()
        super.onPause()
    }

}