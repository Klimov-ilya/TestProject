package klimov.test.testproject.common.di

import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.Router
import klimov.test.testproject.common.navigation.SingleActivityCoordinator
import org.koin.dsl.module

val navigationModule = module {
    single { Cicerone.create() }
    single { get<Cicerone<Router>>().router }
    single { get<Cicerone<Router>>().getNavigatorHolder() }
    single { SingleActivityCoordinator(get<Cicerone<Router>>().router) }
}