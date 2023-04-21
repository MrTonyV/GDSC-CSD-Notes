package com.gdscuoc.csdnotes.ui.viewmodels

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gdscuoc.csdnotes.data.entities.NoteEntity
import com.gdscuoc.csdnotes.data.repositories.NotesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NotesViewModel(context: Context) : ViewModel() {

    private var notesRepository: NotesRepository = NotesRepository(context)
    private val _notes = MutableLiveData<List<NoteEntity>>(emptyList())
    val notes: LiveData<List<NoteEntity>> = _notes

    fun insertNote(title: String, description: String) {
        viewModelScope.launch(Dispatchers.IO) {
            notesRepository.insertNote(title, description)
        }
    }

    fun getNotes() {
        viewModelScope.launch(Dispatchers.IO) {
            _notes.postValue(notesRepository.getAllNotes())
        }
    }
}