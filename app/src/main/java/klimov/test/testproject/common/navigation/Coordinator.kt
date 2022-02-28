package klimov.test.testproject.common.navigation

import com.github.terrakok.cicerone.androidx.FragmentScreen

interface Coordinator {
    fun navigateTo(screen: FragmentScreen)
}