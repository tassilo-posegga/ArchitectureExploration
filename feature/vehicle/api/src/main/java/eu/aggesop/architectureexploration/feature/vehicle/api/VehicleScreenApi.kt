package eu.aggesop.architectureexploration.feature.vehicle.api

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable

@Serializable
object VehicleRoute

interface VehicleScreenProvider {
    @Composable
    fun VehicleScreen()
}

fun NavGraphBuilder.vehicleScreen(provider: VehicleScreenProvider) {
    composable<VehicleRoute> {
        provider.VehicleScreen()
    }
}