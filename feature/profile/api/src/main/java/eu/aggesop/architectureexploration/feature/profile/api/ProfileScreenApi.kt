package eu.aggesop.architectureexploration.feature.profile.api

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

const val PROFILE_ROUTE = "profile"

interface ProfileScreenProvider {
    @Composable
    fun ProfileScreen()
}

fun NavGraphBuilder.profileScreen(provider: ProfileScreenProvider) {
    composable(PROFILE_ROUTE) {
        provider.ProfileScreen()
    }
}