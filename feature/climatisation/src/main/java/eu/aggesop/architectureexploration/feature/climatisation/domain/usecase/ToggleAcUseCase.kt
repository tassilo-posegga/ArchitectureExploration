package eu.aggesop.architectureexploration.feature.climatisation.domain.usecase

import eu.aggesop.architectureexploration.feature.climatisation.domain.model.ClimatisationData

interface ToggleAcUseCase {
    operator fun invoke(currentData: ClimatisationData): ClimatisationData
}

class ToggleAcUseCaseImpl : ToggleAcUseCase {
    override fun invoke(currentData: ClimatisationData): ClimatisationData {
        return currentData.copy(isAcOn = !currentData.isAcOn)
    }
}