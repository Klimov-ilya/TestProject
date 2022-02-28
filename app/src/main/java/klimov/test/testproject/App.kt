package klimov.test.testproject

import android.app.Application
import klimov.test.testproject.common.di.navigationModule
import klimov.test.testproject.common.network.Api
import klimov.test.testproject.dashboard.di.dashboardModules
import klimov.test.testproject.recipe.di.recipeModules
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
        Api.init()

        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(
                navigationModule,
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