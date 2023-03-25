package com.challengeravn.starwarspedia.modules

import com.challengeravn.starwarspedia.repo.SWRepo
import com.challengeravn.starwarspedia.repo.SWRepoExec
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class ViewModel {
    @ViewModelScoped
    @Binds
    abstract fun bindRepo(repo:SWRepoExec):SWRepo
}