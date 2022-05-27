package klimov.test.recipe.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

internal enum class RecipeBuildType(val value: String) {
    PUBLIC("public")
}

internal enum class Diet(val value: String) {
    BALANCED("balanced"),
    HIGH_FIBER("high-fiber"),
    HIGH_PROTEIN("high-protein"),
    LOW_CARB("low-carb"),
    LOW_FAT("low-fat"),
    LOW_SODIUM("low-sodium")
}

internal enum class MealType(val value: String) {
    DINNER("dinner"),
    LUNCH("lunch"),
    SNACK("snack"),
    TEATIME("teatime")
}

internal interface RecipeBuildFormatter {
    fun getText(): String
    fun getCheckedValue(): Boolean
}

internal data class MealFormatter(
    val type: MealType,
    val isChecked: Boolean
) : RecipeBuildFormatter {
    override fun getText() = type.value
    override fun getCheckedValue() = isChecked
}

internal data class DietFormatter(
    val type: Diet,
    val isChecked: Boolean
) : RecipeBuildFormatter {
    override fun getText() = type.value
    override fun getCheckedValue() = isChecked
}

@Parcelize
internal data class RecipeBuildEntity(
    val query: String,
    val type: String,
    val mealType: List<String>? = null,
    val diet: List<String>? = null
) : Parcelable