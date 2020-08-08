package com.jaiberyepes.breakingbadchallenge.presentation

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.ViewStub
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.jaiberyepes.breakingbadchallenge.R
import com.jaiberyepes.breakingbadchallenge.presentation.adapter.CharacterDetailsController
import com.jaiberyepes.breakingbadchallenge.presentation.model.CharacterDetailsUI
import com.jaiberyepes.breakingbadchallenge.presentation.viewmodel.CharactersViewModel
import com.jaiberyepes.breakingbadchallenge.presentation.viewmodel.CharactersViewModel.CharactersDataType.CharacterDetailsData
import com.jaiberyepes.breakingbadchallenge.presentation.viewmodel.CharactersViewModelFactory
import com.jaiberyepes.breakingbadchallenge.util.base.UIState
import com.jaiberyepes.breakingbadchallenge.util.extensions.gone
import com.jaiberyepes.breakingbadchallenge.util.extensions.observe
import com.jaiberyepes.breakingbadchallenge.util.extensions.visible
import dagger.android.support.AndroidSupportInjection
import timber.log.Timber
import javax.inject.Inject

/**
 * Fragment for the Character Details view.
 *
 * @author jaiber.yepes
 */
class CharacterDetailsFragment : Fragment(R.layout.fragment_character_details) {

    // ViewModel
    @Inject
    lateinit var charactersViewModelFactory: CharactersViewModelFactory
    private lateinit var charactersViewModel: CharactersViewModel

    // Navigation
    private val args: CharacterDetailsFragmentArgs by navArgs()
    private val character by lazy {
        args.character
    }

    // Epoxy controller
    private val characterDetailsController: CharacterDetailsController by lazy {
        CharacterDetailsController()
    }

    // Loading
    private lateinit var loadingViewStub: ViewStub
    private var loadingInflated: View? = null

    // ErrorBanner
//    private lateinit var errorBanner: ErrorBanner

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // ViewModel
        charactersViewModel = ViewModelProvider(requireActivity(), charactersViewModelFactory)
            .get(CharactersViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loadingViewStub = view.findViewById(R.id.characterDetailsLoadingViewStub)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

//        setupCharacterDetailsRecyclerView()
        observe(charactersViewModel.currentUIStateLiveData, ::onUIStateChange)
        charactersViewModel.getCharacterDetails(character.id)
    }

//    private fun setupCharacterDetailsRecyclerView() = characterDetailsEpoxyRecyclerView.apply {
//        Timber.d("setupCharacterDetailsRecyclerView")
//        layoutManager = LinearLayoutManager(context)
//        setController(characterDetailsController)
//    }

    private fun onUIStateChange(uiState: UIState<CharactersViewModel.CharactersDataType>) =
        when (uiState) {
            is UIState.Loading -> showLoading()
            is UIState.Data -> showData(uiState.data)
            is UIState.Error -> showError(uiState.message)
        }

    private fun showLoading() {
        Timber.d("showLoading")
        if (loadingInflated == null) {
            loadingInflated = loadingViewStub.inflate()
        }

        loadingInflated?.visible()
    }

    private fun showData(charactersDataType: CharactersViewModel.CharactersDataType) {
        Timber.d("showData")

        loadingInflated?.gone()
        when (charactersDataType) {
            is CharacterDetailsData -> showCharacterDetails(charactersDataType.charactersDetails)
        }
    }

    private fun showCharacterDetails(character: CharacterDetailsUI) {
        Timber.d("showCharacterDetailsList")
        characterDetailsController.setData(character)
    }

    private fun showError(@StringRes messageResId: Int) {
        Timber.d("showErrorBanner")

        loadingInflated?.gone()
//        view?.let {
//            errorBanner = ErrorBanner.make(
//                it,
//                R.string.general_error_title,
//                messageResId,
//                withRetry = true,
//                withDismiss = false,
//                errorBannerListener = this
//            )
//            errorBanner.show()
//        }
    }

//    override fun onErrorBannerDismiss() {
//        Timber.d("onErrorBannerDismiss")
//        errorBanner.dismiss()
//    }
//
//    override fun onErrorBannerRetry() {
//        Timber.d("onErrorBannerRetry")
//        errorBanner.dismiss()
//        charactersViewModel.getCharacters()
//    }
}
