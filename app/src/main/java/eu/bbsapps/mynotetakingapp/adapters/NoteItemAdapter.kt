package eu.bbsapps.mynotetakingapp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.getColor
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import eu.bbsapps.mynotetakingapp.R
import eu.bbsapps.mynotetakingapp.Util
import eu.bbsapps.mynotetakingapp.databinding.NoteLayoutBinding
import eu.bbsapps.mynotetakingapp.db.Note

class NoteItemAdapter(private val listener: OnItemClickListener) :
    ListAdapter<Note, NoteItemAdapter.NoteViewHolder>(DiffCallback()) {

    inner class NoteViewHolder(private val binding: NoteLayoutBinding, private val context:Context) :
        RecyclerView.ViewHolder(binding.root) {
        init {
            binding.apply {
                root.setOnClickListener {
                    val position = adapterPosition
                    if (position != RecyclerView.NO_POSITION) {
                        val note = getItem(position)
                        listener.onItemClick(note)
                    }
                }

                root.setOnLongClickListener {
                    val position = adapterPosition
                    if (position != RecyclerView.NO_POSITION) {
                        val note = getItem(position)
                        listener.onItemLongClick(note,it)
                    }
                    true
                }
            }
        }

        fun bind(note: Note) {
            binding.apply {
                noteTitleItem.text = note.noteTitle
                noteTextItem.text = note.noteText
                Util().colorCardView(note.noteColor,cardView,context)

                if (note.noteColor in 12..14) {
                    noteTextItem.setTextColor(getColor(context,R.color.black))
                    noteTitleItem.setTextColor(getColor(context,R.color.black))
                } else {
                    noteTextItem.setTextColor(getColor(context,R.color.white))
                    noteTitleItem.setTextColor(getColor(context,R.color.white))
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val binding =
            NoteLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NoteViewHolder(binding,parent.context)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    interface OnItemClickListener {
        fun onItemClick(note: Note)
        fun onItemLongClick(note: Note, view: View)
    }

    class DiffCallback : DiffUtil.ItemCallback<Note>() {
        override fun areItemsTheSame(oldItem: Note, newItem: Note) =
            oldItem.noteId == newItem.noteId

        override fun areContentsTheSame(oldItem: Note, newItem: Note) = oldItem == newItem
    }
}
