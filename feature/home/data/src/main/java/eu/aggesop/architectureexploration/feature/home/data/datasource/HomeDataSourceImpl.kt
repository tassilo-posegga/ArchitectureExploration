package eu.aggesop.architectureexploration.feature.home.data.datasource

import eu.aggesop.architectureexploration.feature.home.domain.model.HomeData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class HomeDataSourceImpl : HomeDataSource {
    
    override fun getHomeData(): Flow<HomeData> = flow {
        // This could be replaced with actual data fetching from API or local storage
        emit(
            HomeData(
                welcomeMessage = "Welcome to the Architecture Exploration app!",
                userName = null
            )
        )
    }
}