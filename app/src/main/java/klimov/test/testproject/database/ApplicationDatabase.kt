package klimov.test.testproject.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import klimov.test.recipe.database.RecipeDao
import klimov.test.recipe.entity.Recipe

@Database(entities = [Recipe::class], version = 1, exportSchema = false)
abstract class ApplicationDatabase : RoomDatabase() {

    abstract fun getFavouriteRecipeDao(): RecipeDao

    companion object {
        private const val DATABASE_NAME = "application_database"

        @Volatile
        private var INSTANCE: ApplicationDatabase? = null

        fun getInstance(context: Context): ApplicationDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(context, ApplicationDatabase::class.java, DATABASE_NAME)
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                instance
            }
        }

    }

}
