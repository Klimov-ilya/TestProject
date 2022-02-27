package klimov.test.testproject.recipe.repository

import klimov.test.testproject.common.network.Api
import klimov.test.testproject.recipe.api.request.RecipeRequest

class RecipeRepository {
    suspend fun requestToGetRecipeList(request: RecipeRequest) =
        Api.recipeApi.getRecipeList(
            appId = request.appId,
            appKey = request.appKey,
            type = request.type,
            query = request.q,
            mealType = request.mealType,
            diet = request.diet
        )
}