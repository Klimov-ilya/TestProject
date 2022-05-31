package klimov.test.recipe.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import klimov.test.recipe.entity.Recipe

@Dao
interface RecipeDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertRecipe(recipes: List<Recipe>)

    @Query("SELECT * FROM favourite_recipe")
    fun getAllFavouriteRecipes(): List<Recipe>
}