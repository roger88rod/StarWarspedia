package com.challengeravn.starwarspedia.modules

import com.challengeravn.starwarspedia.repo.SWRepoExec
import com.challengeravn.starwarspedia.services.swAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object Repo{
    @Singleton
    @Provides
    fun characterService() = swAPI()
}