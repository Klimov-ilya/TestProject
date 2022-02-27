package klimov.test.testproject

import android.app.Application
import klimov.test.testproject.common.di.recipeModules
import klimov.test.testproject.common.di.navigationModule
import klimov.test.testproject.common.network.Api
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App : Application() {

    // private val cicerone = Cicerone.create()
    // val router get() = cicerone.router
    // val navigatorHolder get() = cicerone.getNavigatorHolder()

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
        Api.init()

        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(
                recipeModules,
                navigationModule
            )
        }

    }

    companion object {
        internal lateinit var INSTANCE: App
            private set
    }
}