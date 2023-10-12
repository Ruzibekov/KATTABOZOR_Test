package com.ruzibekov.kattabozor_test.ui.screens.main

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.lifecycleScope
import com.ruzibekov.kattabozor_test.data.model.OfferResponse
import com.ruzibekov.kattabozor_test.ui.screens.main._components.LoadingView
import com.ruzibekov.kattabozor_test.ui.screens.main._components.MainTopBarView
import com.ruzibekov.kattabozor_test.ui.theme.KATTABOZOR_TestTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KATTABOZOR_TestTheme {

                MainContent()

                if (viewModel.state.isLoading.value)
                    LoadingView.Default()
            }
        }

        viewModel.fetch()

        initObservers()
    }

    private fun initObservers() {
        viewModel.messageFlow
            .onEach { message ->
                Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
            }
            .launchIn(lifecycleScope)
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    private fun MainContent() {

        Scaffold(
            topBar = {
                MainTopBarView.Default()
            }
        ) { paddingValues ->

            LazyColumn(
                modifier = Modifier.fillMaxSize().padding(paddingValues),
                contentPadding = PaddingValues(all = 16.dp)
            ) {

                items(viewModel.state.offers) { data ->
                    Item(data)
                }
            }
        }
    }

    @Composable
    private fun Item(data: OfferResponse) {
        Column {
            Text(text = data.name)
            Text(text = data.brand)
            Text(text = data.brand)
            Text(text = data.brand)
        }
    }
}