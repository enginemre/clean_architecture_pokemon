package com.engin.ui.views.pokemon_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.paging.LoadState
import androidx.recyclerview.widget.DividerItemDecoration
import com.engin.entity.model.Result
import com.engin.ui.adapter.LoadingStateAdapter
import com.engin.ui.adapter.PokemonListAdapter
import com.engin.ui.databinding.FragmentPokemonListScreenBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class PokemonListScreen : Fragment() {

    private val viewModel: PokemonListViewModel by viewModels()
    private var _binding: FragmentPokemonListScreenBinding? = null
    private val binding get() = _binding!!
    private val adapter: PokemonListAdapter =
        PokemonListAdapter {
            onItemClick(it)
        }
    private var hasInitiatedInitialCall = false
    private var job: Job? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPokemonListScreenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
    }

    /**
     *
     * Fetching pokemon list
     *
     */
    private fun fetchPokemonList() {

        //Collecting flow and adjusting adapter
        job?.cancel()
        job = lifecycleScope.launch {
            viewModel.getPokemonList().collectLatest {
                adapter.submitData(it)
            }
        }
    }

    /**
     *
     * Initializing UI elements
     *
     */
    private fun initUI() {

        // Setting paging adapter
        binding.pokemonListRv.adapter = adapter.withLoadStateFooter(
            footer = LoadingStateAdapter(retry = {
                adapter.retry()
            })
        )
        // Checking first initial call
        if (!hasInitiatedInitialCall) {
            fetchPokemonList()
            hasInitiatedInitialCall = true
        }
        //Paging3 showing progressbar when load state value was loading
        adapter.addLoadStateListener { loadState ->
            if (loadState.refresh is LoadState.Loading && adapter.snapshot().isEmpty()
            ) {
                binding.pokemonListProgress.isVisible = true
                binding.pokemonListError.isVisible = false
            } else {
                binding.pokemonListProgress.isVisible = false
                //Error checking
                val error = when {
                    loadState.prepend is LoadState.Error -> loadState.prepend as LoadState.Error
                    loadState.append is LoadState.Error -> loadState.append as LoadState.Error
                    loadState.refresh is LoadState.Error -> loadState.refresh as LoadState.Error
                    else -> null
                }
                // Retrying error
                if (adapter.snapshot().isEmpty()) {
                    error?.let {
                        binding.pokemonListError.visibility = View.VISIBLE
                        binding.pokemonListError.setOnClickListener {
                            adapter.retry()
                        }
                    }

                }
            }
        }


    }

    /**
     *
     *
     * Destroying View
     *
     */
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    /**
     *
     * Clicking item running
     *
     */
    private fun onItemClick(result: Result) {
        val action =
            PokemonListScreenDirections.actionPokemonListScreenToPokemonDetailScreen(result.name)
        findNavController().navigate(action)
    }
}