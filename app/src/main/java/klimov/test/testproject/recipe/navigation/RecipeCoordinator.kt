package klimov.test.testproject.recipe.navigation

import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.androidx.FragmentScreen
import klimov.test.testproject.common.navigation.Coordinator

class RecipeCoordinator(private val router: Router) : Coordinator {
    override fun navigateTo(screen: FragmentScreen) {
        router.navigateTo(screen)
    }
}