package com.ruzibekov.kattabozor_test.ui.screens.main

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ruzibekov.kattabozor_test.domain.repository.IOffersRepository
import com.ruzibekov.kattabozor_test.ui.screens.main.state.MainState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: IOffersRepository
) : ViewModel() {

    val state = MainState()

    private val _messageFlow: MutableSharedFlow<String> = MutableSharedFlow()
    val messageFlow: SharedFlow<String> = _messageFlow

    fun fetch() {
        repository.getOffers()
            .onStart {
                state.isLoading.value = true
                state.offers.clear()
            }
            .onEach {
                with(it) {
                    onSuccess { response ->
                        state.offers.addAll(response.offers)
                    }
                    onFailure { throwable ->
                        _messageFlow.emit(throwable.message.toString())
                    }
                }
            }
            .catch {
                Log.i("RRR", it.message.toString())
            }
            .onCompletion {
                state.isLoading.value = false
            }
            .launchIn(viewModelScope)
    }
}