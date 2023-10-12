package com.ruzibekov.kattabozor_test.ui.screens.main._components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.ruzibekov.kattabozor_test.R
import com.ruzibekov.kattabozor_test.ui.screens.main.listeners.MainListeners

object MainListIsEmptyView {

    @Composable
    fun Defaulta(listeners: MainListeners) {

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = stringResource(id = R.string.data_not_found),
                textAlign = TextAlign.Center,
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(10.dp))

            Button(
                onClick = { listeners.loadData() }
            ) {
                Text(text = stringResource(id = R.string.load_data))
            }
        }
    }
}