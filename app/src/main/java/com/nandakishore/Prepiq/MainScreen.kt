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
    onNavigateToSessionSummary: () -> Unit = {},
    onNavigateToMatchScore: () -> Unit = {},
    onNavigateToAnswerScreen: () -> Unit = {},
    onNavigateToEditProfile: () -> Unit = {},
    onNavigateToSignOut: () -> Unit = {}
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
                tonalElevation = 8.dp
            ) {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination

                items.forEach { screen ->
                    val selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true
                    NavigationBarItem(
                        icon = {
                            Icon(
                                imageVector = screen.icon,
                                contentDescription = screen.title,
                                tint = if (selected) Color(0xFF5C5AE8) else Color(0xFF6B6A70)
                            )
                        },
                        label = {
                            Text(
                                text = screen.title,
                                color = if (selected) Color(0xFF5C5AE8) else Color(0xFF6B6A70)
                            )
                        },
                        selected = selected,
                        onClick = {
                            navController.navigate(screen.route) {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        },
                        colors = NavigationBarItemDefaults.colors(
                            indicatorColor = Color(0xFFF5F4F0)
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
                composable(BottomNavItem.Practice.route) { 
                    PracticeScreen(onNavigateToAnswerScreen = onNavigateToAnswerScreen) 
                }
                composable(BottomNavItem.Reminders.route) { RemindersScreen() }
                composable(BottomNavItem.Profile.route) { 
                    ProfileScreen(
                        onNavigateToMatchScore = onNavigateToMatchScore,
                        onNavigateToEditProfile = onNavigateToEditProfile,
                        onNavigateToSignOut = onNavigateToSignOut
                    ) 
                }
            }
        }
    }
}
