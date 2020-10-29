package eu.bbsapps.mynotetakingapp.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import eu.bbsapps.mynotetakingapp.db.Note
import eu.bbsapps.mynotetakingapp.db.NotesDatabaseDao
import kotlinx.coroutines.*

class AddEditViewModel(
    private val database: NotesDatabaseDao,
    private val id : Long
) : ViewModel() {

    var noteData = MutableLiveData<Note?>()
    private var viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    init {
        if(id!=-1L) getNote(id)
    }

    private fun getNote(id:Long) {
       uiScope.launch {
            val note = get(id)
            noteData.value = note
        }
    }

    fun updateNote(note: Note) {
        viewModelScope.launch(Dispatchers.IO) {
            update(note)
        }
    }

    fun insertNote(note: Note) {
        viewModelScope.launch(Dispatchers.IO) {
            insert(note)
        }
    }


    private suspend fun update(note: Note) {
        withContext(Dispatchers.IO) {
            database.update(note)
        }
    }

    private suspend fun insert(note: Note) {
        withContext(Dispatchers.IO) {
            database.insert(note)
        }
    }

    private suspend fun get(id: Long):Note? {
        return withContext(Dispatchers.IO) {
            database.get(id)
        }
    }
}