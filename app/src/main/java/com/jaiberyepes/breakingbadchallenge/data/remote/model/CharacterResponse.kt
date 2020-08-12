package com.jaiberyepes.breakingbadchallenge.data.remote.model

import com.squareup.moshi.Json

/**
 * Data class for Characters data entity (network DTO).
 *
 * @author jaiber.yepes
 */
class CharacterResponse(

    @field:Json(name = "char_id") val id: Int,
    @field:Json(name = "name") val name: String,
//    @field:Json(name = "birthday") val birthday: String,
    @field:Json(name = "occupation") val occupation: List<String>,
    @field:Json(name = "img") val image: String,
    @field:Json(name = "status") val status: String,
    @field:Json(name = "nickname") val nickName: String,
//    @field:Json(name = "appearance") val appearance: List<Int>,
    @field:Json(name = "portrayed") val portrayed: String
//    @field:Json(name = "category") val category: String,
//    @field:Json(name = "better_call_saul_appearance") val better_call_saul_appearance: List<String>
)