package klimov.test.testproject.common

import android.os.Bundle
import com.github.terrakok.cicerone.androidx.AppNavigator
import klimov.test.core.navigation.Screens
import klimov.test.core.navigation.coordinator.SingleActivityCoordinator
import klimov.test.core.ui.BaseActivity
import klimov.test.testproject.R
import klimov.test.testproject.databinding.ActivityContainerBinding
import org.koin.android.ext.android.inject

class SingleActivity : BaseActivity<ActivityContainerBinding>() {
    private val navigator = AppNavigator(this, R.id.container)
    private val coordinator: SingleActivityCoordinator by inject()

    override val binding = ActivityContainerBinding.inflate(layoutInflater)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            coordinator.newRootScreen(Screens.DashboardScreen())
        }
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigationHolder.setNavigator(navigator)
    }

    override fun onPause() {
        navigationHolder.removeNavigator()
        super.onPause()
    }

}