package com.jaiberyepes.breakingbadchallenge.data.remote

import com.jaiberyepes.breakingbadchallenge.data.remote.model.CharacterResponse
import com.jaiberyepes.breakingbadchallenge.presentation.model.CharacterUI
import com.jaiberyepes.breakingbadchallenge.util.BaseMapper

/**
 * Auth Mapper for mapping between data & presentation layers.
 *
 * @author jaiber.yepes
 */
object CharactersDataMapper {

    object CharactersListRemoteToUI :
        BaseMapper<List<CharacterResponse>, List<CharacterUI>> {
        override fun map(type: List<CharacterResponse>): List<CharacterUI> {
            return type.map {
                CharacterUI(
                    id = it.char_id,
                    name = it.name,
                    nickName = it.nickname
                )
            }
        }
    }
}
