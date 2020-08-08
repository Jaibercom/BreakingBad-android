package com.jaiberyepes.breakingbadchallenge.presentation

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.jaiberyepes.breakingbadchallenge.R
import com.jaiberyepes.breakingbadchallenge.presentation.viewmodel.CharactersViewModel
import com.jaiberyepes.breakingbadchallenge.presentation.viewmodel.CharactersViewModelFactory
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class CharactersFragment : Fragment() {
    //ViewModel
    @Inject
    lateinit var charactersViewModelFactory: CharactersViewModelFactory
    private lateinit var charactersViewModel: CharactersViewModel

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // ViewModel
        charactersViewModel = ViewModelProvider(requireActivity(), charactersViewModelFactory).get(CharactersViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.characters_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupCharactersRecyclerView()
        charactersViewModel.getCharacters()
    }

    private fun setupCharactersRecyclerView() {

    }
}
