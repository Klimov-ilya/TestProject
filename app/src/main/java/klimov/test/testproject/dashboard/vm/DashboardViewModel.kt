package klimov.test.testproject.dashboard.vm

import klimov.test.testproject.common.navigation.screens.Screens
import klimov.test.testproject.common.vm.BaseViewModel
import klimov.test.testproject.dashboard.navigation.DashboardCoordinator

class DashboardViewModel(
    private val coordinator: DashboardCoordinator
) : BaseViewModel() {

    fun navigateToRecipeBuild() {
        coordinator.navigateTo(Screens.RecipeBuildScreen())
    }

    override fun handleError(throwable: Throwable) {
    }
}