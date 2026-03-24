package eu.aggesop.architectureexploration.feature.access.domain.usecase

import eu.aggesop.architectureexploration.feature.access.domain.repository.AccessRepository

interface LockVehicleUseCase {
    suspend operator fun invoke()
}

class LockVehicleUseCaseImpl(
    private val repository: AccessRepository
) : LockVehicleUseCase {
    override suspend fun invoke() {
        repository.lock()
    }
}
