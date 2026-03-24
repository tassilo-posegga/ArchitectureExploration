package eu.aggesop.architectureexploration.feature.access.api

import androidx.compose.runtime.Composable
import kotlinx.coroutines.flow.Flow

interface AccessTileProvider {
    @Composable
    fun AccessTile()
}

interface VehicleLockStateProvider {
    val isLocked: Flow<Boolean>
}
