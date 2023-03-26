package com.challengeravn.starwarspedia.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.challengeravn.starwarspedia.databinding.CharacterItemBinding
import com.challengeravn.starwarspedia.model.CharacterModel

class CharacterViewHolder(view:View): RecyclerView.ViewHolder(view) {
    private val charBinding = CharacterItemBinding.bind(view)

    fun character(characterModel:CharacterModel){
        charBinding.txtvCharacterName.text = characterModel.name
        charBinding.txtvCharacterDetails.text = characterModel.homeworld

    }

}