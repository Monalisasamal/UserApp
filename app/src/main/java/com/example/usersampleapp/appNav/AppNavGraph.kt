package com.example.usersampleapp.appNav

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.app.common.NavigationObjects
import com.sample.presentation.view.SplashScreen
import com.sample.presentation.view.UserListScreen
import com.sample.presentation.view.UserDetailScreen

@Composable
fun AppNavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = NavigationObjects.splash.nav) {
        //navigation to SplashScreen
        composable(NavigationObjects.splash.nav) {
            SplashScreen(navController)
        }
        //navigation to UserListScreen
        composable(NavigationObjects.UserList.nav) {
            UserListScreen(navController)
        }
        //navigation to UserDetailScreen
        composable(NavigationObjects.Details.nav) { backStackEntry ->
            UserDetailScreen(navController = navController, backStackEntry = backStackEntry)
        }
    }
}
