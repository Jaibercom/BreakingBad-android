package com.jaiberyepes.breakingbadchallenge.di

import com.jaiberyepes.breakingbadchallenge.presentation.CharacterDetailsFragment
import com.jaiberyepes.breakingbadchallenge.presentation.CharactersFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * [Module] to provide Fragments dependencies.
 *
 * @author jaiber.yepes
 */
@Module
abstract class FragmentModule {

    @ContributesAndroidInjector
    abstract fun bindCharactersFragment(): CharactersFragment

    @ContributesAndroidInjector
    abstract fun bindCharacterDetailsFragment(): CharacterDetailsFragment
}
