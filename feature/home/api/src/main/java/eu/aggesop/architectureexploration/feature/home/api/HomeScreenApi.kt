package eu.aggesop.architectureexploration.feature.home.api

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable

@Serializable
object HomeRoute

interface HomeScreenProvider {
    @Composable
    fun HomeScreen()
}

fun NavGraphBuilder.homeScreen(provider: HomeScreenProvider) {
    composable<HomeRoute> {
        provider.HomeScreen()
    }
}
