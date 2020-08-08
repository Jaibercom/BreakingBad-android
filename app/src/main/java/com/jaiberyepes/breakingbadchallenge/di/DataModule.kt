package com.jaiberyepes.breakingbadchallenge.di

import com.jaiberyepes.breakingbadchallenge.data.remote.CharactersRepositoryImpl
import com.jaiberyepes.breakingbadchallenge.domain.repository.CharactersRepository
import dagger.Binds
import dagger.Module

/**
 * [Module] to provide data level dependencies.
 *
 * @author jaiber.yepes
 */
@Module(
    includes = [
        NetworkModule::class
//        CacheModule::class
    ]
)
abstract class DataModule {

    @Binds
    internal abstract fun providesCharactersRepository(
        charactersRepository: CharactersRepositoryImpl
    ): CharactersRepository
}
