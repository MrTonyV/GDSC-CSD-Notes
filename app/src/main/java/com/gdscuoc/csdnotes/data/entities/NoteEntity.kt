package com.gdscuoc.csdnotes.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notes")
data class NoteEntity(
    @ColumnInfo(name = "task_title") val title: String,
    @ColumnInfo(name = "task_desc") val description: String
) {
    @PrimaryKey(autoGenerate = true)
    var uid: Long = 0
}
