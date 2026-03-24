package eu.aggesop.architectureexploration.feature.access.data.repository

import eu.aggesop.architectureexploration.feature.access.data.datasource.AccessDataSource
import eu.aggesop.architectureexploration.feature.access.domain.model.AccessLockState
import eu.aggesop.architectureexploration.feature.access.domain.repository.AccessRepository
import kotlinx.coroutines.flow.Flow

class AccessRepositoryImpl(
    private val dataSource: AccessDataSource
) : AccessRepository {
    override fun getLockState(): Flow<AccessLockState> {
        return dataSource.getLockState()
    }

    override suspend fun lock() {
        dataSource.updateLockState(AccessLockState.LOCKED)
    }

    override suspend fun unlock() {
        dataSource.updateLockState(AccessLockState.UNLOCKED)
    }
}
