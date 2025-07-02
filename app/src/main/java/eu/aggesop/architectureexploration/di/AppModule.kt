package eu.aggesop.architectureexploration.di

import eu.aggesop.architectureexploration.feature.climatisation.di.climatisationModule
import eu.aggesop.architectureexploration.feature.home.di.homeModule
import eu.aggesop.architectureexploration.feature.profile.di.profileModule
import eu.aggesop.architectureexploration.feature.range.di.rangeModule
import eu.aggesop.architectureexploration.feature.vehicle.di.vehicleModule
import org.koin.dsl.module

val appModule = module {
    includes(
        homeModule,
        profileModule,
        vehicleModule,
        climatisationModule,
        rangeModule
    )
}
