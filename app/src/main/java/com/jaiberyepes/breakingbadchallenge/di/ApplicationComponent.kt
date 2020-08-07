package com.jaiberyepes.breakingbadchallenge.di

import android.app.Application
import com.jaiberyepes.breakingbadchallenge.App
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

/**
 * [Component] to provide AndroidInjector for custom project Application.
 * Binds all the modules.
 *
 * @author jaiber.yepes
 */
@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        NetworkModule::class
//        ApplicationModule::class,
//        DataModule::class,
//        ActivityModule::class,
//        FragmentModule::class
    ]
)
interface ApplicationComponent : AndroidInjector<App> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): ApplicationComponent
    }
}
