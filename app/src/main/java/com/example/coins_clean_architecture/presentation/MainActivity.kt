package com.example.coins_clean_architecture.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.coins_clean_architecture.domain.model.Coins
import com.example.coins_clean_architecture.presentation.theme.Coins_Clean_ArchitectureTheme
import org.koin.android.ext.android.inject


class MainActivity : ComponentActivity() {

    private val viewModel by inject<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Coins_Clean_ArchitectureTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                }
                val state = viewModel.state.value
                LazyColumn(modifier = Modifier.fillMaxSize()) {
                    items(state.coins) { result ->
                        CoinListItem(
                            coins = result
                        )
                    }

                }
            }
        }
    }


    @Composable
    fun CoinListItem(
        coins: Coins
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "${coins.id}. ${coins.name} (${coins.symbol})",
                style = MaterialTheme.typography.body1,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}
