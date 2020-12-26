package eu.bbsapps.mynotetakingapp.ui.mainFragment

import android.app.AlertDialog
import android.content.ActivityNotFoundException
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.View
import android.widget.PopupMenu
import androidx.core.app.ShareCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import eu.bbsapps.mynotetakingapp.R
import eu.bbsapps.mynotetakingapp.adapters.NoteItemAdapter
import eu.bbsapps.mynotetakingapp.databinding.FragmentMainBinding
import eu.bbsapps.mynotetakingapp.db.Note
import eu.bbsapps.mynotetakingapp.db.NotesDatabase
import eu.bbsapps.mynotetakingapp.dialog.NoteDialog
import eu.bbsapps.mynotetakingapp.viewmodels.MainViewModel
import eu.bbsapps.mynotetakingapp.viewmodels.MainViewModelFactory


class MainFragment : Fragment(R.layout.fragment_main), NoteItemAdapter.OnItemClickListener {

    lateinit var noteItemAdapter: NoteItemAdapter
    lateinit var viewModel: MainViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentMainBinding.bind(view)

        val application = requireNotNull(this.activity).application
        val dataSource = NotesDatabase.getInstance(application).notesDatabaseDao
        val viewModelFactory = MainViewModelFactory(dataSource)
        viewModel =
            ViewModelProviders.of(this, viewModelFactory).get(MainViewModel::class.java)

        noteItemAdapter = NoteItemAdapter(this)

        viewModel.notes.observe(viewLifecycleOwner) { notes ->
            noteItemAdapter.submitList(notes)
        }

        binding.notesRecyclerView.apply {
            adapter = noteItemAdapter
            val staggeredGridLayoutManager = StaggeredGridLayoutManager(
                2,
                LinearLayoutManager.VERTICAL
            )
            layoutManager = staggeredGridLayoutManager
        }

        binding.floatingActionButton.setOnClickListener {
            editNote(-1)
        }
    }

    private fun deleteNote(note: Note, viewModel: MainViewModel) {
        AlertDialog.Builder(context)
            .setTitle("Delete this note?")
            .setMessage("Are you sure that you want to delete this note?")
            .setPositiveButton(
                "Yes"
            ) { _, _ ->
                viewModel.deleteNote(note.noteId)
            }
            .setNegativeButton("No", null).show()
    }

    private fun editNote(noteId: Long) {
        findNavController()
            .navigate(
                MainFragmentDirections.actionMainFragmentToAddEditFragment(
                    noteId
                )
            )
    }

    private fun onShare(note: Note) {
        val shareIntent = ShareCompat.IntentBuilder.from(requireActivity())
            .setText("${note.noteTitle}: ${note.noteText} ")
            .setType("text/plain")
            .intent
        try {
            startActivity(shareIntent)
        } catch (ex: ActivityNotFoundException) {
        }
    }

    override fun onItemClick(note: Note) {
      NoteDialog(note).show(requireFragmentManager(),"Note Dialog")
    }

    override fun onItemLongClick(note: Note,view: View) {
        val popup = PopupMenu(context, view)
        popup.menuInflater
            .inflate(R.menu.popup_menu, popup.menu)
        popup.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.edit_menu -> {
                    editNote(note.noteId)
                    true
                }
                R.id.delete_menu -> {
                    deleteNote(note, viewModel)
                    true
                }
                R.id.share_menu -> {
                    onShare(note)
                    true
                }
                else -> true
            }
        }
        popup.show()
    }
}