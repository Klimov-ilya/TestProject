package klimov.test.testproject.recipe.api.request

data class RecipeRequest(
    val appId: String,
    val appKey: String,
    val type: String,
    val q: String,
    val mealType: List<String>? = null,
    val diet: List<String>? = null
)

data class RecipeResponse(
    val from: Int,
    val to: Int,
    val count: Int,
    val _links: RecipeLinks,
    val hits: List<Recipe>
)

data class RecipeLinks(
    val self: RecipeLinksItem,
    val next: RecipeLinksItem
)

data class RecipeLinksItem(
    val href: String,
    val title: String
)

data class Recipe(
    val recipe: RecipeItem
)

data class RecipeItem(
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
    val dishType: List<String>,
)
