package eu.aggesop.architectureexploration.feature.access.data.datasource

import eu.aggesop.architectureexploration.feature.access.domain.model.AccessLockState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class AccessDataSourceImpl : AccessDataSource {
    private val _lockState = MutableStateFlow(AccessLockState.LOCKED)

    override fun getLockState(): Flow<AccessLockState> {
        return _lockState.asStateFlow()
    }

    override suspend fun updateLockState(state: AccessLockState) {
        _lockState.value = state
    }
}
