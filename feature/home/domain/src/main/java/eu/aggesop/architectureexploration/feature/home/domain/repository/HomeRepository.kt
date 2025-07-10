package eu.aggesop.architectureexploration.feature.home.domain.repository

import eu.aggesop.architectureexploration.feature.home.domain.model.HomeData
import kotlinx.coroutines.flow.Flow

interface HomeRepository {
    fun getHomeData(): Flow<HomeData>
}