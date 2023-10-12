package com.ruzibekov.kattabozor_test.ui.screens.main._components

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.ruzibekov.kattabozor_test.R

object MainTopBarView {

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun Default() {
        
        TopAppBar(
            title = { 
                Text(
                    text = stringResource(id = R.string.offers),
                    style = MaterialTheme.typography.titleMedium
                )
            }
        )
    }
}