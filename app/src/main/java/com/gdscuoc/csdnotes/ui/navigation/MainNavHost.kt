package com.gdscuoc.csdnotes.ui.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.gdscuoc.csdnotes.ui.screens.AddNotePage
import com.gdscuoc.csdnotes.ui.utils.Screens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    var currentScreen by remember {
        mutableStateOf(Screens.AllNotes.name)
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            CenterAlignedTopAppBar(title = { Text(currentScreen, fontSize = 20.sp) })
        }
    ) { paddingValues ->
        NavHost(
            modifier = modifier.padding(paddingValues),
            navController = navController,
            startDestination = Screens.AddNotePage.navRoute
        ) {
            composable(Screens.AllNotes.navRoute) {
                currentScreen = Screens.AllNotes.name
            }
            composable(Screens.AddNotePage.navRoute) {
                AddNotePage(navController)
                currentScreen = Screens.AddNotePage.name
            }
        }
    }
}