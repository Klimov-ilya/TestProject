package klimov.test.recipe.vm

import klimov.test.core.network.DataStatus
import klimov.test.core.vm.BaseViewModel
import klimov.test.recipe.api.model.Recipe
import klimov.test.recipe.api.model.RecipeRequest
import klimov.test.recipe.entity.RecipeBuildEntity
import klimov.test.recipe.repository.RecipeRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class RecipeViewModel(
    private val recipeRepository: RecipeRepository,
) : BaseViewModel() {
    val dataStatus: StateFlow<DataStatus<List<Recipe>>> get() = _apiStatus

    private val _cachedData = MutableStateFlow<List<Recipe>?>(null)
    private val _apiStatus = MutableStateFlow<DataStatus<List<Recipe>>>(DataStatus.InitStatus())

    private var currentEntity: RecipeBuildEntity? = null

    fun setRecipeBuildEntity(recipeBuildEntity: RecipeBuildEntity?) {
        currentEntity = recipeBuildEntity
    }

    fun requestToGetRecipeList() = viewModelCoroutineScope.launch {
        _apiStatus.value = DataStatus.LoadingStatus(_cachedData.value)

        val request = RecipeRequest(
            appId = "6dbb40a3",
            appKey = "6f22d2218e40e0b74e7020dade143e29",
            type = currentEntity?.type ?: "public",
            q = currentEntity?.query.orEmpty(),
            mealType = currentEntity?.mealType,
            diet = currentEntity?.diet
        )

        recipeRepository.requestToGetRecipeList(request)
            .collect { response ->
            val c = response.hits.subList(0, 10)

            _cachedData.value = c
            _apiStatus.value = DataStatus.SuccessStatus(c)
        }
    }

    override fun handleError(throwable: Throwable) {
        _apiStatus.value = DataStatus.ErrorStatus(_cachedData.value, errorMessage = throwable.message)
    }
}