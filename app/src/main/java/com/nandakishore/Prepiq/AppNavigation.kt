package com.nandakishore.Prepiq

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "splash") {
        
        composable("splash") {
            SplashScreen(
                onSplashFinished = {
                    navController.navigate("login") {
                        popUpTo("splash") { inclusive = true }
                    }
                }
            )
        }
        
        composable("login") {
            LoginScreen(
                onNavigateToSignup = {
                    navController.navigate("signup")
                },
                onLoginSuccess = {
                    navController.navigate("main") {
                        popUpTo("login") { inclusive = true }
                    }
                }
            )
        }
        
        composable("signup") {
            SignupScreen(
                onNavigateBack = {
                    navController.popBackStack()
                },
                onSignupSuccess = {
                    navController.navigate("main") {
                        popUpTo("signup") { inclusive = true }
                        popUpTo("login") { inclusive = true }
                    }
                }
            )
        }
        
        composable("main") {
            MainScreen(
                onNavigateToSessionSummary = {
                    navController.navigate("session_summary")
                },
                onNavigateToMatchScore = {
                    navController.navigate("match_score")
                },
                onNavigateToAnswerScreen = {
                    navController.navigate("answer_screen")
                }
            )
        }

        composable("session_summary") {
            SessionSummaryScreen(
                onNavigateBack = { navController.popBackStack() },
                onDone = { navController.popBackStack() },
                onStartNewSession = { navController.popBackStack() }
            )
        }

        composable("match_score") {
            MatchScoreScreen(
                onNavigateBack = { navController.popBackStack() },
                onSeeRewrites = { navController.navigate("resume_rewrites") },
                onSkipToPractice = { navController.popBackStack() }
            )
        }

        composable("resume_rewrites") {
            ResumeRewritesScreen(
                onNavigateBack = { navController.popBackStack() },
                onContinueToPractice = {
                    // Navigate back to main (practice tab)
                    navController.popBackStack("main", inclusive = false)
                }
            )
        }

        composable("answer_screen") {
            AnswerScreen(
                onNavigateBack = { navController.popBackStack() },
                onFinishAndSeeSummary = {
                    // Pop up to main, then navigate to summary
                    navController.navigate("session_summary") {
                        popUpTo("main")
                    }
                }
            )
        }
    }
}
