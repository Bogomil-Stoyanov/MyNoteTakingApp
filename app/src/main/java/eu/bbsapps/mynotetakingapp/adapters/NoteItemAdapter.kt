package eu.bbsapps.mynotetakingapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import eu.bbsapps.mynotetakingapp.R
import eu.bbsapps.mynotetakingapp.db.Note
import kotlinx.android.synthetic.main.note_layout.view.*

class NoteItemAdapter : RecyclerView.Adapter<NoteItemAdapter.NoteViewHolder>() {

    class NoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    private val diffCallback = object : DiffUtil.ItemCallback<Note>() {
        override fun areItemsTheSame(oldItem: Note, newItem: Note): Boolean {
            return (oldItem.noteTitle == newItem.noteTitle
                    && oldItem.noteText == newItem.noteText
                    && oldItem.noteColor == newItem.noteColor)
        }

        override fun areContentsTheSame(oldItem: Note, newItem: Note): Boolean {
            return oldItem.hashCode() == newItem.hashCode()
        }
    }

    private val differ = AsyncListDiffer(this, diffCallback)
    var notes: List<Note>
        get() = differ.currentList
        set(value) = differ.submitList(value)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        return NoteViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.note_layout, parent, false)
        )
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val note = notes[position]
        holder.itemView.apply {
            noteTitleItem.text = note.noteTitle
            noteTextItem.text = note.noteText
            when (note.noteColor) {
                1 -> {
                    cardView.setCardBackgroundColor(resources.getColor(R.color.color1))
                }
                2 -> {
                    cardView.setCardBackgroundColor(resources.getColor(R.color.color2))
                }
                3 -> {
                    cardView.setCardBackgroundColor(resources.getColor(R.color.color3))
                }
                4 -> {
                    cardView.setCardBackgroundColor(resources.getColor(R.color.color4))
                }
                5 -> {
                    cardView.setCardBackgroundColor(resources.getColor(R.color.color5))
                }
                6 -> {
                    cardView.setCardBackgroundColor(resources.getColor(R.color.color6))
                }
                7 -> {
                    cardView.setCardBackgroundColor(resources.getColor(R.color.color7))
                }
                8 -> {
                    cardView.setCardBackgroundColor(resources.getColor(R.color.color8))
                }
                9 -> {
                    cardView.setCardBackgroundColor(resources.getColor(R.color.color9))
                }
                10 -> {
                    cardView.setCardBackgroundColor(resources.getColor(R.color.color10))
                }
                11 -> {
                    cardView.setCardBackgroundColor(resources.getColor(R.color.color11))
                }
                12 -> {
                    cardView.setCardBackgroundColor(resources.getColor(R.color.color12))
                }
                13 -> {
                    cardView.setCardBackgroundColor(resources.getColor(R.color.color13))
                }
                14 -> {
                    cardView.setCardBackgroundColor(resources.getColor(R.color.color14))
                }
                15 -> {
                    cardView.setCardBackgroundColor(resources.getColor(R.color.color15))
                }
                16 -> {
                    cardView.setCardBackgroundColor(resources.getColor(R.color.color16))
                }
            }

            if (note.noteColor in 12..14) {
                noteTextItem.setTextColor(resources.getColor(R.color.black))
                noteTitleItem.setTextColor(resources.getColor(R.color.black))
            } else {
                noteTextItem.setTextColor(resources.getColor(R.color.white))
                noteTitleItem.setTextColor(resources.getColor(R.color.white))
            }


            setOnClickListener {
                onItemClickListener?.let { click ->
                    click(note)
                }
            }

            setOnLongClickListener {
                onItemLongClickListener?.let { click ->
                    click(note,it)
                }
                true
            }

        }
    }

    override fun getItemCount(): Int {
        return notes.size
    }

    private var onItemClickListener: ((Note) -> Unit?)? = null

    private var onItemLongClickListener: ((Note,View) -> Unit?)? = null


    fun setOnItemClickListener(listener: (Note) -> Unit) {
        onItemClickListener = listener
    }

    fun setOnItemLongClickListener(listener: (Note,View) -> Unit) {
        onItemLongClickListener = listener
    }
}