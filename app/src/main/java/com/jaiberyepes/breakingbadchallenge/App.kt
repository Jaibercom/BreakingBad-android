package com.jaiberyepes.breakingbadchallenge

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.ProcessLifecycleOwner
import com.jaiberyepes.breakingbadchallenge.di.DaggerApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import timber.log.Timber

/**
 * Project main Application class that inherits from [DaggerApplication].
 *
 * @author jaiber.yepes
 */
class App : DaggerApplication(), LifecycleObserver {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> =
        DaggerApplicationComponent.builder().application(this).build()

    override fun onCreate() {
        super.onCreate()

        // Timber
        Timber.plant(Timber.DebugTree())

        // LifeCycle
        ProcessLifecycleOwner.get().lifecycle
            .addObserver(this)
    }
}
