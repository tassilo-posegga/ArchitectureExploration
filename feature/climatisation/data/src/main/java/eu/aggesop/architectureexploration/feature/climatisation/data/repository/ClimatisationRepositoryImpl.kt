package eu.aggesop.architectureexploration.feature.climatisation.data.repository

import eu.aggesop.architectureexploration.feature.climatisation.data.datasource.ClimatisationDataSource
import eu.aggesop.architectureexploration.feature.climatisation.domain.model.ClimatisationData
import eu.aggesop.architectureexploration.feature.climatisation.domain.repository.ClimatisationRepository
import kotlinx.coroutines.flow.Flow

class ClimatisationRepositoryImpl(
    private val dataSource: ClimatisationDataSource
) : ClimatisationRepository {
    
    override fun getClimatisationData(): Flow<ClimatisationData> {
        return dataSource.getClimatisationData()
    }
    
    override suspend fun updateClimatisationData(data: ClimatisationData) {
        dataSource.updateClimatisationData(data)
    }
}