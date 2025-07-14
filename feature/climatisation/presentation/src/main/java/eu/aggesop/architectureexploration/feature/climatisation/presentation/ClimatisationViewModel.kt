package eu.aggesop.architectureexploration.feature.climatisation.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import eu.aggesop.architectureexploration.feature.climatisation.domain.model.ClimatisationData
import eu.aggesop.architectureexploration.feature.climatisation.domain.repository.ClimatisationRepository
import eu.aggesop.architectureexploration.feature.climatisation.domain.usecase.DecreaseTemperatureUseCase
import eu.aggesop.architectureexploration.feature.climatisation.domain.usecase.IncreaseTemperatureUseCase
import eu.aggesop.architectureexploration.feature.climatisation.domain.usecase.ToggleAcUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

data class ClimatisationState(
    val isAcOn: Boolean = false,
    val temperature: Int = 20
)

class ClimatisationViewModel(
    private val repository: ClimatisationRepository,
    private val toggleAcUseCase: ToggleAcUseCase,
    private val increaseTemperatureUseCase: IncreaseTemperatureUseCase,
    private val decreaseTemperatureUseCase: DecreaseTemperatureUseCase
) : ViewModel() {
    private val _state = MutableStateFlow(ClimatisationState())
    val state: StateFlow<ClimatisationState> = _state.asStateFlow()

    init {
        viewModelScope.launch {
            repository.getClimatisationData().collect { data ->
                _state.value = data.toClimatisationState()
            }
        }
    }

    fun toggleAc() {
        viewModelScope.launch {
            toggleAcUseCase()
        }
    }

    fun increaseTemperature() {
        viewModelScope.launch {
            increaseTemperatureUseCase()
        }
    }

    fun decreaseTemperature() {
        viewModelScope.launch {
            decreaseTemperatureUseCase()
        }
    }

    private fun ClimatisationData.toClimatisationState(): ClimatisationState {
        return ClimatisationState(
            isAcOn = isAcOn,
            temperature = temperature
        )
    }
}
