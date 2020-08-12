package com.jaiberyepes.breakingbadchallenge.domain.repository

import com.jaiberyepes.breakingbadchallenge.presentation.model.CharacterDetailsUI
import com.jaiberyepes.breakingbadchallenge.presentation.model.CharacterUI
import com.jaiberyepes.breakingbadchallenge.util.Output

/**
 * Repository for Characters handling.
 *
 * @author jaiber.yepes
 */
interface CharactersRepository {

    suspend fun getCharacters(): Output<List<CharacterUI>>

    suspend fun updateCharacter(characterUI: CharacterDetailsUI)

    suspend fun getCharacterDetails(id: Int): Output<CharacterDetailsUI>
}
