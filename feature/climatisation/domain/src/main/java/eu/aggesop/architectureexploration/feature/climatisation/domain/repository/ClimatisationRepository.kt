package eu.aggesop.architectureexploration.feature.climatisation.domain.repository

import eu.aggesop.architectureexploration.feature.climatisation.domain.model.ClimatisationData
import kotlinx.coroutines.flow.Flow

interface ClimatisationRepository {
    fun getClimatisationData(): Flow<ClimatisationData>
    suspend fun updateClimatisationData(data: ClimatisationData)
}