package eu.bbsapps.mynotetakingapp.dialog

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.getColor
import androidx.fragment.app.DialogFragment
import eu.bbsapps.mynotetakingapp.R
import eu.bbsapps.mynotetakingapp.databinding.NoteDialogBinding
import eu.bbsapps.mynotetakingapp.db.Note


class NoteDialog(private val note: Note, private val contextDialog: Context) : DialogFragment() {
    private lateinit var binding: NoteDialogBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dialog!!.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        binding = NoteDialogBinding
            .inflate(LayoutInflater.from(context))
        // val builder: AlertDialog.Builder = AlertDialog.Builder(context!!)

        val width = (resources.displayMetrics.widthPixels * 0.85).toInt()
        binding.apply {
            titleDialogTextView.text = note.noteTitle
            textDialogTextView.text = note.noteText

            if (note.noteColor in 12..14) {
                textDialogTextView.setTextColor(resources.getColor(R.color.black))
                titleDialogTextView.setTextColor(resources.getColor(R.color.black))
            } else {
                textDialogTextView.setTextColor(resources.getColor(R.color.white))
                titleDialogTextView.setTextColor(resources.getColor(R.color.white))
            }

            when (note.noteColor) {
                1 -> {
                    dialogCardView.setCardBackgroundColor(getColor(contextDialog, R.color.color1))
                }
                2 -> {
                    dialogCardView.setCardBackgroundColor(getColor(contextDialog, R.color.color2))
                }
                3 -> {
                    dialogCardView.setCardBackgroundColor(getColor(contextDialog, R.color.color3))
                }
                4 -> {
                    dialogCardView.setCardBackgroundColor(getColor(contextDialog, R.color.color4))
                }
                5 -> {
                    dialogCardView.setCardBackgroundColor(getColor(contextDialog, R.color.color5))
                }
                6 -> {
                    dialogCardView.setCardBackgroundColor(getColor(contextDialog, R.color.color6))
                }
                7 -> {
                    dialogCardView.setCardBackgroundColor(getColor(contextDialog, R.color.color7))
                }
                8 -> {
                    dialogCardView.setCardBackgroundColor(getColor(contextDialog, R.color.color8))
                }
                9 -> {
                    dialogCardView.setCardBackgroundColor(getColor(contextDialog, R.color.color9))
                }
                10 -> {
                    dialogCardView.setCardBackgroundColor(getColor(contextDialog, R.color.color10))
                }
                11 -> {
                    dialogCardView.setCardBackgroundColor(getColor(contextDialog, R.color.color11))
                }
                12 -> {
                    dialogCardView.setCardBackgroundColor(getColor(contextDialog, R.color.color12))
                }
                13 -> {
                    dialogCardView.setCardBackgroundColor(getColor(contextDialog, R.color.color13))
                }
                14 -> {
                    dialogCardView.setCardBackgroundColor(getColor(contextDialog, R.color.color14))
                }
                15 -> {
                    dialogCardView.setCardBackgroundColor(getColor(contextDialog, R.color.color15))
                }
                16 -> {
                    dialogCardView.setCardBackgroundColor(getColor(contextDialog, R.color.color16))
                }
            }

        }
        dialog!!.window?.setLayout(width, ViewGroup.LayoutParams.WRAP_CONTENT)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        binding = NoteDialogBinding
            .inflate(LayoutInflater.from(context))
        // val builder: AlertDialog.Builder = AlertDialog.Builder(context!!)

        val width = (resources.displayMetrics.widthPixels * 0.85).toInt()
        binding.apply {
            titleDialogTextView.text = note.noteTitle
            textDialogTextView.text = note.noteText

            if (note.noteColor in 12..14) {
                textDialogTextView.setTextColor(resources.getColor(R.color.black))
                titleDialogTextView.setTextColor(resources.getColor(R.color.black))
            } else {
                textDialogTextView.setTextColor(resources.getColor(R.color.white))
                titleDialogTextView.setTextColor(resources.getColor(R.color.white))
            }

            when (note.noteColor) {
                1 -> {
                    dialogCardView.setCardBackgroundColor(getColor(contextDialog, R.color.color1))
                }
                2 -> {
                    dialogCardView.setCardBackgroundColor(getColor(contextDialog, R.color.color2))
                }
                3 -> {
                    dialogCardView.setCardBackgroundColor(getColor(contextDialog, R.color.color3))
                }
                4 -> {
                    dialogCardView.setCardBackgroundColor(getColor(contextDialog, R.color.color4))
                }
                5 -> {
                    dialogCardView.setCardBackgroundColor(getColor(contextDialog, R.color.color5))
                }
                6 -> {
                    dialogCardView.setCardBackgroundColor(getColor(contextDialog, R.color.color6))
                }
                7 -> {
                    dialogCardView.setCardBackgroundColor(getColor(contextDialog, R.color.color7))
                }
                8 -> {
                    dialogCardView.setCardBackgroundColor(getColor(contextDialog, R.color.color8))
                }
                9 -> {
                    dialogCardView.setCardBackgroundColor(getColor(contextDialog, R.color.color9))
                }
                10 -> {
                    dialogCardView.setCardBackgroundColor(getColor(contextDialog, R.color.color10))
                }
                11 -> {
                    dialogCardView.setCardBackgroundColor(getColor(contextDialog, R.color.color11))
                }
                12 -> {
                    dialogCardView.setCardBackgroundColor(getColor(contextDialog, R.color.color12))
                }
                13 -> {
                    dialogCardView.setCardBackgroundColor(getColor(contextDialog, R.color.color13))
                }
                14 -> {
                    dialogCardView.setCardBackgroundColor(getColor(contextDialog, R.color.color14))
                }
                15 -> {
                    dialogCardView.setCardBackgroundColor(getColor(contextDialog, R.color.color15))
                }
                16 -> {
                    dialogCardView.setCardBackgroundColor(getColor(contextDialog, R.color.color16))
                }
            }

        }
        dialog!!.window?.setLayout(width, ViewGroup.LayoutParams.WRAP_CONTENT)
//        val window = builder.create().window
//        window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
//        window?.setLayout(width, ViewGroup.LayoutParams.WRAP_CONTENT)
//        window?.setGravity(Gravity.CENTER)
//        builder.setView(binding.root)
    }


    /* override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
         binding = NoteDialogBinding
             .inflate(LayoutInflater.from(context))
         val builder: AlertDialog.Builder = AlertDialog.Builder(context!!)

         val width = (resources.displayMetrics.widthPixels * 0.85).toInt()
         binding.apply {
             titleDialogTextView.text = note.noteTitle
             textDialogTextView.text = note.noteText

             if (note.noteColor in 12..14) {
                 textDialogTextView.setTextColor(resources.getColor(R.color.black))
                 titleDialogTextView.setTextColor(resources.getColor(R.color.black))
             } else {
                 textDialogTextView.setTextColor(resources.getColor(R.color.white))
                 titleDialogTextView.setTextColor(resources.getColor(R.color.white))
             }

             when (note.noteColor) {
                 1 -> {
                     dialogCardView.setCardBackgroundColor(getColor(contextDialog, R.color.color1))
                 }
                 2 -> {
                     dialogCardView.setCardBackgroundColor(getColor(contextDialog, R.color.color2))
                 }
                 3 -> {
                     dialogCardView.setCardBackgroundColor(getColor(contextDialog, R.color.color3))
                 }
                 4 -> {
                     dialogCardView.setCardBackgroundColor(getColor(contextDialog, R.color.color4))
                 }
                 5 -> {
                     dialogCardView.setCardBackgroundColor(getColor(contextDialog, R.color.color5))
                 }
                 6 -> {
                     dialogCardView.setCardBackgroundColor(getColor(contextDialog, R.color.color6))
                 }
                 7 -> {
                     dialogCardView.setCardBackgroundColor(getColor(contextDialog, R.color.color7))
                 }
                 8 -> {
                     dialogCardView.setCardBackgroundColor(getColor(contextDialog, R.color.color8))
                 }
                 9 -> {
                     dialogCardView.setCardBackgroundColor(getColor(contextDialog, R.color.color9))
                 }
                 10 -> {
                     dialogCardView.setCardBackgroundColor(getColor(contextDialog, R.color.color10))
                 }
                 11 -> {
                     dialogCardView.setCardBackgroundColor(getColor(contextDialog, R.color.color11))
                 }
                 12 -> {
                     dialogCardView.setCardBackgroundColor(getColor(contextDialog, R.color.color12))
                 }
                 13 -> {
                     dialogCardView.setCardBackgroundColor(getColor(contextDialog, R.color.color13))
                 }
                 14 -> {
                     dialogCardView.setCardBackgroundColor(getColor(contextDialog, R.color.color14))
                 }
                 15 -> {
                     dialogCardView.setCardBackgroundColor(getColor(contextDialog, R.color.color15))
                 }
                 16 -> {
                     dialogCardView.setCardBackgroundColor(getColor(contextDialog, R.color.color16))
                 }
             }

         }
        val window = builder.create().window
         window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
 //        window?.setLayout(width, ViewGroup.LayoutParams.WRAP_CONTENT)
 //        window?.setGravity(Gravity.CENTER)
         builder.setView(binding.root)
         return builder.create()
     }*/
}



