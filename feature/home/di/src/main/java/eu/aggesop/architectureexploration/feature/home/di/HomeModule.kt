package eu.aggesop.architectureexploration.feature.home.di

import eu.aggesop.architectureexploration.feature.home.api.HomeScreenProvider
import eu.aggesop.architectureexploration.feature.home.presentation.HomeScreenProviderImpl
import org.koin.dsl.module

val homeModule = module {
    single<HomeScreenProvider> { HomeScreenProviderImpl() }
}