package eu.aggesop.architectureexploration.feature.range.di

import eu.aggesop.architectureexploration.feature.range.api.RangeTileProvider
import eu.aggesop.architectureexploration.feature.range.domain.usecase.GetRangeDataUseCase
import eu.aggesop.architectureexploration.feature.range.domain.usecase.GetRangeDataUseCaseImpl
import eu.aggesop.architectureexploration.feature.range.presentation.RangeTileProviderImpl
import eu.aggesop.architectureexploration.feature.range.presentation.RangeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val rangeModule = module {
    // Domain layer
    single<GetRangeDataUseCase> { GetRangeDataUseCaseImpl() }
    
    // Presentation layer
    single<RangeTileProvider> { RangeTileProviderImpl() }
    viewModel { RangeViewModel(get()) }
}