package eu.aggesop.architectureexploration.feature.range.api

import androidx.compose.runtime.Composable

interface RangeTileProvider {
    @Composable
    fun RangeTile()
}

interface RangeDomain {
    fun getRangeData(): RangeData
}