package com.engin.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.engin.base.Constants
import com.engin.base.Resource
import com.engin.data.data_source.PokemonPagingSource
import com.engin.data.remote.PokemonApi
import com.engin.domain.repository.PokemonRepository
import com.engin.entity.dto.toPokemon
import com.engin.entity.model.Pokemon
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject


class PokemonRepositoryImpl @Inject constructor(
    private val api:PokemonApi
): PokemonRepository {

    /**
     *
     * Getting pokemon with page config and paging data source
     *
     */
    override  fun getPokemonList()= Pager(
            config = PagingConfig(enablePlaceholders = false, pageSize = Constants.DEFAULT_PAGE_SIZE),
            pagingSourceFactory = {
                PokemonPagingSource(api)
            }
        ).flow


    override   fun getPokemon(name: String): Flow<Resource<Pokemon>> {
        return flow {
            try {
                emit(Resource.Loading())
                val pokemon = api.getPokemonInfo(name).toPokemon()
                emit(Resource.Success(pokemon))
            } catch (e: HttpException) {
                emit(Resource.Error(e.localizedMessage ?: "Beklenmeyen bir hata oluştu"))
            } catch (e: IOException) {
                emit(Resource.Error("İnternet Bağlantınızı kontrol ediniz."))
            }
        }
    }
}