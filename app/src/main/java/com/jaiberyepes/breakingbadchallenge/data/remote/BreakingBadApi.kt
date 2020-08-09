package com.jaiberyepes.breakingbadchallenge.data.remote

import com.jaiberyepes.breakingbadchallenge.data.remote.model.CharacterDetailResponse
import com.jaiberyepes.breakingbadchallenge.data.remote.model.CharacterResponse
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Interface that provides the Breaking Bad API End-Points.
 *
 * @author jaiber.yepes
 */
interface BreakingBadApi {

    @GET("characters")
    suspend fun getCharacters(): List<CharacterResponse>

    @GET("characters/{id}")
    suspend fun getCharacterDetails(@Path("id") id: Int): List<CharacterDetailResponse>
}
