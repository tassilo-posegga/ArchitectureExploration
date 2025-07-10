package eu.aggesop.architectureexploration.feature.climatisation.data.datasource

import eu.aggesop.architectureexploration.feature.climatisation.domain.model.ClimatisationData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class ClimatisationDataSourceImpl : ClimatisationDataSource {
    
    private val _climatisationData = MutableStateFlow(
        ClimatisationData(
            temperature = 22,
            isAcOn = false
        )
    )
    
    override fun getClimatisationData(): Flow<ClimatisationData> {
        return _climatisationData.asStateFlow()
    }
    
    override suspend fun updateClimatisationData(data: ClimatisationData) {
        _climatisationData.value = data
    }
}