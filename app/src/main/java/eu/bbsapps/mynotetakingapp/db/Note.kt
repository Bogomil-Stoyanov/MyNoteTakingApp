package eu.bbsapps.mynotetakingapp.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "notes_table")
data class Note(@PrimaryKey(autoGenerate = true) var noteId: Long = 0L,
           @ColumnInfo(name = "title") var noteTitle: String = "",
           @ColumnInfo(name = "text") var noteText: String = "",
           @ColumnInfo(name = "color") var noteColor: Int = -1):Serializable
