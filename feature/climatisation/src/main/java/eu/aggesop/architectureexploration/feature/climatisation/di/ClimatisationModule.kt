package eu.aggesop.architectureexploration.feature.climatisation.di

import eu.aggesop.architectureexploration.feature.climatisation.api.ClimatisationTileProvider
import eu.aggesop.architectureexploration.feature.climatisation.domain.usecase.DecreaseTemperatureUseCase
import eu.aggesop.architectureexploration.feature.climatisation.domain.usecase.DecreaseTemperatureUseCaseImpl
import eu.aggesop.architectureexploration.feature.climatisation.domain.usecase.IncreaseTemperatureUseCase
import eu.aggesop.architectureexploration.feature.climatisation.domain.usecase.IncreaseTemperatureUseCaseImpl
import eu.aggesop.architectureexploration.feature.climatisation.domain.usecase.ToggleAcUseCase
import eu.aggesop.architectureexploration.feature.climatisation.domain.usecase.ToggleAcUseCaseImpl
import eu.aggesop.architectureexploration.feature.climatisation.presentation.ClimatisationTileProviderImpl
import eu.aggesop.architectureexploration.feature.climatisation.presentation.ClimatisationViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val climatisationModule = module {
    single<ToggleAcUseCase> { ToggleAcUseCaseImpl() }
    single<IncreaseTemperatureUseCase> { IncreaseTemperatureUseCaseImpl() }
    single<DecreaseTemperatureUseCase> { DecreaseTemperatureUseCaseImpl() }
    single<ClimatisationTileProvider> { ClimatisationTileProviderImpl() }
    viewModel { ClimatisationViewModel(get(), get(), get()) }
}
