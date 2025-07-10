package eu.aggesop.architectureexploration.feature.climatisation.domain.usecase

import eu.aggesop.architectureexploration.feature.climatisation.domain.model.ClimatisationData
import eu.aggesop.architectureexploration.feature.climatisation.domain.repository.ClimatisationRepository
import kotlinx.coroutines.flow.first

interface ToggleAcUseCase {
    suspend operator fun invoke()
}

class ToggleAcUseCaseImpl(
    private val repository: ClimatisationRepository
) : ToggleAcUseCase {
    override suspend fun invoke() {
        val currentData = repository.getClimatisationData().first()
        val updatedData = currentData.copy(isAcOn = !currentData.isAcOn)
        repository.updateClimatisationData(updatedData)
    }
}
