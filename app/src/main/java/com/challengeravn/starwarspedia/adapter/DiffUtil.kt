package com.challengeravn.starwarspedia.adapter
import androidx.recyclerview.widget.DiffUtil
import com.challengeravn.starwarspedia.model.CharacterModel
import com.example.starwars.CharacterQuery

class CharacterDiffUtil : DiffUtil.ItemCallback<CharacterModel>() {

    override fun areItemsTheSame(
        oldItem: CharacterModel,
        newItem: CharacterModel
    ): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(
        oldItem: CharacterModel,
        newItem: CharacterModel
    ): Boolean {
        return oldItem == newItem
    }

}