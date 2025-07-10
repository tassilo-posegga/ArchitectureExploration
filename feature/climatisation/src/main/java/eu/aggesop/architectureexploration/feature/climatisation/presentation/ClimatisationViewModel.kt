package eu.aggesop.architectureexploration.feature.climatisation.presentation

import androidx.lifecycle.ViewModel
import eu.aggesop.architectureexploration.feature.climatisation.domain.model.ClimatisationData
import eu.aggesop.architectureexploration.feature.climatisation.domain.usecase.DecreaseTemperatureUseCase
import eu.aggesop.architectureexploration.feature.climatisation.domain.usecase.IncreaseTemperatureUseCase
import eu.aggesop.architectureexploration.feature.climatisation.domain.usecase.ToggleAcUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

data class ClimatisationState(
    val isAcOn: Boolean = false,
    val temperature: Int = 20
)

class ClimatisationViewModel(
    private val toggleAcUseCase: ToggleAcUseCase,
    private val increaseTemperatureUseCase: IncreaseTemperatureUseCase,
    private val decreaseTemperatureUseCase: DecreaseTemperatureUseCase
) : ViewModel() {
    private val _state = MutableStateFlow(ClimatisationState())
    val state: StateFlow<ClimatisationState> = _state.asStateFlow()

    fun toggleAc() {
        val currentData = _state.value.toClimatisationData()
        val updatedData = toggleAcUseCase(currentData)
        _state.value = updatedData.toClimatisationState()
    }

    fun increaseTemperature() {
        val currentData = _state.value.toClimatisationData()
        val updatedData = increaseTemperatureUseCase(currentData)
        _state.value = updatedData.toClimatisationState()
    }

    fun decreaseTemperature() {
        val currentData = _state.value.toClimatisationData()
        val updatedData = decreaseTemperatureUseCase(currentData)
        _state.value = updatedData.toClimatisationState()
    }

    private fun ClimatisationState.toClimatisationData(): ClimatisationData {
        return ClimatisationData(
            isAcOn = isAcOn,
            temperature = temperature
        )
    }

    private fun ClimatisationData.toClimatisationState(): ClimatisationState {
        return ClimatisationState(
            isAcOn = isAcOn,
            temperature = temperature
        )
    }
}
