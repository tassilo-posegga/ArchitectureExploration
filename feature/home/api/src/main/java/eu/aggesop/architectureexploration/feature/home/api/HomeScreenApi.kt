package eu.aggesop.architectureexploration.feature.home.api

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

const val HOME_ROUTE = "home"

interface HomeScreenProvider {
    @Composable
    fun HomeScreen()
}

fun NavGraphBuilder.homeScreen(provider: HomeScreenProvider) {
    composable(HOME_ROUTE) {
        provider.HomeScreen()
    }
}
