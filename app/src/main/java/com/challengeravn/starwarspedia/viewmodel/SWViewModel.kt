package com.challengeravn.starwarspedia.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.apollographql.apollo.ApolloQueryCall
import com.challengeravn.starwarspedia.modules.Repo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SWViewModel @Inject constructor(

): ViewModel(){
    private val loading = MutableLiveData<Boolean>()


    fun onCreate(){
        viewModelScope.launch {
            loading.postValue(true)



        }
    }


}