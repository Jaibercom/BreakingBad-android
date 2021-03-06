package com.jaiberyepes.breakingbadchallenge.data.cache

import com.jaiberyepes.breakingbadchallenge.data.CharactersDataMapper
import com.jaiberyepes.breakingbadchallenge.data.cache.database.dao.CharactersDao
import com.jaiberyepes.breakingbadchallenge.data.cache.database.entities.CharacterEntity
import com.jaiberyepes.breakingbadchallenge.presentation.model.CharacterDetailsUI
import com.jaiberyepes.breakingbadchallenge.presentation.model.CharacterUI
import com.jaiberyepes.breakingbadchallenge.util.Output
import javax.inject.Inject

/**
 * Characters related cache DataSource.
 *
 * @author jaiber.yepes
 */
class CharactersCacheDataSource @Inject constructor(
    private val charactersDao: CharactersDao
) {

    suspend fun insertCharacters(characters: List<CharacterEntity>) =
        charactersDao.insertCharacters(characters)

    suspend fun updateCharacter(character: CharacterDetailsUI) =
        charactersDao.updateCharacter(CharactersDataMapper.CharacterDetailsUIToCache.map(character))

    suspend fun getCharacterId(id: Int): Output<CharacterDetailsUI> =
        Output.success(CharactersDataMapper.CharacterDetailsCacheToUI.map(charactersDao.getCharacterById(id)))

    suspend fun getCharacters(): Output<List<CharacterUI>> =
        Output.success(CharactersDataMapper.CharactersListCacheToUI.map(charactersDao.getCharacters()))

    suspend fun getCharactersWithFavorites(): Output<List<CharacterUI>> =
        Output.success(CharactersDataMapper.CharactersListCacheToUI.map(charactersDao.getCharactersWithFavorites()))

    suspend fun searchCharacters(query: String): Output<List<CharacterUI>> {
        return Output.success(
            CharactersDataMapper.CharactersListCacheToUI.map(
                charactersDao.searchCharacter(
                    query
                )
            )
        )
    }
}
