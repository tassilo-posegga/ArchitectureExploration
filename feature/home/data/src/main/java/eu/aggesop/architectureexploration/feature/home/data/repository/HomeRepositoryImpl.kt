package eu.aggesop.architectureexploration.feature.home.data.repository

import eu.aggesop.architectureexploration.feature.home.data.datasource.HomeDataSource
import eu.aggesop.architectureexploration.feature.home.domain.model.HomeData
import eu.aggesop.architectureexploration.feature.home.domain.repository.HomeRepository
import kotlinx.coroutines.flow.Flow

class HomeRepositoryImpl(
    private val dataSource: HomeDataSource
) : HomeRepository {
    
    override fun getHomeData(): Flow<HomeData> {
        return dataSource.getHomeData()
    }
}