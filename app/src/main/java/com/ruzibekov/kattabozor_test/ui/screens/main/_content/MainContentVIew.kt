package com.ruzibekov.kattabozor_test.ui.screens.main._content

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.ruzibekov.kattabozor_test.data.model.OfferResponse
import com.ruzibekov.kattabozor_test.ui.screens.main._components.MainTopBarView
import com.ruzibekov.kattabozor_test.ui.screens.main.state.MainState

object MainContentVIew {

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun Default(state: MainState) {

        Scaffold(
            topBar = {
                MainTopBarView.Default()
            },
            containerColor = Color.LightGray
        ) { paddingValues ->

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
                contentPadding = PaddingValues(all = 16.dp)
            ) {

                items(state.offers) { data ->
                    Item(data)
                }
            }
        }
    }

    @Composable
    private fun Item(data: OfferResponse) {
        Surface(
            modifier = Modifier.padding(bottom = 16.dp),
            shape = RoundedCornerShape(16.dp),
            color = Color.White
        ) {

            Column {

                AsyncImage(
                    model = data.image.url,
                    contentDescription = "offer image",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(100.dp)
                        .background(Color.Black)
                )

                Column(modifier = Modifier.padding(5.dp)) {

                    Text(text = data.name)

                    Text(text = data.brand)

                    Text(text = data.category)

                    Text(text = data.merchant)
                }
            }
        }
    }
}