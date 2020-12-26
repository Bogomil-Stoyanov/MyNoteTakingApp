package eu.bbsapps.mynotetakingapp

import android.content.Context
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat

class Util {
    fun colorCardView(noteColor: Int, cardView: CardView, context: Context) {
        when (noteColor) {
            1 -> {
                cardView.setCardBackgroundColor(ContextCompat.getColor(context, R.color.color1))
            }
            2 -> {
                cardView.setCardBackgroundColor(ContextCompat.getColor(context, R.color.color2))
            }
            3 -> {
                cardView.setCardBackgroundColor(ContextCompat.getColor(context, R.color.color3))
            }
            4 -> {
                cardView.setCardBackgroundColor(ContextCompat.getColor(context, R.color.color4))
            }
            5 -> {
                cardView.setCardBackgroundColor(ContextCompat.getColor(context, R.color.color5))
            }
            6 -> {
                cardView.setCardBackgroundColor(ContextCompat.getColor(context, R.color.color6))
            }
            7 -> {
                cardView.setCardBackgroundColor(ContextCompat.getColor(context, R.color.color7))
            }
            8 -> {
                cardView.setCardBackgroundColor(ContextCompat.getColor(context, R.color.color8))
            }
            9 -> {
                cardView.setCardBackgroundColor(ContextCompat.getColor(context, R.color.color9))
            }
            10 -> {
                cardView.setCardBackgroundColor(ContextCompat.getColor(context, R.color.color10))
            }
            11 -> {
                cardView.setCardBackgroundColor(ContextCompat.getColor(context, R.color.color11))
            }
            12 -> {
                cardView.setCardBackgroundColor(ContextCompat.getColor(context, R.color.color12))
            }
            13 -> {
                cardView.setCardBackgroundColor(ContextCompat.getColor(context, R.color.color13))
            }
            14 -> {
                cardView.setCardBackgroundColor(ContextCompat.getColor(context, R.color.color14))
            }
            15 -> {
                cardView.setCardBackgroundColor(ContextCompat.getColor(context, R.color.color15))
            }
            16 -> {
                cardView.setCardBackgroundColor(ContextCompat.getColor(context, R.color.color16))
            }
        }
    }
}
