package klimov.test.core.navigation.coordinator

import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.androidx.ActivityScreen
import com.github.terrakok.cicerone.androidx.FragmentScreen

open class Coordinator(private val router: Router) {
    open fun navigateTo(screen: FragmentScreen) {
        router.navigateTo(screen)
    }

    open fun newRootScreen(screen: FragmentScreen) {
        router.newRootScreen(screen)
    }

    open fun navigateTo(screen: ActivityScreen) {
        router.navigateTo(screen)
    }

    open fun newRootScreen(screen: ActivityScreen) {
        router.newRootScreen(screen)
    }

}