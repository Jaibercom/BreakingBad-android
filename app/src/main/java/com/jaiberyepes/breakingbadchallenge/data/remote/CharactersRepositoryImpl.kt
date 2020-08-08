package com.jaiberyepes.breakingbadchallenge.data.remote

import com.jaiberyepes.breakingbadchallenge.domain.repository.CharactersRepository
import com.jaiberyepes.breakingbadchallenge.presentation.model.CharacterUI
import com.jaiberyepes.breakingbadchallenge.util.Output
import timber.log.Timber
import javax.inject.Inject

/**
 * Characters related Repository implementation.
 *
 * @author jaiber.yepes
 */
class CharactersRepositoryImpl @Inject constructor(
    private val dataSource: CharactersRemoteDataSource
) : CharactersRepository {

    override suspend fun getCharacters(): Output<List<CharacterUI>> {
        Timber.d("getCharacters")

//        val charactersRemote = dataSource.getCharacters()

//        if (charactersRemote is Output.Success) {
//            Timber.d("Save Characters to local database")
//            charactersCacheDataSource.insertCharacters(characterListUIToCache.map(charactersRemote.data))
//        }

        return dataSource.getCharacters()
    }
}
