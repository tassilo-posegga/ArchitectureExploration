package eu.aggesop.architectureexploration

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import eu.aggesop.architectureexploration.feature.home.api.HOME_ROUTE
import eu.aggesop.architectureexploration.feature.home.api.HomeScreenProvider
import eu.aggesop.architectureexploration.feature.home.api.homeScreen
import eu.aggesop.architectureexploration.feature.profile.api.PROFILE_ROUTE
import eu.aggesop.architectureexploration.feature.profile.api.ProfileScreenProvider
import eu.aggesop.architectureexploration.feature.profile.api.profileScreen
import eu.aggesop.architectureexploration.feature.vehicle.api.VEHICLE_ROUTE
import eu.aggesop.architectureexploration.feature.vehicle.api.VehicleScreenProvider
import eu.aggesop.architectureexploration.feature.vehicle.api.vehicleScreen
import eu.aggesop.architectureexploration.ui.theme.ArchitectureExplorationTheme
import org.koin.compose.koinInject

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArchitectureExplorationTheme {
                ArchitectureExplorationApp()
            }
        }
    }
}

@PreviewScreenSizes
@Composable
fun ArchitectureExplorationApp() {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    val homeProvider: HomeScreenProvider = koinInject()
    val profileProvider: ProfileScreenProvider = koinInject()
    val vehicleProvider: VehicleScreenProvider = koinInject()

    NavigationSuiteScaffold(
        navigationSuiteItems = {
            AppDestinations.entries.forEach { destination ->
                item(
                    icon = {
                        Icon(
                            destination.icon,
                            contentDescription = destination.label
                        )
                    },
                    label = { Text(destination.label) },
                    selected = currentRoute == destination.route,
                    onClick = {
                        navController.navigate(destination.route) {
                            popUpTo(navController.graph.startDestinationId) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                )
            }
        }
    ) {
        NavHost(
            navController = navController,
            startDestination = HOME_ROUTE,
            modifier = Modifier.fillMaxSize()
        ) {
            homeScreen(homeProvider)
            profileScreen(profileProvider)
            vehicleScreen(vehicleProvider)
        }
    }
}

enum class AppDestinations(
    val label: String,
    val icon: ImageVector,
    val route: String,
) {
    HOME("Home", Icons.Default.Home, HOME_ROUTE),
    VEHICLE("Vehicle", Icons.Default.Settings, VEHICLE_ROUTE),
    PROFILE("Profile", Icons.Default.AccountBox, PROFILE_ROUTE),
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ArchitectureExplorationTheme {
        Greeting("Android")
    }
}
