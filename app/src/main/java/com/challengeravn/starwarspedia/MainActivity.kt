package com.challengeravn.starwarspedia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope

import androidx.recyclerview.widget.LinearLayoutManager
import com.challengeravn.starwarspedia.view.adapter.CharacterAdapter
import com.challengeravn.starwarspedia.databinding.ActivityMainBinding
import com.challengeravn.starwarspedia.viewmodel.SWViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var characterAdapter: CharacterAdapter
    private val charactersViewModel : SWViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        characterAdapter = CharacterAdapter()

        charactersViewModel.onCreate()
        initializeRV()


    }

    private fun initializeRV(){
        val linearManager = LinearLayoutManager(this)
        binding.rvSW.layoutManager = linearManager

        binding.rvSW.adapter = characterAdapter
    }
}