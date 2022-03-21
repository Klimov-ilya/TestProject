package klimov.test.recipe.repository

import klimov.test.recipe.api.RecipeNetwork
import klimov.test.recipe.api.model.RecipeRequest

class RecipeRepository {
    suspend fun requestToGetRecipeList(request: RecipeRequest) =
        RecipeNetwork.recipeApi.getRecipeList(
            appId = request.appId,
            appKey = request.appKey,
            type = request.type,
            query = request.q,
            mealType = request.mealType,
            diet = request.diet
        )
}