package com.example.characterapi2.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.character.databinding.ItemHomeBinding
import com.example.characterapi2.models.CharacterAndLocationModel

class HomeAdapter : ListAdapter<CharacterAndLocationModel, HomeAdapter.ViewHolder>(
    VideoDiffCallBack()
) {

    inner class ViewHolder(private val binding: ItemHomeBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(item: CharacterAndLocationModel) = with(binding) {
            binding.itemId.text = item.location.dimension
            binding.itemName.text = item.character.name
            binding.itemType.text = item.location.type
            Glide.with(binding.imageHome).load(item.character.image)
                .into(binding.imageHome)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemHomeBinding.inflate(
                LayoutInflater.from(
                    parent.context
                ), parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        getItem(position)?.let { holder.onBind(it) }
    }

    private class VideoDiffCallBack : DiffUtil.ItemCallback<CharacterAndLocationModel>() {
        override fun areItemsTheSame(
            oldItem: CharacterAndLocationModel,
            newItem: CharacterAndLocationModel
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: CharacterAndLocationModel,
            newItem: CharacterAndLocationModel
        ): Boolean {
            return oldItem == newItem
        }
    }
}