package com.jaiberyepes.breakingbadchallenge.data.remote

import com.jaiberyepes.breakingbadchallenge.data.remote.model.CharacterDetailResponse
import com.jaiberyepes.breakingbadchallenge.data.remote.model.CharacterResponse
import com.jaiberyepes.breakingbadchallenge.presentation.model.CharacterDetailsUI
import com.jaiberyepes.breakingbadchallenge.presentation.model.CharacterUI
import com.jaiberyepes.breakingbadchallenge.util.BaseMapper

/**
 * Auth Mapper for mapping between data & presentation layers.
 *
 * @author jaiber.yepes
 */
object CharactersDataMapper {

    object CharactersListRemoteToUI : BaseMapper<List<CharacterResponse>, List<CharacterUI>> {

        override fun map(type: List<CharacterResponse>): List<CharacterUI> {
            return type.map {
                CharacterUI(
                    id = it.char_id,
                    name = it.name,
                    nickName = it.nickname,
                    image = it.image
                )
            }
        }

    }

    object CharacterDetailsListRemoteToUI :
        BaseMapper<List<CharacterDetailResponse>, CharacterDetailsUI> {

        override fun map(type: List<CharacterDetailResponse>): CharacterDetailsUI {
            return with(type[0]) {
                CharacterDetailsUI(
                    id = char_id,
                    name = name,
                    image = photo,
                    nickName = nickname,
                    occupation = occupation,
                    status = status,
                    portrayed = portrayed
                )
            }
        }

    }
}
