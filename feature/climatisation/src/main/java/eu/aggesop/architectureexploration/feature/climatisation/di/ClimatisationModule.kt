package eu.aggesop.architectureexploration.feature.climatisation.di

import eu.aggesop.architectureexploration.feature.climatisation.api.ClimatisationTileProvider
import eu.aggesop.architectureexploration.feature.climatisation.presentation.ClimatisationTileProviderImpl
import eu.aggesop.architectureexploration.feature.climatisation.presentation.ClimatisationViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val climatisationModule = module {
    single<ClimatisationTileProvider> { ClimatisationTileProviderImpl() }
    viewModel { ClimatisationViewModel() }
}