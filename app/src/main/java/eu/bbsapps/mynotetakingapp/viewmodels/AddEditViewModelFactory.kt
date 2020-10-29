package eu.bbsapps.mynotetakingapp.viewmodels

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import eu.bbsapps.mynotetakingapp.db.NotesDatabaseDao

class AddEditViewModelFactory(
    private val dataSource: NotesDatabaseDao, private val id : Long
) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AddEditViewModel::class.java)) {
            return AddEditViewModel(dataSource,id) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}