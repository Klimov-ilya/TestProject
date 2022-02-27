package klimov.test.testproject.common.screens

import com.github.terrakok.cicerone.androidx.FragmentScreen
import klimov.test.testproject.dashboard.ui.DashboardFragment
import klimov.test.testproject.recipe.entity.RecipeBuildEntity
import klimov.test.testproject.recipe.ui.RecipeBuildFragment
import klimov.test.testproject.recipe.ui.RecipeFragment

object Screens {

    fun DashboardScreen() = FragmentScreen { DashboardFragment.newInstance() }

    fun RecipeBuildScreen() = FragmentScreen { RecipeBuildFragment.newInstance() }

    fun RecipeScreen(recipeBuildEntity: RecipeBuildEntity) =
        FragmentScreen { RecipeFragment.newInstance(recipeBuildEntity) }

}