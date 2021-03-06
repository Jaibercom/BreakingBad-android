package com.jaiberyepes.breakingbadchallenge.data

import com.jaiberyepes.breakingbadchallenge.data.cache.CharactersCacheDataSource
import com.jaiberyepes.breakingbadchallenge.data.remote.CharactersRemoteDataSource
import com.jaiberyepes.breakingbadchallenge.domain.repository.CharactersRepository
import com.jaiberyepes.breakingbadchallenge.presentation.model.CharacterDetailsUI
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
    private val remoteDataSource: CharactersRemoteDataSource,
    private val cacheDataSource: CharactersCacheDataSource
) : CharactersRepository {

    override suspend fun getCharacters(): Output<List<CharacterUI>> {
        Timber.d("getCharacters")

        val charactersCache = cacheDataSource.getCharactersWithFavorites()
        if (charactersCache is Output.Success) {
            Timber.d("get Characters from local database")
            if (charactersCache.data.isNotEmpty()){
                return charactersCache
            }
        }

        val charactersRemote = remoteDataSource.getCharacters()
        if (charactersRemote is Output.Success) {
            Timber.d("Save Characters to local database")
            cacheDataSource.insertCharacters(CharactersDataMapper.CharactersResponseToCache.map(charactersRemote.data))
        }

        return cacheDataSource.getCharactersWithFavorites()
    }

    override suspend fun updateCharacter(characterUI: CharacterDetailsUI) {
        return cacheDataSource.updateCharacter(characterUI)
    }

    override suspend fun getCharacterDetails(id: Int): Output<CharacterDetailsUI> {
        return cacheDataSource.getCharacterId(id)
    }
}
