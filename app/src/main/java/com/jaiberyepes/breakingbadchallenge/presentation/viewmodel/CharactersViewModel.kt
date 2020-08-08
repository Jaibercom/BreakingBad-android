package com.jaiberyepes.breakingbadchallenge.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jaiberyepes.breakingbadchallenge.domain.usescases.CharactersUseCases
import com.jaiberyepes.breakingbadchallenge.presentation.model.CharacterUI
import com.jaiberyepes.breakingbadchallenge.util.Output
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

class CharactersViewModel @Inject constructor(
    private val charactersUseCases: CharactersUseCases
) : ViewModel() {

    private var characters: List<CharacterUI> = listOf()

    fun getCharacters() = viewModelScope.launch {
        Timber.d("getCharacters")
//        currentUIStateMutableLiveData.value = UIState.Loading()

        val output = charactersUseCases.getCharacters()
        if (output is Output.Success) {
            characters = output.data
//            currentUIStateMutableLiveData.value = UIState.Data(CharactersData(characters))
        } else {
//            currentUIStateMutableLiveData.value = UIState.Error(R.string.characters_error_message)
        }
    }
}