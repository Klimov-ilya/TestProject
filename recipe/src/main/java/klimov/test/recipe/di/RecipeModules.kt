package klimov.test.recipe.di

import androidx.fragment.app.Fragment
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.Router
import klimov.test.core.navigation.RECIPE_BUILD_SCREEN_QUALIFIER
import klimov.test.core.navigation.RECIPE_SCREEN_QUALIFIER
import klimov.test.recipe.navigation.RecipeCoordinator
import klimov.test.recipe.repository.RecipeRepository
import klimov.test.recipe.ui.RecipeBuildFragment
import klimov.test.recipe.ui.RecipeFragment
import klimov.test.recipe.vm.RecipeBuildViewModel
import klimov.test.recipe.vm.RecipeViewModel
import org.koin.androidx.fragment.dsl.fragment
import org.koin.dsl.module

val recipeModules = module {
    fragment<Fragment>(qualifier = RECIPE_BUILD_SCREEN_QUALIFIER) { RecipeBuildFragment() }
    fragment<Fragment>(qualifier = RECIPE_SCREEN_QUALIFIER) { RecipeFragment() }

    single { RecipeCoordinator(get<Cicerone<Router>>().router) }
    single { RecipeRepository() }
    factory { RecipeViewModel(recipeRepository = get()) }
    factory { RecipeBuildViewModel(coordinator = get()) }
}