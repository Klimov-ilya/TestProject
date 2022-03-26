package klimov.test.welcome.interactor

import klimov.test.core.navigation.Screens
import klimov.test.welcome.navigation.WelcomeCoordinator

class WelcomeInteractor(private val coordinator: WelcomeCoordinator) {

    fun navigateToInstruction() {
        coordinator.newRootScreen(Screens.InformationScreen())
    }

    fun navigateToSingleActivity() {
        coordinator.newRootScreen(Screens.SingleAccitivtyScreen())
    }

}