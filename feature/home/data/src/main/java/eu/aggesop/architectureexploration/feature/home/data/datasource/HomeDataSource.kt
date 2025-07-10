package eu.aggesop.architectureexploration.feature.home.data.datasource

import eu.aggesop.architectureexploration.feature.home.domain.model.HomeData
import kotlinx.coroutines.flow.Flow

interface HomeDataSource {
    fun getHomeData(): Flow<HomeData>
}