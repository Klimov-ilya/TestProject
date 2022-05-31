package klimov.test.recipe.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favourite_recipe")
data class Recipe(
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0,
    val label: String,
    val image: String,
    val url: String,
    val totalWeight: Double,
    val cuisineType: List<String>,
    val mealType: List<String>,
    val dishType: List<String>,
    val dietLabels: List<String>,
    val healthLabels: List<String>,
    val cautions: List<String>,
    val ingredientLines: List<String>,
    val calories: Double,
    val glycemicIndex: Double,
)