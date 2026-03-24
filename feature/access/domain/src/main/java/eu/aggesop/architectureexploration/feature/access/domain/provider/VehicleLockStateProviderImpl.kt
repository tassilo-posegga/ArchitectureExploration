package eu.aggesop.architectureexploration.feature.access.domain.provider

import eu.aggesop.architectureexploration.feature.access.api.VehicleLockStateProvider
import eu.aggesop.architectureexploration.feature.access.domain.model.AccessLockState
import eu.aggesop.architectureexploration.feature.access.domain.usecase.GetLockStateUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class VehicleLockStateProviderImpl(
    private val getLockStateUseCase: GetLockStateUseCase
) : VehicleLockStateProvider {
    override val isLocked: Flow<Boolean> = getLockStateUseCase().map { it == AccessLockState.LOCKED }
}
