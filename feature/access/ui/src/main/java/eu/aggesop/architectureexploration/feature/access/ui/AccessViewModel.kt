package eu.aggesop.architectureexploration.feature.access.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import eu.aggesop.architectureexploration.feature.access.domain.model.AccessLockState
import eu.aggesop.architectureexploration.feature.access.domain.usecase.GetLockStateUseCase
import eu.aggesop.architectureexploration.feature.access.domain.usecase.LockVehicleUseCase
import eu.aggesop.architectureexploration.feature.access.domain.usecase.UnlockVehicleUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

data class AccessState(
    val lockState: AccessLockState = AccessLockState.LOCKED
)

class AccessViewModel(
    private val getLockStateUseCase: GetLockStateUseCase,
    private val lockVehicleUseCase: LockVehicleUseCase,
    private val unlockVehicleUseCase: UnlockVehicleUseCase
) : ViewModel() {
    private val _state = MutableStateFlow(AccessState())
    val state: StateFlow<AccessState> = _state.asStateFlow()

    init {
        viewModelScope.launch {
            getLockStateUseCase().collect { lockState ->
                _state.value = AccessState(lockState = lockState)
            }
        }
    }

    fun toggleLock() {
        viewModelScope.launch {
            if (_state.value.lockState == AccessLockState.LOCKED) {
                unlockVehicleUseCase()
            } else {
                lockVehicleUseCase()
            }
        }
    }
}
