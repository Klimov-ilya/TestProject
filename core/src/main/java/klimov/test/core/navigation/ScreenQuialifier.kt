package klimov.test.core.navigation

import org.koin.core.qualifier.StringQualifier

val SINGLE_SCREEN_QUALIFIER = StringQualifier("SingleActivity")

val SPLASH_SCREEN_QUALIFIER = StringQualifier("SplashFragment")
val INFORMATION_SCREEN_QUALIFIER = StringQualifier("InformationFragment")

val RECIPE_BUILD_SCREEN_QUALIFIER = StringQualifier("RecipeBuildFragment")
val RECIPE_SCREEN_QUALIFIER = StringQualifier("RecipeFragment")
val RECIPE_FAVOURITE_SCREEN_QUALIFIER = StringQualifier("RecipeFavouriteFragment")

val DASHBOARD_SCREEN_QUALIFIER = StringQualifier("DashboardFragment")