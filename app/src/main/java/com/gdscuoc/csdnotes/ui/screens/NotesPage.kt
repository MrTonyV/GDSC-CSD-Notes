package com.gdscuoc.csdnotes.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import com.gdscuoc.csdnotes.ui.viewmodels.NotesViewModel

@Composable
fun NotesPage(
    navController: NavController,
    notesViewModel: NotesViewModel = NotesViewModel(LocalContext.current)
) {
}