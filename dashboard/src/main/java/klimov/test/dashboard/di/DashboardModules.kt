package klimov.test.dashboard.di

import androidx.fragment.app.Fragment
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.Router
import klimov.test.core.navigation.DASHBOARD_SCREEN_QUALIFIER
import klimov.test.dashboard.navigation.DashboardCoordinator
import klimov.test.dashboard.ui.DashboardFragment
import klimov.test.dashboard.vm.DashboardViewModel
import org.koin.androidx.fragment.dsl.fragment
import org.koin.dsl.module

val dashboardModules = module {
    fragment<Fragment>(qualifier = DASHBOARD_SCREEN_QUALIFIER) { DashboardFragment() }

    single { DashboardCoordinator(get<Cicerone<Router>>().router) }
    factory { DashboardViewModel(coordinator = get()) }
}