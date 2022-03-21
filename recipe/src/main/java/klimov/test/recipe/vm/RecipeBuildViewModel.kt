package klimov.test.recipe.vm

import android.os.Bundle
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import klimov.test.core.navigation.Screens
import klimov.test.core.vm.BaseViewModel
import klimov.test.recipe.entity.Diet
import klimov.test.recipe.entity.DietFormatter
import klimov.test.recipe.entity.MealFormatter
import klimov.test.recipe.entity.MealType
import klimov.test.recipe.entity.RecipeBuildEntity
import klimov.test.recipe.entity.RecipeBuildType
import klimov.test.recipe.navigation.RecipeCoordinator
import klimov.test.recipe.ui.RecipeFragment.Companion.EXTRA_RECIPE_ENTITY

class RecipeBuildViewModel(
    private val coordinator: RecipeCoordinator
) : BaseViewModel() {
    private val _queryLiveData = MutableLiveData<String>()
    private val _mealFormatterList = MutableLiveData(
        MealType.values().map { MealFormatter(it, false) }
    )
    private val _dietFormatterList = MutableLiveData(
        Diet.values().map { DietFormatter(it, false) }
    )

    val mealFormatterList: LiveData<List<MealFormatter>> get() = _mealFormatterList
    val dietFormatterList: LiveData<List<DietFormatter>> get() = _dietFormatterList

    fun setMealData(formatter: MealFormatter) {
        val currentList = _mealFormatterList.value as MutableList
        val indexOfChangedItem = currentList.indexOf(formatter)

        if (indexOfChangedItem != -1) {
            currentList[indexOfChangedItem] = MealFormatter(formatter.type, !formatter.isChecked)
        }

        _mealFormatterList.value = currentList
    }

    fun setDietData(formatter: DietFormatter) {
        val currentList = _dietFormatterList.value as MutableList
        val indexOfChangedItem = currentList.indexOf(formatter)

        if (indexOfChangedItem != -1) {
            currentList[indexOfChangedItem] = DietFormatter(formatter.type, !formatter.isChecked)
        }

        _dietFormatterList.value = currentList
    }

    fun setQuery(query: String) {
        _queryLiveData.value = query
    }

    fun navigateToRecipe() {
        val recipeBuildEntity = getRecipeBuildEntity()
        val args = Bundle().apply {
            putParcelable(EXTRA_RECIPE_ENTITY, recipeBuildEntity)
        }

        coordinator.navigateTo(Screens.RecipeScreen(args))
    }

    override fun handleError(throwable: Throwable) {
    }

    private fun getRecipeBuildEntity(): RecipeBuildEntity {
        val query = _queryLiveData.value.orEmpty()
        val mealType = _mealFormatterList.value?.filter { it.isChecked }?.map { it.type.value }
        val diets = _dietFormatterList.value?.filter { it.isChecked }?.map { it.type.value }

        // Just only this value yet
        val type = RecipeBuildType.PUBLIC.value

        return RecipeBuildEntity(mealType = mealType, diet = diets, type = type, query = query)
    }

}