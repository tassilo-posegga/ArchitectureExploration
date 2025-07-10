package eu.aggesop.architectureexploration.feature.climatisation.domain.usecase

import eu.aggesop.architectureexploration.feature.climatisation.domain.model.ClimatisationData

interface IncreaseTemperatureUseCase {
    operator fun invoke(currentData: ClimatisationData): ClimatisationData
}

class IncreaseTemperatureUseCaseImpl : IncreaseTemperatureUseCase {
    companion object {
        private const val MAX_TEMPERATURE = 30
    }

    override fun invoke(currentData: ClimatisationData): ClimatisationData {
        return if (currentData.temperature < MAX_TEMPERATURE) {
            currentData.copy(temperature = currentData.temperature + 1)
        } else {
            currentData
        }
    }
}