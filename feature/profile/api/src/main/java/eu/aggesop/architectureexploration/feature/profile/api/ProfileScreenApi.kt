package eu.aggesop.architectureexploration.feature.profile.api

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable

@Serializable
object ProfileRoute

interface ProfileScreenProvider {
    @Composable
    fun ProfileScreen()
}

fun NavGraphBuilder.profileScreen(provider: ProfileScreenProvider) {
    composable<ProfileRoute> {
        provider.ProfileScreen()
    }
}