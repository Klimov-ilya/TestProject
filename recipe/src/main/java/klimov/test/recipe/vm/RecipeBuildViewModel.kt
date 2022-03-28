package klimov.test.recipe.vm

import androidx.core.os.bundleOf
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
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class RecipeBuildViewModel(
    private val coordinator: RecipeCoordinator
) : BaseViewModel() {
    private val _queryFlow = MutableStateFlow<String?>(null)
    private val _mealFormatterFlow = MutableStateFlow(
        MealType.values().map { MealFormatter(it, false) }
    )
    private val _dietFormatterFlow = MutableStateFlow(
        Diet.values().map { DietFormatter(it, false) }
    )

    val mealFormatterFlow: StateFlow<List<MealFormatter>> get() = _mealFormatterFlow
    val dietFormatterFlow: StateFlow<List<DietFormatter>> get() = _dietFormatterFlow

    fun setMealData(formatter: MealFormatter) {
        val currentList = _mealFormatterFlow.value as MutableList
        val indexOfChangedItem = currentList.indexOf(formatter)

        if (indexOfChangedItem != ELEMENT_NOT_FOUND_INDEX) {
            currentList[indexOfChangedItem] = MealFormatter(formatter.type, !formatter.isChecked)
        }

        _mealFormatterFlow.value = currentList
    }

    fun setDietData(formatter: DietFormatter) {
        val currentList = _dietFormatterFlow.value as MutableList
        val indexOfChangedItem = currentList.indexOf(formatter)

        if (indexOfChangedItem != ELEMENT_NOT_FOUND_INDEX) {
            currentList[indexOfChangedItem] = DietFormatter(formatter.type, !formatter.isChecked)
        }

        _dietFormatterFlow.value = currentList
    }

    fun setQuery(query: String) {
        _queryFlow.value = query
    }

    fun navigateToRecipe() {
        val recipeBuildEntity = getRecipeBuildEntity()
        val args = bundleOf(EXTRA_RECIPE_ENTITY to recipeBuildEntity)

        coordinator.navigateTo(Screens.RecipeScreen(args))
    }

    override fun handleError(throwable: Throwable) {
    }

    private fun getRecipeBuildEntity(): RecipeBuildEntity {
        val query = _queryFlow.value.orEmpty()
        val mealType = _mealFormatterFlow.value.filter { it.isChecked }.map { it.type.value }
        val diets = _dietFormatterFlow.value.filter { it.isChecked }.map { it.type.value }

        // Just only this value yet
        val type = RecipeBuildType.PUBLIC.value

        return RecipeBuildEntity(mealType = mealType, diet = diets, type = type, query = query)
    }

    companion object {
        private const val ELEMENT_NOT_FOUND_INDEX = -1
    }

}