package eu.aggesop.architectureexploration.feature.climatisation.data.datasource

import eu.aggesop.architectureexploration.feature.climatisation.domain.model.ClimatisationData
import kotlinx.coroutines.flow.Flow

interface ClimatisationDataSource {
    fun getClimatisationData(): Flow<ClimatisationData>
    suspend fun updateClimatisationData(data: ClimatisationData)
}