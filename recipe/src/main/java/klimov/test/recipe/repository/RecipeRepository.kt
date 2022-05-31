package klimov.test.recipe.repository

import klimov.test.recipe.api.RecipeNetwork
import klimov.test.recipe.api.model.RecipeObjectResponse
import klimov.test.recipe.api.model.RecipeRequest
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

internal class RecipeRepository {

    suspend fun requestToGetRecipeList(request: RecipeRequest): Flow<RecipeObjectResponse> = flow {
        val recipeResponse = RecipeNetwork.recipeApi.getRecipeList(
            appId = request.appId,
            appKey = request.appKey,
            type = request.type,
            query = request.q,
            mealType = request.mealType,
            diet = request.diet
        )
        emit(recipeResponse)
    }

}