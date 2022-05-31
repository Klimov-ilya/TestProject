package klimov.test.recipe.api.model

import klimov.test.recipe.entity.Recipe

internal data class RecipeRequest(
    val appId: String,
    val appKey: String,
    val type: String,
    val q: String,
    val mealType: List<String>? = null,
    val diet: List<String>? = null
)

internal data class RecipeObjectResponse(
    val from: Int,
    val to: Int,
    val count: Int,
    val _links: RecipeLinksResponse,
    val hits: List<RecipeResponse>
)

internal data class RecipeLinksResponse(val self: RecipeLinksItemResponse, val next: RecipeLinksItemResponse)

internal data class RecipeLinksItemResponse(val href: String, val title: String)

internal data class RecipeResponse(val recipe: RecipeItemResponse) {
    companion object {
        fun toRecipe(recipe: RecipeResponse) = Recipe(
            label = recipe.recipe.label,
            image = recipe.recipe.image,
            url = recipe.recipe.url,
            totalWeight = recipe.recipe.totalWeight,
            cuisineType = recipe.recipe.cuisineType,
            mealType = recipe.recipe.mealType,
            dishType = recipe.recipe.dishType,
            dietLabels = recipe.recipe.dietLabels,
            healthLabels = recipe.recipe.healthLabels,
            cautions = recipe.recipe.cautions,
            ingredientLines = recipe.recipe.ingredientLines,
            calories = recipe.recipe.calories,
            glycemicIndex = recipe.recipe.glycemicIndex
        )
    }
}

internal data class RecipeItemResponse(
    val uri: String,
    val label: String,
    val image: String,
    val source: String,
    val url: String,
    val shareAs: String,
    val yield: Int,
    val dietLabels: List<String>,
    val healthLabels: List<String>,
    val cautions: List<String>,
    val ingredientLines: List<String>,
    val calories: Double,
    val glycemicIndex: Double,
    val totalCO2Emissions: Double,
    val co2EmissionsClass: String,
    val totalWeight: Double,
    val cuisineType: List<String>,
    val mealType: List<String>,
    val dishType: List<String>
)
