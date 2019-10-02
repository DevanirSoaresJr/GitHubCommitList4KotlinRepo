package devanir.soaresjunior.commitlistgithub.di

import dagger.Component
import devanir.soaresjunior.commitlistgithub.ui.MainActivity
import javax.inject.Singleton

@Singleton
@Component(modules = [ActivityModule::class])
interface ActivityComponent {
    fun inject(mainActivity: MainActivity)
}