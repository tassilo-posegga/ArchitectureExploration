package eu.aggesop.architectureexploration.feature.vehicle.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DirectionsCar
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.LockOpen
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import eu.aggesop.architectureexploration.feature.access.api.AccessTileProvider
import eu.aggesop.architectureexploration.feature.access.api.VehicleLockStateProvider
import eu.aggesop.architectureexploration.feature.climatisation.api.ClimatisationTileProvider
import eu.aggesop.architectureexploration.feature.range.api.RangeTileProvider
import eu.aggesop.architectureexploration.feature.vehicle.api.VehicleScreenProvider
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import org.koin.compose.koinInject

class VehicleScreenProviderImpl : VehicleScreenProvider {
    @Composable
    override fun VehicleScreen() {
        val climatisationProvider: ClimatisationTileProvider = koinInject()
        val rangeProvider: RangeTileProvider = koinInject()
        val accessProvider: AccessTileProvider = koinInject()
        val lockStateProvider: VehicleLockStateProvider = koinInject()
        
        VehicleScreenContent(
            climatisationProvider = climatisationProvider,
            rangeProvider = rangeProvider,
            accessProvider = accessProvider,
            lockStateProvider = lockStateProvider
        )
    }
}

@Composable
internal fun VehicleScreenContent(
    climatisationProvider: ClimatisationTileProvider,
    rangeProvider: RangeTileProvider,
    accessProvider: AccessTileProvider,
    lockStateProvider: VehicleLockStateProvider
) {
    val isLocked by lockStateProvider.isLocked.collectAsState(initial = true)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            text = "Vehicle Control",
            style = MaterialTheme.typography.headlineMedium,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // Vehicle Image with Lock Status
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .clip(MaterialTheme.shapes.large)
                .background(MaterialTheme.colorScheme.surfaceVariant),
            contentAlignment = Alignment.Center
        ) {
            // Placeholder for vehicle image
            Icon(
                imageVector = Icons.Default.DirectionsCar,
                contentDescription = null,
                modifier = Modifier.size(120.dp),
                tint = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.5f)
            )

            // Lock icon overlay
            Box(
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(16.dp)
                    .size(40.dp)
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.surface.copy(alpha = 0.8f)),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = if (isLocked) Icons.Default.Lock else Icons.Default.LockOpen,
                    contentDescription = if (isLocked) "Locked" else "Unlocked",
                    tint = if (isLocked) MaterialTheme.colorScheme.primary else Color.Gray,
                    modifier = Modifier.size(24.dp)
                )
            }
        }
        
        // Range tile
        rangeProvider.RangeTile()
        
        // Climatisation tile
        climatisationProvider.ClimatisationTile()

        // Access tile
        accessProvider.AccessTile()
    }
}

@Preview(showBackground = true)
@Composable
private fun VehicleScreenPreview() {
    // For preview, we can't use Koin injection, so we create mock providers
    VehicleScreenContent(
        climatisationProvider = object : ClimatisationTileProvider {
            @Composable
            override fun ClimatisationTile() {
                Text("Climatisation Tile Preview")
            }
        },
        rangeProvider = object : RangeTileProvider {
            @Composable
            override fun RangeTile() {
                Text("Range Tile Preview")
            }
        },
        accessProvider = object : AccessTileProvider {
            @Composable
            override fun AccessTile() {
                Text("Access Tile Preview")
            }
        },
        lockStateProvider = object : VehicleLockStateProvider {
            override val isLocked: Flow<Boolean> = flowOf(true)
        }
    )
}