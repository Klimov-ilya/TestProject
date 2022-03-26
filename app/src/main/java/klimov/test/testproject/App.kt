package klimov.test.testproject

import android.app.Application
import klimov.test.core.di.navigationModule
import klimov.test.dashboard.di.dashboardModules
import klimov.test.recipe.di.recipeModules
import klimov.test.testproject.di.appModules
import klimov.test.welcome.di.welcomeModules
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this

        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(
                appModules,
                navigationModule,
                welcomeModules,
                recipeModules,
                dashboardModules
            )
        }

    }

    companion object {
        internal lateinit var INSTANCE: App
            private set
    }
}