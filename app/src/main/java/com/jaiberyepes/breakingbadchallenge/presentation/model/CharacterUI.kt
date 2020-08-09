package com.jaiberyepes.breakingbadchallenge.presentation.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Data class for Character UI entity.
 *
 * @author jaiber.yepes
 */
@Parcelize
data class CharacterUI(
    val id: Int,
    val name: String,
    val nickName: String,
    val image: String
) : Parcelable
