package com.nandakishore.Prepiq

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.FitnessCenter
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

sealed class BottomNavItem(val route: String, val icon: ImageVector, val label: String) {
    object Home : BottomNavItem("home", Icons.Default.Home, "Home")
    object Practice : BottomNavItem("practice", Icons.Outlined.FitnessCenter, "Practice")
    object Reminders : BottomNavItem("reminders", Icons.Default.Notifications, "Reminders")
    object Profile : BottomNavItem("profile", Icons.Default.Person, "Profile")
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    onNavigateToSessionSummary: () -> Unit = {}
) {
    val navController = rememberNavController()

    val items = listOf(
        BottomNavItem.Home,
        BottomNavItem.Practice,
        BottomNavItem.Reminders,
        BottomNavItem.Profile
    )

    Scaffold(
        bottomBar = {
            NavigationBar(
                containerColor = Color.White,
                contentColor = Color(0xFF5C5AE8)
            ) {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination

                items.forEach { item ->
                    NavigationBarItem(
                        icon = { Icon(item.icon, contentDescription = item.label) },
                        label = { Text(item.label) },
                        selected = currentDestination?.hierarchy?.any { it.route == item.route } == true,
                        onClick = {
                            navController.navigate(item.route) {
                                // Pop up to the start destination of the graph to
                                // avoid building up a large stack of destinations
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                // Avoid multiple copies of the same destination when
                                // reselecting the same item
                                launchSingleTop = true
                                // Restore state when reselecting a previously selected item
                                restoreState = true
                            }
                        },
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = Color(0xFF5C5AE8),
                            unselectedIconColor = Color.Gray,
                            selectedTextColor = Color(0xFF5C5AE8),
                            unselectedTextColor = Color.Gray,
                            indicatorColor = Color.Transparent
                        )
                    )
                }
            }
        }
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            NavHost(navController = navController, startDestination = BottomNavItem.Home.route) {
                composable(BottomNavItem.Home.route) { 
                    HomeScreen(onNavigateToSessionSummary = onNavigateToSessionSummary) 
                }
                composable(BottomNavItem.Practice.route) { PracticeScreen() }
                composable(BottomNavItem.Reminders.route) { RemindersScreen() }
                composable(BottomNavItem.Profile.route) { ProfileScreen() }
            }
        }
    }
}
