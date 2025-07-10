package eu.aggesop.architectureexploration.feature.range.domain.usecase

import eu.aggesop.architectureexploration.feature.range.domain.model.RangeData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

interface GetRangeDataUseCase {
    operator fun invoke(): Flow<RangeData>
}

class GetRangeDataUseCaseImpl : GetRangeDataUseCase {
    override fun invoke(): Flow<RangeData> = flow {
        // Mock implementation - in real app this would call repository
        emit(
            RangeData(
                batteryPercentage = 75,
                estimatedRange = 320,
                isCharging = true
            )
        )
    }
}