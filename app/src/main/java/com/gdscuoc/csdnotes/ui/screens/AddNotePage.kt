package com.gdscuoc.csdnotes.ui.screens

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.gdscuoc.csdnotes.ui.utils.Screens
import com.gdscuoc.csdnotes.ui.viewmodels.NotesViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddNotePage(
    navController: NavController,
    notesViewModel: NotesViewModel = NotesViewModel(LocalContext.current)
) {
    val context = LocalContext.current
    var title by rememberSaveable { mutableStateOf("") }
    var description by rememberSaveable { mutableStateOf("") }

    Column(
        Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp, vertical = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            label = { Text("Title") },
            value = title, onValueChange = {
                title = it.trim()
            })
        Spacer(Modifier.height(24.dp))
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            label = { Text("Description") },
            value = description, onValueChange = {
                description = it.trim()
            })
        Spacer(Modifier.weight(1f))
        Button(modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(), onClick = {
            notesViewModel.insertNote(title, description, onFailure = { errorMsg ->
                Toast.makeText(context, errorMsg, Toast.LENGTH_LONG).show()
            }, onSuccess = { rowId ->
                Toast.makeText(context, "Note with id $rowId added to db!", Toast.LENGTH_LONG)
                    .show()
                navController.navigate(Screens.AllNotes.navRoute)
            })
        }) {
            Text("Add Note")
        }
    }
}