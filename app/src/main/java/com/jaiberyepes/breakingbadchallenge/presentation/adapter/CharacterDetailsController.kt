package com.jaiberyepes.breakingbadchallenge.presentation.adapter

import com.airbnb.epoxy.TypedEpoxyController
import com.jaiberyepes.breakingbadchallenge.presentation.model.CharacterDetailsUI
import com.jaiberyepes.breakingbadchallenge.presentation.model.characterDetails

/**
 * Epoxy Controller Class for the Recipe Details.
 *
 * @author jaiber.yepes
 */
class CharacterDetailsController() : TypedEpoxyController<CharacterDetailsUI>() {

    override fun buildModels(characterDetailsUI: CharacterDetailsUI) {
        characterDetails {
            id(characterDetailsUI.id)
            characterDetailsUI(characterDetailsUI)
        }
    }
}
