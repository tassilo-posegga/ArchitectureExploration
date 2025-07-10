package eu.aggesop.architectureexploration.feature.home.domain.usecase

import eu.aggesop.architectureexploration.feature.home.domain.model.HomeData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

interface GetHomeDataUseCase {
    operator fun invoke(): Flow<HomeData>
}

class GetHomeDataUseCaseImpl : GetHomeDataUseCase {
    override fun invoke(): Flow<HomeData> = flow {
        // Mock implementation - in real app this would call repository
        emit(
            HomeData(
                welcomeMessage = "Welcome to the Architecture Exploration app!",
                userName = null
            )
        )
    }
}