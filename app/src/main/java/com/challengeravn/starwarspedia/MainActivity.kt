package com.challengeravn.starwarspedia

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope

import androidx.recyclerview.widget.LinearLayoutManager
import com.challengeravn.starwarspedia.view.adapter.CharacterAdapter
import com.challengeravn.starwarspedia.databinding.ActivityMainBinding
import com.challengeravn.starwarspedia.viewmodel.SWState
import com.challengeravn.starwarspedia.viewmodel.SWViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var characterAdapter = CharacterAdapter()
    private val charactersViewModel : SWViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //characterAdapter = CharacterAdapter()
        binding.rvSW.apply {characterAdapter}
        charactersViewModel.queryCharacterList()
        val linearManager = LinearLayoutManager(this)
        binding.rvSW.layoutManager = linearManager
        binding.rvSW.adapter = characterAdapter

        lifecycleScope.launch {
            observeData()
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun  observeData(){
        charactersViewModel.characterList.observe(this){
            it?.let { items ->
                //characterAdapter.submitData(items.value?.data?.allPeople?.people)
                //Getting Data correctly!!!! YEAH!! Now attach it to Adapter
                Log.i("GetChar ", items.value?.data?.allPeople?.people.toString())
            }
                /*response ->
            when(response){
                is SWState.Success ->{
                    val results = response.value?.data?.allPeople?.people
                    //Getting Data correctly!!!! YEAH!! Now attach it to Adapter
                    Log.i("GetChar ", response.value?.data?.allPeople?.people.toString())

                    characterAdapter.notifyDataSetChanged()


                }
                else -> Unit
            }
*/
        }
    }
}