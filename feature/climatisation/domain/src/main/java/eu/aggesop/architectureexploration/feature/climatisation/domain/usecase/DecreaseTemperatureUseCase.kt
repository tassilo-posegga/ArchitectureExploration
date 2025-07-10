package eu.aggesop.architectureexploration.feature.climatisation.domain.usecase

import eu.aggesop.architectureexploration.feature.climatisation.domain.model.ClimatisationData
import eu.aggesop.architectureexploration.feature.climatisation.domain.repository.ClimatisationRepository
import kotlinx.coroutines.flow.first

interface DecreaseTemperatureUseCase {
    suspend operator fun invoke()
}

class DecreaseTemperatureUseCaseImpl(
    private val repository: ClimatisationRepository
) : DecreaseTemperatureUseCase {
    companion object {
        private const val MIN_TEMPERATURE = 16
    }

    override suspend fun invoke() {
        val currentData = repository.getClimatisationData().first()
        if (currentData.temperature > MIN_TEMPERATURE) {
            val updatedData = currentData.copy(temperature = currentData.temperature - 1)
            repository.updateClimatisationData(updatedData)
        }
    }
}
