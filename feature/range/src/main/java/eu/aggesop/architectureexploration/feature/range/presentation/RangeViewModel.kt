package eu.aggesop.architectureexploration.feature.range.presentation

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

data class RangeState(
    val batteryPercentage: Int = 80,
    val estimatedRange: Int = 350,
    val isCharging: Boolean = false
)

class RangeViewModel : ViewModel() {
    private val _state = MutableStateFlow(RangeState())
    val state: StateFlow<RangeState> = _state.asStateFlow()

    init {
        // Simulate some initial data from API
        loadRangeData()
    }

    private fun loadRangeData() {
        // Mock API call - in real implementation this would be a repository call
        _state.value = RangeState(
            batteryPercentage = 75,
            estimatedRange = 320,
            isCharging = true
        )
    }
}