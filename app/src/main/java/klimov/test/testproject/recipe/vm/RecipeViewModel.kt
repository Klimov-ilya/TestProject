package klimov.test.testproject.recipe.vm

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import klimov.test.testproject.common.network.ApiStatus
import klimov.test.testproject.common.vm.BaseViewModel
import klimov.test.testproject.recipe.api.request.Recipe
import klimov.test.testproject.recipe.api.request.RecipeRequest
import klimov.test.testproject.recipe.entity.RecipeBuildEntity
import klimov.test.testproject.recipe.repository.RecipeRepository
import kotlinx.coroutines.launch

class RecipeViewModel(
    private val recipeRepository: RecipeRepository,
) : BaseViewModel() {
    val apiStatus: LiveData<ApiStatus<List<Recipe>>> get() = _apiStatus

    private val _apiStatus = MutableLiveData<ApiStatus<List<Recipe>>>()
    private val _cachedData = MutableLiveData<List<Recipe>>()

    fun requestToGetRecipeList(recipeBuildEntity: RecipeBuildEntity?) = viewModelCoroutineScope.launch {
        _apiStatus.value = ApiStatus.LoadingStatus(_cachedData.value)

        val request = RecipeRequest(
            appId = "6dbb40a3",
            appKey = "6f22d2218e40e0b74e7020dade143e29",
            type = "public",
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