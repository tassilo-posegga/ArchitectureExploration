package eu.aggesop.architectureexploration.feature.climatisation.domain.usecase

import eu.aggesop.architectureexploration.feature.climatisation.domain.model.ClimatisationData

interface DecreaseTemperatureUseCase {
    operator fun invoke(currentData: ClimatisationData): ClimatisationData
}

class DecreaseTemperatureUseCaseImpl : DecreaseTemperatureUseCase {
    companion object {
        private const val MIN_TEMPERATURE = 16
    }

    override fun invoke(currentData: ClimatisationData): ClimatisationData {
        return if (currentData.temperature > MIN_TEMPERATURE) {
            currentData.copy(temperature = currentData.temperature - 1)
        } else {
            currentData
        }
    }
}