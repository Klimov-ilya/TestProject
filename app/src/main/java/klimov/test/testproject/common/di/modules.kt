package klimov.test.testproject.common.di

import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.Router
import klimov.test.testproject.recipe.repository.RecipeRepository
import klimov.test.testproject.recipe.vm.RecipeBuildViewModel
import klimov.test.testproject.recipe.vm.RecipeViewModel
import org.koin.dsl.module

val recipeModules = module {
    single<RecipeRepository> { RecipeRepository() }
    factory { RecipeViewModel(recipeRepository = get()) }
    factory { RecipeBuildViewModel() }
}

val navigationModule = module {
    single { Cicerone.create() }
    single { get<Cicerone<Router>>().router }
    single { get<Cicerone<Router>>().getNavigatorHolder() }
}