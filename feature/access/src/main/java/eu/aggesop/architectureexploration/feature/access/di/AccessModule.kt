package eu.aggesop.architectureexploration.feature.access.di

import eu.aggesop.architectureexploration.feature.access.api.AccessTileProvider
import eu.aggesop.architectureexploration.feature.access.data.datasource.AccessDataSource
import eu.aggesop.architectureexploration.feature.access.data.datasource.AccessDataSourceImpl
import eu.aggesop.architectureexploration.feature.access.data.repository.AccessRepositoryImpl
import eu.aggesop.architectureexploration.feature.access.domain.repository.AccessRepository
import eu.aggesop.architectureexploration.feature.access.domain.usecase.GetLockStateUseCase
import eu.aggesop.architectureexploration.feature.access.domain.usecase.GetLockStateUseCaseImpl
import eu.aggesop.architectureexploration.feature.access.domain.usecase.LockVehicleUseCase
import eu.aggesop.architectureexploration.feature.access.domain.usecase.LockVehicleUseCaseImpl
import eu.aggesop.architectureexploration.feature.access.domain.usecase.UnlockVehicleUseCase
import eu.aggesop.architectureexploration.feature.access.domain.usecase.UnlockVehicleUseCaseImpl
import eu.aggesop.architectureexploration.feature.access.ui.AccessTileProviderImpl
import eu.aggesop.architectureexploration.feature.access.ui.AccessViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val accessModule = module {
    // Data layer
    single<AccessDataSource> { AccessDataSourceImpl() }
    single<AccessRepository> { AccessRepositoryImpl(get()) }

    // Domain layer
    single<GetLockStateUseCase> { GetLockStateUseCaseImpl(get()) }
    single<LockVehicleUseCase> { LockVehicleUseCaseImpl(get()) }
    single<UnlockVehicleUseCase> { UnlockVehicleUseCaseImpl(get()) }

    // Presentation layer
    single<AccessTileProvider> { AccessTileProviderImpl() }
    viewModel { AccessViewModel(get(), get(), get()) }
}
