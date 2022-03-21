package klimov.test.recipe.api

import klimov.test.core.network.Api

object RecipeNetwork {
    val recipeApi: RecipeApi by lazy { Api.getService(RecipeApi::class.java) }
}