package com.ruzibekov.kattabozor_test.ui.screens.main._components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.ruzibekov.kattabozor_test.ui.theme.AppColor

object LoadingView {

    @Composable
    fun Default() {

        Surface(
            modifier = Modifier.fillMaxSize(),
            color = AppColor.Black50
        ) {

            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {

                CircularProgressIndicator()
            }
        }
    }
}