package eu.bbsapps.mynotetakingapp.ui.addEditFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import eu.bbsapps.mynotetakingapp.R
import eu.bbsapps.mynotetakingapp.databinding.FragmentAddEditBinding
import eu.bbsapps.mynotetakingapp.db.Note
import eu.bbsapps.mynotetakingapp.db.NotesDatabase
import eu.bbsapps.mynotetakingapp.viewmodels.AddEditViewModel
import eu.bbsapps.mynotetakingapp.viewmodels.AddEditViewModelFactory


class AddEditFragment : Fragment() {

    var noteColorSelected: Int = -1
    var noteTitle: String = ""
    var noteText: String = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentAddEditBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_add_edit, container, false
        )

        val arguments = AddEditFragmentArgs.fromBundle(arguments!!)
        val id = arguments.noteId
        println("id is $id")
        val application = requireNotNull(this.activity).application
        val dataSource = NotesDatabase.getInstance(application).notesDatabaseDao
        val viewModelFactory = AddEditViewModelFactory(dataSource, id)
        val viewModel =
            ViewModelProviders.of(this, viewModelFactory).get(AddEditViewModel::class.java)

        if (id != -1L) {
            viewModel.noteData.observe(viewLifecycleOwner) {
                binding.titleEditText.setText(it?.noteTitle)
                binding.textEditText.setText(it?.noteText)
                noteColorSelected = it?.noteColor ?: 0
                when (it?.noteColor) {
                    1 -> {
                        binding.notesColorImageView.setBackgroundColor(resources.getColor(R.color.color1))
                    }
                    2 -> {
                        binding.notesColorImageView.setBackgroundColor(resources.getColor(R.color.color2))
                    }
                    3 -> {
                        binding.notesColorImageView.setBackgroundColor(resources.getColor(R.color.color3))
                    }
                    4 -> {
                        binding.notesColorImageView.setBackgroundColor(resources.getColor(R.color.color4))
                    }
                    5 -> {
                        binding.notesColorImageView.setBackgroundColor(resources.getColor(R.color.color5))
                    }
                    6 -> {
                        binding.notesColorImageView.setBackgroundColor(resources.getColor(R.color.color6))
                    }
                    7 -> {
                        binding.notesColorImageView.setBackgroundColor(resources.getColor(R.color.color7))
                    }
                    8 -> {
                        binding.notesColorImageView.setBackgroundColor(resources.getColor(R.color.color8))
                    }
                    9 -> {
                        binding.notesColorImageView.setBackgroundColor(resources.getColor(R.color.color9))
                    }
                    10 -> {
                        binding.notesColorImageView.setBackgroundColor(resources.getColor(R.color.color10))
                    }
                    11 -> {
                        binding.notesColorImageView.setBackgroundColor(resources.getColor(R.color.color11))
                    }
                    12 -> {
                        binding.notesColorImageView.setBackgroundColor(resources.getColor(R.color.color12))
                    }
                    13 -> {
                        binding.notesColorImageView.setBackgroundColor(resources.getColor(R.color.color13))
                    }
                    14 -> {
                        binding.notesColorImageView.setBackgroundColor(resources.getColor(R.color.color14))
                    }
                    15 -> {
                        binding.notesColorImageView.setBackgroundColor(resources.getColor(R.color.color15))
                    }
                }
            }
        }

        binding.floatingActionButton.setOnClickListener {
            if (noteColorSelected != -1) {
                noteTitle = binding.titleEditText.text.toString()
                noteText = binding.textEditText.text.toString()

                if (id == -1L) {
                    viewModel.insertNote(
                        Note(
                            noteTitle = noteTitle,
                            noteText = noteText,
                            noteColor = noteColorSelected
                        )
                    )
                    println("save")
                } else {
                    viewModel.updateNote(
                        Note(
                            noteId = id,
                            noteTitle = noteTitle,
                            noteText = noteText,
                            noteColor = noteColorSelected
                        )
                    )
                    println("update")
                }



                this.findNavController()
                    .navigate(AddEditFragmentDirections.actionAddEditFragmentToMainFragment())
            }
        }

        setUpColorButtons(binding)

        return binding.root
    }

    private fun setUpColorButtons(binding: FragmentAddEditBinding) {
        var color: Int = R.color.color1
        val onClickListener = View.OnClickListener {
            when (it.id) {
                R.id.color1ImageView -> {
                    color = R.color.color1
                    noteColorSelected = 1
                }
                R.id.color2ImageView -> {
                    color = R.color.color2
                    noteColorSelected = 2
                }
                R.id.color3ImageView -> {
                    color = R.color.color3
                    noteColorSelected = 3
                }
                R.id.color4ImageView -> {
                    color = R.color.color4
                    noteColorSelected = 4
                }
                R.id.color5ImageView -> {
                    color = R.color.color5
                    noteColorSelected = 5
                }
                R.id.color6ImageView -> {
                    color = R.color.color6
                    noteColorSelected = 6
                }
                R.id.color7ImageView -> {
                    color = R.color.color7
                    noteColorSelected = 7
                }
                R.id.color8ImageView -> {
                    color = R.color.color8
                    noteColorSelected = 8
                }
                R.id.color9ImageView -> {
                    color = R.color.color9
                    noteColorSelected = 9
                }
                R.id.color10ImageView -> {
                    color = R.color.color10
                    noteColorSelected = 10
                }
                R.id.color11ImageView -> {
                    color = R.color.color11
                    noteColorSelected = 11
                }
                R.id.color12ImageView -> {
                    color = R.color.color12
                    noteColorSelected = 12
                }
                R.id.color13ImageView -> {
                    color = R.color.color13
                    noteColorSelected = 13
                }
                R.id.color14ImageView -> {
                    color = R.color.color14
                    noteColorSelected = 14
                }
                R.id.color15ImageView -> {
                    color = R.color.color15
                    noteColorSelected = 15
                }
                R.id.color16ImageView -> {
                    color = R.color.color16
                    noteColorSelected = 16
                }
            }
            binding.notesColorImageView.setBackgroundColor(resources.getColor(color))
        }


        binding.color1ImageView.setOnClickListener(onClickListener)
        binding.color2ImageView.setOnClickListener(onClickListener)
        binding.color3ImageView.setOnClickListener(onClickListener)
        binding.color4ImageView.setOnClickListener(onClickListener)
        binding.color5ImageView.setOnClickListener(onClickListener)
        binding.color6ImageView.setOnClickListener(onClickListener)
        binding.color7ImageView.setOnClickListener(onClickListener)
        binding.color8ImageView.setOnClickListener(onClickListener)
        binding.color9ImageView.setOnClickListener(onClickListener)
        binding.color10ImageView.setOnClickListener(onClickListener)
        binding.color11ImageView.setOnClickListener(onClickListener)
        binding.color12ImageView.setOnClickListener(onClickListener)
        binding.color13ImageView.setOnClickListener(onClickListener)
        binding.color14ImageView.setOnClickListener(onClickListener)
        binding.color15ImageView.setOnClickListener(onClickListener)
        binding.color16ImageView.setOnClickListener(onClickListener)
    }
}