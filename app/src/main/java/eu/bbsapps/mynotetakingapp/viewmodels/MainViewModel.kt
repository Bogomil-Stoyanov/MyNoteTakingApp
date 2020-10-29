package eu.bbsapps.mynotetakingapp.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import eu.bbsapps.mynotetakingapp.db.NotesDatabaseDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel(private val database: NotesDatabaseDao) : ViewModel() {

    val notes = database.getAllNotes()

    fun deleteNote(key: Long) {
        viewModelScope.launch(Dispatchers.IO) {
            deleteSingleNote(key)
        }
    }

    private suspend fun deleteSingleNote(key: Long) {
        withContext(Dispatchers.IO) {
            database.deleteNote(key)
        }

    }
}