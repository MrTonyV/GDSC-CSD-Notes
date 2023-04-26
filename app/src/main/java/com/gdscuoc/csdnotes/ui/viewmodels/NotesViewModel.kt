package com.gdscuoc.csdnotes.ui.viewmodels

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gdscuoc.csdnotes.data.entities.NoteEntity
import com.gdscuoc.csdnotes.data.repositories.NotesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class NotesViewModel(context: Context) : ViewModel() {

}