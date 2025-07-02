package eu.aggesop.architectureexploration.feature.vehicle.api

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

const val VEHICLE_ROUTE = "vehicle"

interface VehicleScreenProvider {
    @Composable
    fun VehicleScreen()
}

fun NavGraphBuilder.vehicleScreen(provider: VehicleScreenProvider) {
    composable(VEHICLE_ROUTE) {
        provider.VehicleScreen()
    }
}