package eu.bbsapps.mynotetakingapp.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notes_table")
class Note(@PrimaryKey(autoGenerate = true) var noteId: Long = 0L,
           @ColumnInfo(name = "title") val noteTitle: String = "",
           @ColumnInfo(name = "text") var noteText: String = "",
           @ColumnInfo(name = "color") var noteColor: Int = -1)
