package klimov.test.dashboard.vm

import klimov.test.core.navigation.Screens.RecipeBuildScreen
import klimov.test.core.vm.BaseViewModel
import klimov.test.dashboard.navigation.DashboardCoordinator

class DashboardViewModel(
    private val coordinator: DashboardCoordinator
) : BaseViewModel() {

    fun navigateToRecipeBuild() {
        coordinator.navigateTo(RecipeBuildScreen())
    }

    override fun handleError(throwable: Throwable) {
    }
}