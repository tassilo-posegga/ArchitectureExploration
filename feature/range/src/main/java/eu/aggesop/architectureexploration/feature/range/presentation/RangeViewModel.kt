package eu.aggesop.architectureexploration.feature.range.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import eu.aggesop.architectureexploration.feature.range.domain.model.RangeData
import eu.aggesop.architectureexploration.feature.range.domain.usecase.GetRangeDataUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

data class RangeState(
    val batteryPercentage: Int = 80,
    val estimatedRange: Int = 350,
    val isCharging: Boolean = false
)

class RangeViewModel(
    private val getRangeDataUseCase: GetRangeDataUseCase
) : ViewModel() {
    private val _state = MutableStateFlow(RangeState())
    val state: StateFlow<RangeState> = _state.asStateFlow()

    init {
        loadRangeData()
    }

    private fun loadRangeData() {
        viewModelScope.launch {
            getRangeDataUseCase()
                .catch { 
                    // Handle error - in real implementation you might want to emit an error state
                    // For now, keep the default state
                }
                .collect { rangeData ->
                    _state.value = rangeData.toRangeState()
                }
        }
    }

    private fun RangeData.toRangeState(): RangeState {
        return RangeState(
            batteryPercentage = batteryPercentage,
            estimatedRange = estimatedRange,
            isCharging = isCharging
        )
    }
}
