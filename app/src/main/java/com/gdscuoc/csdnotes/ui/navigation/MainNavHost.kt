package com.gdscuoc.csdnotes.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.gdscuoc.csdnotes.ui.screens.AddNotePage
import com.gdscuoc.csdnotes.ui.utils.Screens

@Composable
fun MainNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = Screens.AddNotePage.navRoute
    ) {
        composable(Screens.AllNotes.navRoute) {

        }
        composable(Screens.AddNotePage.navRoute) {
            AddNotePage(navController)
        }
    }
}