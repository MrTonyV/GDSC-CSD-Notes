package com.gdscuoc.csdnotes.data.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.gdscuoc.csdnotes.data.entities.NoteEntity

@Dao
interface NotesDao {
    @Query("SELECT * from notes")
    suspend fun getAllNotes(): List<NoteEntity>

    @Insert
    suspend fun insertNote(note: NoteEntity) : Long
}