package eu.aggesop.architectureexploration.feature.access.data.datasource

import eu.aggesop.architectureexploration.feature.access.domain.model.AccessLockState
import kotlinx.coroutines.flow.Flow

interface AccessDataSource {
    fun getLockState(): Flow<AccessLockState>
    suspend fun updateLockState(state: AccessLockState)
}
