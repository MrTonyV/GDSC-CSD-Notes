package com.gdscuoc.csdnotes.ui.screens

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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddNotePage(
    navController: NavController
) {
    var title = ""
    var description = ""

    Column(
        Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            label = { Text("Title") },
            value = title, onValueChange = {
                title = it.trim()
            })
        Spacer(Modifier.height(24.dp))
        OutlinedTextField(
            label = { Text("description") },
            value = description, onValueChange = {
                description = it.trim()
            })
        Spacer(Modifier.height(24.dp))
        Button(modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(), onClick = { /*TODO*/ }) {
            Text("Add Note")
        }
    }
}