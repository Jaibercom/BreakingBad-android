package com.jaiberyepes.breakingbadchallenge.data.remote

import com.jaiberyepes.breakingbadchallenge.data.remote.model.CharacterResponse
import retrofit2.http.GET

/**
 * Interface that provides the Breaking Bad API End-Points.
 *
 * @author juan.villada
 */
interface BreakingBadApi {

    @GET("characters")
    suspend fun getRecipes(): List<CharacterResponse>
}
