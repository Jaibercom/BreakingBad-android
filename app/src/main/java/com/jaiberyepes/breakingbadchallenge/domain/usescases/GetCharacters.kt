package com.jaiberyepes.breakingbadchallenge.domain.usescases

import com.jaiberyepes.breakingbadchallenge.domain.repository.CharactersRepository
import com.jaiberyepes.breakingbadchallenge.presentation.model.CharacterUI
import com.jaiberyepes.breakingbadchallenge.util.Output
import javax.inject.Inject


/**
 * UseCase for getting the [CharacterUI] list.
 *
 * @author jaiber.yepes
 */
class GetCharacters @Inject constructor(private val charactersRepository: CharactersRepository) {

    suspend operator fun invoke(): Output<List<CharacterUI>> = charactersRepository.getCharacters()
}
