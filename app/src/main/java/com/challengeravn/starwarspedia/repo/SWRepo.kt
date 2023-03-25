package com.challengeravn.starwarspedia.repo

import com.apollographql.apollo3.api.ApolloResponse
import com.example.starwars.AllSWCharactersQuery
import com.example.starwars.CharacterQuery

interface SWRepo {
    //To get all SW Characters
   suspend fun querySWCharacterList() : ApolloResponse<AllSWCharactersQuery.Data>

    //To get Single character details must receive id
   suspend fun querySWCharacterDetails(id:String): ApolloResponse<CharacterQuery.Data>
}