package klimov.test.testproject.dashboard.di

import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.Router
import klimov.test.testproject.dashboard.navigation.DashboardCoordinator
import klimov.test.testproject.dashboard.vm.DashboardViewModel
import org.koin.dsl.module

val dashboardModules = module {
    single { DashboardCoordinator(get<Cicerone<Router>>().router) }
    factory { DashboardViewModel(coordinator = get()) }
}