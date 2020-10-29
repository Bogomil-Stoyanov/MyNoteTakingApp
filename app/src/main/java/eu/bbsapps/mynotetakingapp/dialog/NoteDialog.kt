package eu.bbsapps.mynotetakingapp.dialog

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import eu.bbsapps.mynotetakingapp.R
import eu.bbsapps.mynotetakingapp.db.Note
import kotlinx.android.synthetic.main.note_dialog.*

class NoteDialog(private val note: Note) : DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dialog!!.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        return inflater.inflate(R.layout.note_dialog, container, false)
    }

    override fun onStart() {
        super.onStart()
        val width = (resources.displayMetrics.widthPixels * 0.85).toInt()
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
                dialogCardView.setCardBackgroundColor(activity!!.resources.getColor(R.color.color1))
            }
            2 -> {
                dialogCardView.setCardBackgroundColor(activity!!.resources.getColor(R.color.color2))
            }
            3 -> {
                dialogCardView.setCardBackgroundColor(activity!!.resources.getColor(R.color.color3))
            }
            4 -> {
                dialogCardView.setCardBackgroundColor(activity!!.resources.getColor(R.color.color4))
            }
            5 -> {
                dialogCardView.setCardBackgroundColor(activity!!.resources.getColor(R.color.color5))
            }
            6 -> {
                dialogCardView.setCardBackgroundColor(activity!!.resources.getColor(R.color.color6))
            }
            7 -> {
                dialogCardView.setCardBackgroundColor(activity!!.resources.getColor(R.color.color7))
            }
            8 -> {
                dialogCardView.setCardBackgroundColor(activity!!.resources.getColor(R.color.color8))
            }
            9 -> {
                dialogCardView.setCardBackgroundColor(activity!!.resources.getColor(R.color.color9))
            }
            10 -> {
                dialogCardView.setCardBackgroundColor(activity!!.resources.getColor(R.color.color10))
            }
            11 -> {
                dialogCardView.setCardBackgroundColor(activity!!.resources.getColor(R.color.color11))
            }
            12 -> {
                dialogCardView.setCardBackgroundColor(activity!!.resources.getColor(R.color.color12))
            }
            13 -> {
                dialogCardView.setCardBackgroundColor(activity!!.resources.getColor(R.color.color13))
            }
            14 -> {
                dialogCardView.setCardBackgroundColor(activity!!.resources.getColor(R.color.color14))
            }
            15 -> {
                dialogCardView.setCardBackgroundColor(activity!!.resources.getColor(R.color.color15))
            }
            16 -> {
                dialogCardView.setCardBackgroundColor(activity!!.resources.getColor(R.color.color16))
            }
        }

        dialog!!.window?.setLayout(width, ViewGroup.LayoutParams.WRAP_CONTENT)
    }
}

