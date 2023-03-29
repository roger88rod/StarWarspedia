package com.challengeravn.starwarspedia.repo

import android.util.Log
import com.apollographql.apollo3.api.ApolloResponse
import com.apollographql.apollo3.api.Optional
import com.challengeravn.starwarspedia.AllSWCharactersQuery
import com.challengeravn.starwarspedia.CharacterQuery
import com.challengeravn.starwarspedia.services.swAPI

import javax.inject.Inject

class SWRepoExec @Inject  constructor(
    private val characterService:swAPI
): SWRepo {

    override suspend fun querySWCharacterList(): ApolloResponse<AllSWCharactersQuery.Data> {
        return characterService.getApolloClient().query(AllSWCharactersQuery()).execute()
    }

    override suspend fun querySWCharacterDetails(id: String): ApolloResponse<CharacterQuery.Data> {
        return characterService.getApolloClient().query(CharacterQuery(id)).execute()
    }

}