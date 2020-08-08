package com.jaiberyepes.breakingbadchallenge.util.base

/**
 * Interface for navigation between views.
 *
 * @author jaiber.yepes
 */
interface NavigationProvider<in A> {

    fun navigateTo(destinationView: A)
}
