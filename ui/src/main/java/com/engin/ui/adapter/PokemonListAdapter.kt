package com.engin.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.engin.entity.model.Result
import com.engin.ui.databinding.ItemPokemonBinding
import java.net.URL

/**
 *
 * RecyclerView adapter with navigate function when clicked this adapter supported
 * Paging and diff callback
 *
 */
class PokemonListAdapter(
    private val navigate: (Result) -> Unit,
) : PagingDataAdapter<Result, PokemonListAdapter.PokemonListViewHolder>(
    PokemonDiffCallback()
) {

    private lateinit var binding: ItemPokemonBinding

    class PokemonListViewHolder(private val binding: ItemPokemonBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: Result) {
            binding.pokemon = data
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonListViewHolder {
        binding = ItemPokemonBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PokemonListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PokemonListViewHolder, position: Int) {
        val pokemon = getItem(position)!!
        holder.bind(pokemon)
        holder.itemView.setOnClickListener {
            navigate.invoke(pokemon)
        }
    }


    private class PokemonDiffCallback : DiffUtil.ItemCallback<Result>() {
        override fun areItemsTheSame(oldItem: Result, newItem: Result): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Result, newItem: Result): Boolean {
            return oldItem == newItem
        }
    }
}