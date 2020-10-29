package eu.bbsapps.mynotetakingapp.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface NotesDatabaseDao {

    @Insert
    fun insert(note:Note)

    @Update
    fun update(note: Note)

    @Query("SELECT * FROM notes_table ORDER BY noteId DESC")
    fun getAllNotes(): LiveData<List<Note>>

    @Query("SELECT * FROM notes_table WHERE noteId= :key")
    fun get(key:Long) : Note

    @Query("DELETE FROM notes_table")
    fun clear()

    @Query("DELETE FROM notes_table WHERE noteId= :key")
    fun deleteNote(key:Long)

}