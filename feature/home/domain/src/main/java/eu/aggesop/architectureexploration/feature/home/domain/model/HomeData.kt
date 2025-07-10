package eu.aggesop.architectureexploration.feature.home.domain.model

data class HomeData(
    val welcomeMessage: String,
    val userName: String? = null
)