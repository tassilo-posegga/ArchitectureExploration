package eu.aggesop.architectureexploration.feature.profile.di

import eu.aggesop.architectureexploration.feature.profile.api.ProfileScreenProvider
import eu.aggesop.architectureexploration.feature.profile.ui.ProfileScreenProviderImpl
import org.koin.dsl.module

val profileModule = module {
    single<ProfileScreenProvider> { ProfileScreenProviderImpl() }
}