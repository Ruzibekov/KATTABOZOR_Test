package com.ruzibekov.kattabozor_test.ui.screens.main.state

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import com.ruzibekov.kattabozor_test.data.model.OfferResponse

data class MainState(
    val isLoading: MutableState<Boolean> = mutableStateOf(false),
    val offers: SnapshotStateList<OfferResponse> = mutableStateListOf()
)