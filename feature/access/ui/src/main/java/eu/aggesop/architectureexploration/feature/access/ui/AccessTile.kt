package eu.aggesop.architectureexploration.feature.access.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.LockOpen
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import eu.aggesop.architectureexploration.feature.access.api.AccessTileProvider
import eu.aggesop.architectureexploration.feature.access.domain.model.AccessLockState
import org.koin.androidx.compose.koinViewModel

class AccessTileProviderImpl : AccessTileProvider {
    @Composable
    override fun AccessTile() {
        val viewModel: AccessViewModel = koinViewModel()
        val state by viewModel.state.collectAsState()

        AccessTileContent(
            state = state,
            onToggleLock = viewModel::toggleLock
        )
    }
}

@Composable
internal fun AccessTileContent(
    state: AccessState,
    onToggleLock: () -> Unit
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
                        imageVector = if (state.lockState == AccessLockState.LOCKED) Icons.Default.Lock else Icons.Default.LockOpen,
                        contentDescription = "Lock State",
                        tint = MaterialTheme.colorScheme.primary
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "Vehicle Access",
                        style = MaterialTheme.typography.titleMedium
                    )
                }
                
                Button(onClick = onToggleLock) {
                    Text(text = if (state.lockState == AccessLockState.LOCKED) "Unlock" else "Lock")
                }
            }
            
            Text(
                text = "Vehicle is currently ${if (state.lockState == AccessLockState.LOCKED) "Locked" else "Unlocked"}",
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(top = 8.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun AccessTilePreviewLocked() {
    AccessTileContent(
        state = AccessState(lockState = AccessLockState.LOCKED),
        onToggleLock = {}
    )
}

@Preview(showBackground = true)
@Composable
private fun AccessTilePreviewUnlocked() {
    AccessTileContent(
        state = AccessState(lockState = AccessLockState.UNLOCKED),
        onToggleLock = {}
    )
}
