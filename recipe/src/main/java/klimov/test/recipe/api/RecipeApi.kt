package klimov.test.recipe.api

import klimov.test.recipe.api.model.RecipeObjectResponse
import retrofit2.http.GET
import retrofit2.http.Query

internal interface RecipeApi {
    @GET("/api/recipes/v2")
    suspend fun getRecipeList(
        @Query("type") type: String,
        @Query("app_id") appId: String,
        @Query("app_key") appKey: String,
        @Query("q") query: String,
        @Query("mealType") mealType: List<String>? = null,
        @Query("diet") diet: List<String>? = null
    ): RecipeObjectResponse
}