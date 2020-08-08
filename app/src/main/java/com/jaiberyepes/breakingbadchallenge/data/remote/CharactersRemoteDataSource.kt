package com.jaiberyepes.breakingbadchallenge.data.remote

import com.jaiberyepes.breakingbadchallenge.presentation.model.CharacterUI
import com.jaiberyepes.breakingbadchallenge.util.Output
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 * Characters related remote DataSource.
 *
 * @author jaiber.yepes
 */
class CharactersRemoteDataSource @Inject constructor(
    private val breakingBadApi: BreakingBadApi
) {

    suspend fun getCharacters(): Output<List<CharacterUI>> =
        try {
            val charactersResponse = withContext(Dispatchers.IO) {
                breakingBadApi.getCharacters()
            }

            val characters = CharactersDataMapper.CharactersListRemoteToUI.map(charactersResponse)
            Output.success(characters)
        } catch (e: Throwable) {
            Output.error("Error retrieving the Characters list from remote: ${e.message}")
        }
}