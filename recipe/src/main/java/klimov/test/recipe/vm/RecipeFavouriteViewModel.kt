package klimov.test.recipe.vm

import klimov.test.core.vm.BaseViewModel
import klimov.test.recipe.repository.RecipeRepository

internal class RecipeFavouriteViewModel(
    private val recipeRepository: RecipeRepository
) : BaseViewModel() {
    init {

    }

    override fun handleError(throwable: Throwable) = Unit


}