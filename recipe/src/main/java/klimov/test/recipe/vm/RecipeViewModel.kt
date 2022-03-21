package klimov.test.recipe.vm

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import klimov.test.core.network.ApiStatus
import klimov.test.core.vm.BaseViewModel
import klimov.test.recipe.api.model.Recipe
import klimov.test.recipe.api.model.RecipeRequest
import klimov.test.recipe.entity.RecipeBuildEntity
import klimov.test.recipe.repository.RecipeRepository
import kotlinx.coroutines.launch

class RecipeViewModel(
    private val recipeRepository: RecipeRepository,
) : BaseViewModel() {
    val apiStatus: LiveData<ApiStatus<List<Recipe>>> get() = _apiStatus

    private val _cachedData = MutableLiveData<List<Recipe>>()
    private val _apiStatus = MutableLiveData<ApiStatus<List<Recipe>>>()

    fun requestToGetRecipeList(recipeBuildEntity: RecipeBuildEntity?) = viewModelCoroutineScope.launch {
        _apiStatus.value = ApiStatus.LoadingStatus(_cachedData.value)

        val request = RecipeRequest(
            appId = "6dbb40a3",
            appKey = "6f22d2218e40e0b74e7020dade143e29",
            type = recipeBuildEntity?.type ?: "public",
            q = recipeBuildEntity?.query.orEmpty(),
            mealType = recipeBuildEntity?.mealType,
            diet = recipeBuildEntity?.diet
        )

        val data = recipeRepository.requestToGetRecipeList(request)

        val c = data.hits.subList(0, 10)

        _cachedData.value = c
        _apiStatus.value = ApiStatus.SuccessStatus(c)
    }

    override fun handleError(throwable: Throwable) {
        _apiStatus.value = ApiStatus.ErrorStatus(_cachedData.value, errorMessage = throwable.message)
    }
}