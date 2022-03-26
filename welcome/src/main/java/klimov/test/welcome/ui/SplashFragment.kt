package klimov.test.welcome.ui

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import klimov.test.core.ui.BaseFragment
import klimov.test.welcome.databinding.FragmentSplashBinding
import klimov.test.welcome.interactor.WelcomeInteractor
import org.koin.android.ext.android.inject

class SplashFragment : BaseFragment<FragmentSplashBinding>() {
    private val interactor: WelcomeInteractor by inject()

    override fun getBinding(inflater: LayoutInflater, container: ViewGroup?) =
        FragmentSplashBinding.inflate(inflater, container, false)

    override fun findViews(binding: FragmentSplashBinding) {
    }

    override fun initViews(binding: FragmentSplashBinding) {
    }

    override fun initViewModels() {
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Handler(Looper.getMainLooper()).postDelayed({
            interactor.navigateToInstruction()
        }, 3000L)
    }

    companion object {
        fun getInstance() = SplashFragment()
    }
}