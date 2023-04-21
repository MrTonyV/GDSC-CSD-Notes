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

    private var notesRepository: NotesRepository = NotesRepository(context)
    private val _notes = MutableLiveData<List<NoteEntity>?>(null)
    val notes: LiveData<List<NoteEntity>?> = _notes

    fun insertNote(
        title: String,
        description: String,
        onSuccess: (Long) -> Unit,
        onFailure: (String) -> Unit
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            val rowId = notesRepository.insertNote(title, description)
            if (rowId == -1L) {
                withContext(Dispatchers.Main) {
                    onFailure("Failed to insert note to database!")
                }
            } else {
                withContext(Dispatchers.Main) {
                    onSuccess(rowId)
                }
            }
        }
    }

    fun getNotes() {
        viewModelScope.launch(Dispatchers.IO) {
            _notes.postValue(notesRepository.getAllNotes())
        }
    }
}