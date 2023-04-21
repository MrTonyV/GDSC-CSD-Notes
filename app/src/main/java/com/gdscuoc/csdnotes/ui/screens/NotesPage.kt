package com.gdscuoc.csdnotes.ui.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gdscuoc.csdnotes.data.entities.NoteEntity
import com.gdscuoc.csdnotes.ui.components.notes.NoteItem
import com.gdscuoc.csdnotes.ui.viewmodels.NotesViewModel

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun NotesPage(
    notesViewModel: NotesViewModel = NotesViewModel(LocalContext.current)
) {
    val notes by notesViewModel.notes.observeAsState(initial = null)

    LaunchedEffect(key1 = notes) {
        notesViewModel.getNotes()
    }

    if (notes == null) {
        Box(Modifier.fillMaxSize()) {
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center)
            )
        }
    } else if (notes!!.isEmpty()) {
        Box(
            Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp)) {
            Text(
                "You haven't added any notes yet...",
                modifier = Modifier.align(Alignment.Center),
                textAlign = TextAlign.Center,
                lineHeight = 2.sp,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        }
    } else {
        LazyColumn(
            Modifier
                .fillMaxSize(),
            contentPadding = PaddingValues(all = 16.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            userScrollEnabled = true
        ) {
            items(notes!!, key = { item: NoteEntity -> item.hashCode() }) {
                NoteItem(modifier = Modifier.animateItemPlacement(), noteEntity = it)
            }
        }
    }
}