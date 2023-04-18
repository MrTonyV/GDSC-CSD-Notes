package com.gdscuoc.csdnotes.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.gdscuoc.csdnotes.data.daos.NotesDao
import com.gdscuoc.csdnotes.data.entities.NoteEntity

@Database(entities = [NoteEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getNotesDao(): NotesDao
}