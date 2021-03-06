package com.jaiberyepes.breakingbadchallenge.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.jaiberyepes.breakingbadchallenge.domain.usescases.CharactersUseCases
import javax.inject.Inject

/**
 * ViewModel provider factory to instantiate [CharactersViewModel].
 * Required given CharactersViewModel has a non-empty constructor.
 *
 * @author jaiber.yepes
 */
class CharactersViewModelFactory @Inject constructor(
        private val charactersUseCases: CharactersUseCases
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CharactersViewModel::class.java)) {
            return CharactersViewModel(charactersUseCases) as T
        }

        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
