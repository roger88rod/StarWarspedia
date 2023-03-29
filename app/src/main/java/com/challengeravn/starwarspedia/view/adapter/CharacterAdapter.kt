package com.challengeravn.starwarspedia.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import com.challengeravn.starwarspedia.R
import com.challengeravn.starwarspedia.model.CharacterModel


class CharacterAdapter : PagingDataAdapter<CharacterModel,CharacterViewHolder>(CharacterDiffUtil()) {
    override fun onBindViewHolder(holder: CharacterViewHolder, pos: Int) {
        val charItem = getItem(pos)
        if (charItem != null) {
            holder.character(charItem)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return CharacterViewHolder(layoutInflater.inflate(R.layout.character_item,parent,false))
    }
}