package eu.aggesop.architectureexploration.feature.access.domain.repository

import eu.aggesop.architectureexploration.feature.access.domain.model.AccessLockState
import kotlinx.coroutines.flow.Flow

interface AccessRepository {
    fun getLockState(): Flow<AccessLockState>
    suspend fun lock()
    suspend fun unlock()
}
