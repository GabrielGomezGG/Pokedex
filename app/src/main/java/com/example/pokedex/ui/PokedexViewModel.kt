package com.example.pokedex.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokedex.data.PokedexRepository
import com.example.pokedex.data.models.Pokemon
import com.example.pokedex.domain.GetPokemonListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokedexViewModel @Inject constructor(
    private val getPokemonListUseCase: GetPokemonListUseCase
) : ViewModel() {

    private val _pokedex = MutableStateFlow<PokedexUiState>(PokedexUiState.Loading)
    val pokedex : StateFlow<PokedexUiState> = _pokedex.asStateFlow()

    init {
        getPokemonList()
    }

    private fun getPokemonList(){
        viewModelScope.launch(Dispatchers.IO){
            getPokemonListUseCase()
                .catch { _pokedex.value = PokedexUiState.Error }
                .collect{ _pokedex.value = PokedexUiState.Success(it)}
        }
    }

//    val pokedex = MutableLiveData<Pokedex>()
//
//    private val _screenState: MutableStateFlow<PokedexScreenState> = MutableStateFlow(
//        PokedexScreenState.Loading)
//    val screenState: Flow<PokedexScreenState> = _screenState
//
//    private val coroutineExceptionHandler =
//        CoroutineExceptionHandler { coroutineContext, throwable ->
//            Log.d("PokedexViewModel", "Error retrieving pokedex: ${throwable.message}")
//        }
//
//    init {
//        viewModelScope.launch(coroutineExceptionHandler) {
//            kotlin.runCatching {
//                pokedexRepository.getPokedex()
//            }.onSuccess {
//                if (it.body() != null) {
//                    pokedex.postValue(it.body()!!)
//                    _screenState.value = PokedexScreenState.ShowPokedex(it.body()!!)
//                } else {
//                    _screenState.value = PokedexScreenState.Error
//                }
//            }.onFailure {
//                Log.d("PokedexViewModel", "Error retrieving pokedex: ${it.message}")
//                _screenState.value = PokedexScreenState.Error
//            }
//
//        }
//    }

}
