package eu.aggesop.architectureexploration.feature.range.di

import eu.aggesop.architectureexploration.feature.range.api.RangeTileProvider
import eu.aggesop.architectureexploration.feature.range.presentation.RangeTileProviderImpl
import eu.aggesop.architectureexploration.feature.range.presentation.RangeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val rangeModule = module {
    single<RangeTileProvider> { RangeTileProviderImpl() }
    viewModel { RangeViewModel() }
}