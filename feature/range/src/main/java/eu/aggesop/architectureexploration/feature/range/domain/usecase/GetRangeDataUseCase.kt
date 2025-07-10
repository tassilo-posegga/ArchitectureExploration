package eu.aggesop.architectureexploration.feature.range.domain.usecase

import eu.aggesop.architectureexploration.feature.range.domain.model.RangeData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

interface GetRangeDataUseCase {
    operator fun invoke(): Flow<RangeData>
}

class GetRangeDataUseCaseImpl : GetRangeDataUseCase {
    override fun invoke(): Flow<RangeData> = flow {
        // Mock API call - in real implementation this would call a repository
        // that handles network requests and data persistence
        emit(
            RangeData(
                batteryPercentage = 75,
                estimatedRange = 320,
                isCharging = true
            )
        )
    }
}
