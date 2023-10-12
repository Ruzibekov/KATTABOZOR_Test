package com.ruzibekov.kattabozor_test.ui.screens.main

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.ruzibekov.kattabozor_test.ui.screens.main._components.LoadingView
import com.ruzibekov.kattabozor_test.ui.screens.main._content.MainContentVIew
import com.ruzibekov.kattabozor_test.ui.screens.main.listeners.MainListeners
import com.ruzibekov.kattabozor_test.ui.theme.KATTABOZOR_TestTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@AndroidEntryPoint
class MainActivity : ComponentActivity(), MainListeners {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KATTABOZOR_TestTheme {

                MainContentVIew.Default(viewModel.state, this)

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

    override fun loadData() {
        viewModel.fetch()
    }

}