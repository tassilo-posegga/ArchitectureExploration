package eu.aggesop.architectureexploration.feature.climatisation.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AcUnit
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import eu.aggesop.architectureexploration.feature.climatisation.api.ClimatisationTileProvider
import org.koin.androidx.compose.koinViewModel

class ClimatisationTileProviderImpl : ClimatisationTileProvider {
    @Composable
    override fun ClimatisationTile() {
        val viewModel: ClimatisationViewModel = koinViewModel()
        val state by viewModel.state.collectAsState()
        
        ClimatisationTileContent(
            state = state,
            onToggleAc = viewModel::toggleAc,
            onIncreaseTemperature = viewModel::increaseTemperature,
            onDecreaseTemperature = viewModel::decreaseTemperature
        )
    }
}

@Composable
internal fun ClimatisationTileContent(
    state: ClimatisationState,
    onToggleAc: () -> Unit,
    onIncreaseTemperature: () -> Unit,
    onDecreaseTemperature: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Default.AcUnit,
                        contentDescription = "Air Conditioning",
                        tint = MaterialTheme.colorScheme.primary
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "Climate Control",
                        style = MaterialTheme.typography.titleMedium
                    )
                }
                Switch(
                    checked = state.isAcOn,
                    onCheckedChange = { onToggleAc() }
                )
            }
            
            Spacer(modifier = Modifier.height(16.dp))
            
            if (state.isAcOn) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Temperature",
                        style = MaterialTheme.typography.bodyMedium
                    )
                    
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        IconButton(onClick = onDecreaseTemperature) {
                            Icon(
                                imageVector = Icons.Default.Remove,
                                contentDescription = "Decrease temperature"
                            )
                        }
                        Text(
                            text = "${state.temperature}°C",
                            style = MaterialTheme.typography.titleLarge,
                            modifier = Modifier.padding(horizontal = 16.dp)
                        )
                        IconButton(onClick = onIncreaseTemperature) {
                            Icon(
                                imageVector = Icons.Default.Add,
                                contentDescription = "Increase temperature"
                            )
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ClimatisationTilePreview() {
    ClimatisationTileContent(
        state = ClimatisationState(isAcOn = true, temperature = 22),
        onToggleAc = {},
        onIncreaseTemperature = {},
        onDecreaseTemperature = {}
    )
}