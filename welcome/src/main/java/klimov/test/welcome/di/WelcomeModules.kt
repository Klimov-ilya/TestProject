package klimov.test.welcome.di

import androidx.fragment.app.Fragment
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.Router
import klimov.test.core.navigation.INFORMATION_SCREEN_QUALIFIER
import klimov.test.core.navigation.SPLASH_SCREEN_QUALIFIER
import klimov.test.welcome.navigation.WelcomeCoordinator
import klimov.test.welcome.ui.InformationFragment
import klimov.test.welcome.ui.SplashFragment
import org.koin.androidx.fragment.dsl.fragment
import org.koin.dsl.module

val welcomeModules = module {
    fragment<Fragment>(qualifier = SPLASH_SCREEN_QUALIFIER) { SplashFragment.getInstance() }
    fragment<Fragment>(qualifier = INFORMATION_SCREEN_QUALIFIER) { InformationFragment.getInstance() }

    single { WelcomeCoordinator(get<Cicerone<Router>>().router) }
}