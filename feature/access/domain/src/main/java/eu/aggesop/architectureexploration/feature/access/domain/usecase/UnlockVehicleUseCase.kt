package eu.aggesop.architectureexploration.feature.access.domain.usecase

import eu.aggesop.architectureexploration.feature.access.domain.repository.AccessRepository

interface UnlockVehicleUseCase {
    suspend operator fun invoke()
}

class UnlockVehicleUseCaseImpl(
    private val repository: AccessRepository
) : UnlockVehicleUseCase {
    override suspend fun invoke() {
        repository.unlock()
    }
}
