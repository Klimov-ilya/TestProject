package klimov.test.testproject.di

import klimov.test.core.navigation.ClassContainer
import klimov.test.core.navigation.SINGLE_SCREEN_QUALIFIER
import klimov.test.testproject.common.SingleActivity
import org.koin.dsl.module

val appModules = module {
    single<ClassContainer>(qualifier = SINGLE_SCREEN_QUALIFIER) { ClassContainer(SingleActivity::class.java) }
}