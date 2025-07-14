package eu.aggesop.architectureexploration.feature.climatisation.di

import eu.aggesop.architectureexploration.feature.climatisation.api.ClimatisationTileProvider
import eu.aggesop.architectureexploration.feature.climatisation.data.datasource.ClimatisationDataSource
import eu.aggesop.architectureexploration.feature.climatisation.data.datasource.ClimatisationDataSourceImpl
import eu.aggesop.architectureexploration.feature.climatisation.data.repository.ClimatisationRepositoryImpl
import eu.aggesop.architectureexploration.feature.climatisation.domain.repository.ClimatisationRepository
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
    // Data layer
    single<ClimatisationDataSource> { ClimatisationDataSourceImpl() }
    single<ClimatisationRepository> { ClimatisationRepositoryImpl(get()) }

    // Domain layer
    single<ToggleAcUseCase> { ToggleAcUseCaseImpl(get()) }
    single<IncreaseTemperatureUseCase> { IncreaseTemperatureUseCaseImpl(get()) }
    single<DecreaseTemperatureUseCase> { DecreaseTemperatureUseCaseImpl(get()) }

    // Presentation layer
    single<ClimatisationTileProvider> { ClimatisationTileProviderImpl() }
    viewModel { ClimatisationViewModel(get(), get(), get(), get()) }
}
