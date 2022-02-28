package klimov.test.testproject.recipe.di

import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.Router
import klimov.test.testproject.recipe.navigation.RecipeCoordinator
import klimov.test.testproject.recipe.repository.RecipeRepository
import klimov.test.testproject.recipe.vm.RecipeBuildViewModel
import klimov.test.testproject.recipe.vm.RecipeViewModel
import org.koin.dsl.module

val recipeModules = module {
    single { RecipeCoordinator(get<Cicerone<Router>>().router) }
    single { RecipeRepository() }
    factory { RecipeViewModel(recipeRepository = get()) }
    factory { RecipeBuildViewModel(coordinator = get()) }
}