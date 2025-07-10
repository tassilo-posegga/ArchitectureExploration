package eu.aggesop.architectureexploration.feature.home.domain.usecase

import eu.aggesop.architectureexploration.feature.home.domain.model.HomeData
import eu.aggesop.architectureexploration.feature.home.domain.repository.HomeRepository
import kotlinx.coroutines.flow.Flow

interface GetHomeDataUseCase {
    operator fun invoke(): Flow<HomeData>
}

class GetHomeDataUseCaseImpl(
    private val repository: HomeRepository
) : GetHomeDataUseCase {
    override fun invoke(): Flow<HomeData> {
        return repository.getHomeData()
    }
}
