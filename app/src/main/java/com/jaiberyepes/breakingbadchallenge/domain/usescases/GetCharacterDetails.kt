package com.jaiberyepes.breakingbadchallenge.domain.usescases

import com.jaiberyepes.breakingbadchallenge.domain.repository.CharactersRepository
import com.jaiberyepes.breakingbadchallenge.presentation.model.CharacterDetailsUI
import com.jaiberyepes.breakingbadchallenge.presentation.model.CharacterUI
import com.jaiberyepes.breakingbadchallenge.util.Output
import javax.inject.Inject


/**
 * UseCase for getting the [CharacterUI] list.
 *
 * @author jaiber.yepes
 */
class GetCharacterDetails @Inject constructor(private val charactersRepository: CharactersRepository) {

    suspend operator fun invoke(id: Int): Output<CharacterDetailsUI> = charactersRepository.getCharacterDetails(id)
}
