package eu.aggesop.architectureexploration.feature.climatisation.presentation

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

data class ClimatisationState(
    val isAcOn: Boolean = false,
    val temperature: Int = 20
)

class ClimatisationViewModel : ViewModel() {
    private val _state = MutableStateFlow(ClimatisationState())
    val state: StateFlow<ClimatisationState> = _state.asStateFlow()

    fun toggleAc() {
        _state.value = _state.value.copy(isAcOn = !_state.value.isAcOn)
    }

    fun increaseTemperature() {
        val currentTemp = _state.value.temperature
        if (currentTemp < 30) {
            _state.value = _state.value.copy(temperature = currentTemp + 1)
        }
    }

    fun decreaseTemperature() {
        val currentTemp = _state.value.temperature
        if (currentTemp > 16) {
            _state.value = _state.value.copy(temperature = currentTemp - 1)
        }
    }
}