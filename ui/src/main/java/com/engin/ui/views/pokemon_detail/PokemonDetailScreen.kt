package com.engin.ui.views.pokemon_detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.engin.ui.R
import com.engin.ui.databinding.FragmentPokemonDetailScreenBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PokemonDetailScreen : Fragment() {

    private lateinit var _binding: FragmentPokemonDetailScreenBinding
    private val viewModel: PokemonDetailViewModel by viewModels()
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPokemonDetailScreenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observe()
    }

    /**
     *
     * Observing Data
     *
     */
    private fun observe() {
        viewModel.state.observe(viewLifecycleOwner) {
            // Loading scope
            if (!it.isLoading) {
                binding.pokemonDetailProgressBar.visibility = View.INVISIBLE
                // Error scope
                if (it.error.isNotBlank()) {
                    binding.pokemonDetailErrorMessage.visibility = View.VISIBLE
                    binding.pokemonDetailErrorMessage.text = it.error
                }
                // Success scope
                else {
                    binding.pokemonDetailLayout.visibility = View.VISIBLE
                    binding.pokemonDetailErrorMessage.visibility = View.GONE
                    binding.data = it.pokemon
                    Glide.with(requireActivity())
                        .load(it.pokemon?.imageUrl)
                        .into(binding.imageView);
                }
            } else {
                binding.pokemonDetailProgressBar.visibility = View.VISIBLE
                binding.pokemonDetailLayout.visibility = View.GONE
                binding.pokemonDetailErrorMessage.visibility = View.GONE
            }
        }
    }


}