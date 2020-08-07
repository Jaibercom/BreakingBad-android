package com.jaiberyepes.breakingbadchallenge.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.jaiberyepes.breakingbadchallenge.R
import com.jaiberyepes.breakingbadchallenge.presentation.viewmodel.CharactersViewModel
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Activity for the Main Entry-Point.
 *
 * @author jaiber.yepes
 */
class MainActivity : AppCompatActivity(R.layout.activity_main) {

    // ViewModel
    private lateinit var charactersViewModel: CharactersViewModel

    private lateinit var appBarConfiguration: AppBarConfiguration

    // Navigation
    private val charactersNavController: NavController by lazy {
        findNavController(R.id.charactersNavHostFragment)
    }

    private val onDestinationChangedListener = NavController.OnDestinationChangedListener { _, destination, arguments ->
        when (destination.id) {
//            R.id.characterDetailsFragment -> {
//                toolbar.title = getText(R.string.character_details)
//            }
            else -> {
                toolbar.title = getText(R.string.characters)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // ViewModel
        charactersViewModel = ViewModelProvider(this)
                .get(CharactersViewModel::class.java)
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)

        setSupportActionBar(toolbar)

        appBarConfiguration = AppBarConfiguration(setOf(R.id.charactersFragment))
        setupActionBarWithNavController(charactersNavController, appBarConfiguration)
        charactersNavController.addOnDestinationChangedListener(onDestinationChangedListener)
    }

    override fun onSupportNavigateUp(): Boolean {
        return charactersNavController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}