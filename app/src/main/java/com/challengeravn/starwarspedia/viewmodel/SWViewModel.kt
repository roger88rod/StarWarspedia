package com.challengeravn.starwarspedia.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.apollographql.apollo.ApolloQueryCall
import com.apollographql.apollo3.api.ApolloResponse
import com.apollographql.apollo3.exception.ApolloException
import com.challengeravn.starwarspedia.AllSWCharactersQuery
import com.challengeravn.starwarspedia.modules.Repo
import com.challengeravn.starwarspedia.repo.SWRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SWViewModel @Inject constructor(
private val repo: SWRepo
): ViewModel(){

    private val _characterList by lazy { MutableLiveData<SWState<ApolloResponse<AllSWCharactersQuery.Data>>>() }
    val characterList: LiveData<SWState<ApolloResponse<AllSWCharactersQuery.Data>>>
        get() = _characterList

    fun queryCharacterList() = viewModelScope.launch {
        _characterList.postValue(SWState.Loading())
        try {
            val response = repo.querySWCharacterList()
           // Log.i("SW", response.data?.allPeople?.people.toString())
            _characterList.postValue(SWState.Success(response))
        } catch (e: ApolloException){
            Log.i("Apollo Exception", "Failure",e)
            _characterList.postValue(SWState.Error("Error fetching Characters"))
        }
    }

}