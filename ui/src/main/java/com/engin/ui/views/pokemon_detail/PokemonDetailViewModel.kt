package com.engin.ui.views.pokemon_detail

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.lifecycle.*
import com.bumptech.glide.Glide
import com.engin.base.Constants
import com.engin.base.Resource
import com.engin.domain.usecase.get_pokemon.GetPokemonUseCase
import com.engin.ui.R
import com.engin.ui.state.PokemonDetailState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class PokemonDetailViewModel @Inject constructor(
    private val getPokemonUseCase: GetPokemonUseCase,
    private val stateHandle: SavedStateHandle
) : ViewModel() {


    private var _state = MutableLiveData<PokemonDetailState>()
    val state: LiveData<PokemonDetailState> = _state

    init {
        stateHandle.get<String>(Constants.PARAM_POKEMON_NAME)?.let { getPokemon(it) }
    }

    private fun getPokemon(name: String) {
        getPokemonUseCase(name).onEach {
            when (it) {
                is Resource.Success -> {
                    _state.postValue(PokemonDetailState(pokemon = it.data))
                }
                is Resource.Loading -> {
                    _state.postValue(PokemonDetailState(isLoading = true))
                }
                is Resource.Error -> {
                    _state.postValue(
                        PokemonDetailState(
                            error = it.message ?: "Unknown error occurred"
                        )
                    )
                }
            }
        }.launchIn(viewModelScope)
    }
}