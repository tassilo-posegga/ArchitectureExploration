package eu.aggesop.architectureexploration.feature.climatisation.domain.usecase

import eu.aggesop.architectureexploration.feature.climatisation.domain.model.ClimatisationData
import eu.aggesop.architectureexploration.feature.climatisation.domain.repository.ClimatisationRepository
import kotlinx.coroutines.flow.first

interface IncreaseTemperatureUseCase {
    suspend operator fun invoke()
}

class IncreaseTemperatureUseCaseImpl(
    private val repository: ClimatisationRepository
) : IncreaseTemperatureUseCase {
    companion object {
        private const val MAX_TEMPERATURE = 30
    }

    override suspend fun invoke() {
        val currentData = repository.getClimatisationData().first()
        if (currentData.temperature < MAX_TEMPERATURE) {
            val updatedData = currentData.copy(temperature = currentData.temperature + 1)
            repository.updateClimatisationData(updatedData)
        }
    }
}
