package com.challengeravn.starwarspedia.services

import android.os.Looper
import com.apollographql.apollo3.ApolloClient

class swAPI {
    fun getApolloClient():ApolloClient{
        //Will work only in main Thread
        check(Looper.myLooper() == Looper.getMainLooper()){
            "Apollo Client can be used only in Main Thread"
        }
        return ApolloClient.Builder()
            .serverUrl("https://swapi-graphql.netlify.app/.netlify/functions/index").build()
    }
}