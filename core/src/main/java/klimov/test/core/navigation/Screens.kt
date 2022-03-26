package klimov.test.core.navigation

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.github.terrakok.cicerone.androidx.ActivityScreen
import com.github.terrakok.cicerone.androidx.FragmentScreen
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

object Screens : KoinComponent {

    fun SingleAccitivtyScreen() = ActivityScreen(SINGLE_ACTIVITY_QUALIFIER.value) { context ->
        val container: ClassContainer by inject(qualifier = SINGLE_ACTIVITY_QUALIFIER)

        return@ActivityScreen Intent(context, container.cls)
    }

    fun RecipeBuildScreen() = FragmentScreen(RECIPE_BUILD_FRAGMENT_QUALIFIER.value) {
        val fragment: Fragment by inject(qualifier = RECIPE_BUILD_FRAGMENT_QUALIFIER)
        return@FragmentScreen fragment
    }

    fun RecipeScreen(args: Bundle) = FragmentScreen(RECIPE_FRAGMENT_QUALIFIER.value) {
        val fragment: Fragment by inject(qualifier = RECIPE_FRAGMENT_QUALIFIER)
        fragment.arguments = args

        return@FragmentScreen fragment
    }

    fun DashboardScreen() = FragmentScreen(DASHBOARD_FRAGMENT_QUALIFIER.value) {
        val fragment: Fragment by inject(qualifier = DASHBOARD_FRAGMENT_QUALIFIER)
        return@FragmentScreen fragment
    }

    fun SplashScreen() = FragmentScreen(SPLASH_QUALIFIER.value) {
        val fragment: Fragment by inject(qualifier = SPLASH_QUALIFIER)
        return@FragmentScreen fragment
    }

    fun InformationScreen() = FragmentScreen(INFORMATION_QUALIFIER.value) {
        val fragment: Fragment by inject(qualifier = INFORMATION_QUALIFIER)
        return@FragmentScreen fragment
    }

}