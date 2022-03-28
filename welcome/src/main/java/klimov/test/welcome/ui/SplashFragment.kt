package klimov.test.welcome.ui

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.github.terrakok.cicerone.Router
import klimov.test.core.navigation.Screens
import klimov.test.core.ui.BaseFragment
import klimov.test.welcome.databinding.FragmentSplashBinding
import org.koin.android.ext.android.inject

class SplashFragment : BaseFragment<FragmentSplashBinding>() {
    private val router: Router by inject()

    override fun getBinding(inflater: LayoutInflater, container: ViewGroup?) =
        FragmentSplashBinding.inflate(inflater, container, false)

    override fun initViews() {
    }

    override fun initSubscription() {
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Handler(Looper.getMainLooper()).postDelayed({
            router.newRootScreen(Screens.InformationScreen())
        }, TIMEOUT)
    }

    companion object {
        private const val TIMEOUT = 3000L

        fun getInstance() = SplashFragment()
    }
}