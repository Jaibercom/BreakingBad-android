package com.jaiberyepes.breakingbadchallenge.domain.usescases

import com.jaiberyepes.breakingbadchallenge.data.cache.database.entities.CharacterEntity
import com.jaiberyepes.breakingbadchallenge.domain.repository.CharactersRepository
import com.jaiberyepes.breakingbadchallenge.presentation.model.CharacterDetailsUI
import com.jaiberyepes.breakingbadchallenge.presentation.model.CharacterUI
import com.jaiberyepes.breakingbadchallenge.util.Output
import javax.inject.Inject


/**
 * UseCase for updating the [CharacterUI].
 *
 * @author jaiber.yepes
 */
class UpdateCharacter @Inject constructor(private val charactersRepository: CharactersRepository) {

    suspend operator fun invoke(characterUI: CharacterDetailsUI)= charactersRepository.updateCharacter(characterUI)
}
