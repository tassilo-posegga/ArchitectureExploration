package eu.aggesop.architectureexploration.feature.access.domain.usecase

import eu.aggesop.architectureexploration.feature.access.domain.model.AccessLockState
import eu.aggesop.architectureexploration.feature.access.domain.repository.AccessRepository
import kotlinx.coroutines.flow.Flow

interface GetLockStateUseCase {
    operator fun invoke(): Flow<AccessLockState>
}

class GetLockStateUseCaseImpl(
    private val repository: AccessRepository
) : GetLockStateUseCase {
    override fun invoke(): Flow<AccessLockState> {
        return repository.getLockState()
    }
}
