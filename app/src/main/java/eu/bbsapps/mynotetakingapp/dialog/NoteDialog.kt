package eu.bbsapps.mynotetakingapp.dialog

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


class NoteDialog(private val note: Note) : DialogFragment() {
    private lateinit var binding: NoteDialogBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = NoteDialogBinding.inflate(LayoutInflater.from(context))
        prepareLayout(binding)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        binding = NoteDialogBinding.inflate(LayoutInflater.from(context))
        prepareLayout(binding)
    }

    private fun prepareLayout(binding: NoteDialogBinding) {
        binding.apply {
            titleDialogTextView.text = note.noteTitle
            textDialogTextView.text = note.noteText
            if (note.noteColor in 12..14) {
                textDialogTextView.setTextColor(getColor(context!!, R.color.black))
                titleDialogTextView.setTextColor(getColor(context!!, R.color.black))
            } else {
                textDialogTextView.setTextColor(getColor(context!!, R.color.white))
                titleDialogTextView.setTextColor(getColor(context!!, R.color.white))
            }
            when (note.noteColor) {
                1 -> {
                    dialogCardView.setCardBackgroundColor(getColor(context!!, R.color.color1))
                }
                2 -> {
                    dialogCardView.setCardBackgroundColor(getColor(context!!, R.color.color2))
                }
                3 -> {
                    dialogCardView.setCardBackgroundColor(getColor(context!!, R.color.color3))
                }
                4 -> {
                    dialogCardView.setCardBackgroundColor(getColor(context!!, R.color.color4))
                }
                5 -> {
                    dialogCardView.setCardBackgroundColor(getColor(context!!, R.color.color5))
                }
                6 -> {
                    dialogCardView.setCardBackgroundColor(getColor(context!!, R.color.color6))
                }
                7 -> {
                    dialogCardView.setCardBackgroundColor(getColor(context!!, R.color.color7))
                }
                8 -> {
                    dialogCardView.setCardBackgroundColor(getColor(context!!, R.color.color8))
                }
                9 -> {
                    dialogCardView.setCardBackgroundColor(getColor(context!!, R.color.color9))
                }
                10 -> {
                    dialogCardView.setCardBackgroundColor(getColor(context!!, R.color.color10))
                }
                11 -> {
                    dialogCardView.setCardBackgroundColor(getColor(context!!, R.color.color11))
                }
                12 -> {
                    dialogCardView.setCardBackgroundColor(getColor(context!!, R.color.color12))
                }
                13 -> {
                    dialogCardView.setCardBackgroundColor(getColor(context!!, R.color.color13))
                }
                14 -> {
                    dialogCardView.setCardBackgroundColor(getColor(context!!, R.color.color14))
                }
                15 -> {
                    dialogCardView.setCardBackgroundColor(getColor(context!!, R.color.color15))
                }
                16 -> {
                    dialogCardView.setCardBackgroundColor(getColor(context!!, R.color.color16))
                }
            }

        }
        val width = (resources.displayMetrics.widthPixels * 0.85).toInt()
        dialog?.window?.setLayout(width, ViewGroup.LayoutParams.WRAP_CONTENT)
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
    }


}



