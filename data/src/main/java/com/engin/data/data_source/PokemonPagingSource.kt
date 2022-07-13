package com.engin.data.data_source

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.engin.base.Constants
import com.engin.data.remote.PokemonApi
import com.engin.entity.dto.toPokemonList
import com.engin.entity.model.Result
import retrofit2.HttpException
import java.io.IOException

/**
 *
 * Data source for pagination with paging3 jetpack library
 *
 */
class PokemonPagingSource(private val pokemonApi: PokemonApi) :
    PagingSource<Int, Result>() {
    override fun getRefreshKey(state: PagingState<Int, Result>): Int? {
        return state.anchorPosition
    }

    /**
     *
     * Loading items with adjusted page numbers and offset
     *
     */
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Result> {
        val offset = params.key ?: Constants.STARTING_OFFSET_INDEX
        val loadSize = params.loadSize
        return try {
            val data = pokemonApi.getPokemonList(loadSize, offset)
            //Calculating end point with size and offset
            LoadResult.Page(
                data = data.toPokemonList().results,
                prevKey = if (offset == Constants.STARTING_OFFSET_INDEX) null else offset - loadSize,
                nextKey = if (data.next == null) null else offset + loadSize
            )
        } catch (e: IOException) {
            LoadResult.Error(IOException("Check your Internet connection"))
        } catch (e: HttpException) {
            LoadResult.Error(e)
        }
    }
}