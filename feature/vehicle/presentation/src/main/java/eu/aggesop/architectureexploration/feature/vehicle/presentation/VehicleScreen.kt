package eu.aggesop.architectureexploration.feature.vehicle.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import eu.aggesop.architectureexploration.feature.climatisation.api.ClimatisationTileProvider
import eu.aggesop.architectureexploration.feature.range.api.RangeTileProvider
import eu.aggesop.architectureexploration.feature.vehicle.api.VehicleScreenProvider
import org.koin.compose.koinInject

class VehicleScreenProviderImpl : VehicleScreenProvider {
    @Composable
    override fun VehicleScreen() {
        val climatisationProvider: ClimatisationTileProvider = koinInject()
        val rangeProvider: RangeTileProvider = koinInject()
        
        VehicleScreenContent(
            climatisationProvider = climatisationProvider,
            rangeProvider = rangeProvider
        )
    }
}

@Composable
internal fun VehicleScreenContent(
    climatisationProvider: ClimatisationTileProvider,
    rangeProvider: RangeTileProvider
) {
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
        
        // Range tile
        rangeProvider.RangeTile()
        
        // Climatisation tile
        climatisationProvider.ClimatisationTile()
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
        }
    )
}