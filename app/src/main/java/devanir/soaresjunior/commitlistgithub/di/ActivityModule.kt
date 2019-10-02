package devanir.soaresjunior.commitlistgithub.di

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import dagger.Module
import dagger.Provides
import devanir.soaresjunior.commitlistgithub.net.CommitService
import devanir.soaresjunior.commitlistgithub.repo.Repository
import devanir.soaresjunior.commitlistgithub.repo.RepositoryImpl
import devanir.soaresjunior.commitlistgithub.ui.HomeViewModel
import devanir.soaresjunior.commitlistgithub.ui.ViewModelFactory
import javax.inject.Singleton


@Module(includes = [NetworkModule::class])
class ActivityModule(private val activity: AppCompatActivity) {
    @Provides
    @Singleton
    fun provideHomeViewModel(factory: ViewModelFactory)
            = ViewModelProviders.of(activity, factory)
        .get(HomeViewModel::class.java)

    @Provides
    @Singleton
    fun provideRepository(commitService: CommitService): Repository = RepositoryImpl(commitService)
}