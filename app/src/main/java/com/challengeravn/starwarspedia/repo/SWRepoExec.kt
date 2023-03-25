package com.challengeravn.starwarspedia.repo

import com.apollographql.apollo3.api.ApolloResponse
import com.challengeravn.starwarspedia.services.swAPI
import com.example.starwars.AllSWCharactersQuery
import com.example.starwars.CharacterQuery
import javax.inject.Inject

class SWRepoExec @Inject  constructor(
    private val characterService:swAPI
): SWRepo{
    override suspend fun querySWCharacterList(): ApolloResponse<AllSWCharactersQuery.Data> {
        return characterService.getApolloClient().query(AllSWCharactersQuery()).execute()
    }

    override suspend fun querySWCharacterDetails(id: String): ApolloResponse<CharacterQuery.Data> {
        return characterService.getApolloClient().query(CharacterQuery(id)).execute()
    }


}