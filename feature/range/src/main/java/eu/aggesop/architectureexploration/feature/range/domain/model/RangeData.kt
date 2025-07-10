package eu.aggesop.architectureexploration.feature.range.domain.model

data class RangeData(
    val batteryPercentage: Int,
    val estimatedRange: Int,
    val isCharging: Boolean
)