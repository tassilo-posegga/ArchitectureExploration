package eu.aggesop.architectureexploration.feature.vehicle.di

import eu.aggesop.architectureexploration.feature.vehicle.api.VehicleScreenProvider
import eu.aggesop.architectureexploration.feature.vehicle.presentation.VehicleScreenProviderImpl
import org.koin.dsl.module

val vehicleModule = module {
    single<VehicleScreenProvider> { VehicleScreenProviderImpl() }
}