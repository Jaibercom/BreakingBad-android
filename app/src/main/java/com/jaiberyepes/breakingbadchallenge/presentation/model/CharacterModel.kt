package com.jaiberyepes.breakingbadchallenge.presentation.model

import android.view.View
import android.widget.TextView
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.jaiberyepes.breakingbadchallenge.R
import com.jaiberyepes.breakingbadchallenge.presentation.adapter.CharactersController

/**
 * EpoxyModelClass for the Character list.
 *
 * @author jaiber.yepes
 */
@EpoxyModelClass(layout = R.layout.item_character)
abstract class CharacterModel : EpoxyModelWithHolder<CharacterModel.CharactersHolder>() {

    @EpoxyAttribute
    lateinit var characterUI: CharacterUI
    @EpoxyAttribute
    lateinit var characterClickedListener: CharactersController.CharacterClickedListener

    override fun bind(holder: CharactersHolder) = with(holder) {
        titleTextView.text = characterUI.name

        container.setOnClickListener {
            characterClickedListener.onCharacterClicked(characterUI)
        }
    }

    inner class CharactersHolder : EpoxyHolder() {

        lateinit var titleTextView: TextView
        lateinit var container: View

        override fun bindView(itemView: View) {
            titleTextView = itemView.findViewById(R.id.titleTextView)
            container = itemView
        }
    }
}
