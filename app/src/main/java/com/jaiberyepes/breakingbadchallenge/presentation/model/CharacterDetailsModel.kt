package com.jaiberyepes.breakingbadchallenge.presentation.model

import android.view.View
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.jaiberyepes.breakingbadchallenge.R
import com.jaiberyepes.breakingbadchallenge.util.extensions.setRoundCorners

/**
 * EpoxyModelClass for the Character list.
 *
 * @author jaiber.yepes
 */
@EpoxyModelClass(layout = R.layout.item_character_details)
abstract class CharacterDetailsModel : EpoxyModelWithHolder<CharacterDetailsModel.CharacterDetailsHolder>() {

    @EpoxyAttribute
    lateinit var characterDetailsUI: CharacterDetailsUI

    override fun bind(holder: CharacterDetailsHolder) = with(holder) {
        Glide.with(recipeImageView)
            .load(characterDetailsUI.image)
            .apply(RequestOptions().placeholder(R.color.grayLight))
            .into(holder.recipeImageView)
        recipeImageView.setRoundCorners(R.dimen.margin_x_small)

        recipeTitleTextView.text = characterDetailsUI.name
//        recipeRatingBar.rating = recipeDetailsUI.rating.toFloat()
        recipeInstructionsTextView.text = characterDetailsUI.status

    }

    inner class CharacterDetailsHolder : EpoxyHolder() {

        lateinit var recipeImageView: ImageView
        lateinit var recipeTitleTextView: TextView
//        lateinit var recipeRatingBar: RatingBar
        lateinit var recipeInstructionsTextView: TextView
        lateinit var container: View

        override fun bindView(itemView: View) {
            recipeImageView = itemView.findViewById(R.id.recipeImageView)
            recipeTitleTextView = itemView.findViewById(R.id.recipeTitleTextView)
//            recipeRatingBar = itemView.findViewById(R.id.recipeRatingBar)
            recipeInstructionsTextView = itemView.findViewById(R.id.recipeInstructionsTextView)
            container = itemView
        }
    }
}
