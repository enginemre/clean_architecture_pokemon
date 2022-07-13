package com.engin.ui.views.pokemon_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.engin.domain.usecase.get_pokemon_list.GetPokemonListUseCase
import com.engin.entity.model.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class PokemonListViewModel @Inject constructor(
    private val getPokemonListUseCase: GetPokemonListUseCase
) : ViewModel() {

    fun getPokemonList(): Flow<PagingData<Result>> {
        return getPokemonListUseCase()
            .cachedIn(viewModelScope)
    }
}