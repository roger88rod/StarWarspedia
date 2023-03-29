package com.challengeravn.starwarspedia.repo

import com.apollographql.apollo3.api.ApolloResponse
import com.challengeravn.starwarspedia.AllSWCharactersQuery
import com.challengeravn.starwarspedia.CharacterQuery


interface SWRepo {
    //To get all SW Characters
   suspend fun querySWCharacterList() : ApolloResponse<AllSWCharactersQuery.Data>

    //To get Single character details must receive id
   suspend fun querySWCharacterDetails(id:String): ApolloResponse<CharacterQuery.Data>
}