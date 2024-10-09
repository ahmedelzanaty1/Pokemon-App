package com.example.pocemonapp

import Pokemon
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pocemonapp.ui.theme.PocemonAppTheme
import pokemonList

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PocemonAppTheme {
                PokemonList(pokemonList)

                }
            }
        }
    }
@Composable
fun PokemonCard(pokemon: Pokemon) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(pokemon.backgroundColor)
            .padding(16.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = pokemon.name,
                    style = MaterialTheme.typography.headlineLarge,
                    color = Color.White
                )
                Chip(pokemon.type) // A custom Chip function to display the Pokémon type
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = "Attack: ${pokemon.attack}", color = Color.White)
                Text(text = "Defense: ${pokemon.defense}", color = Color.White)
            }
            Image(
                painter = painterResource(id = pokemon.imageResId),
                contentDescription = null,
                modifier = Modifier.size(96.dp)
            )
        }
    }
}

@Composable
fun Chip(type: String) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(8.dp))
            .background(Color(0x80FFFFFF))
            .padding(horizontal = 8.dp, vertical = 4.dp)
    ) {
        Text(
            text = type,
            color = Color.White,
            style = MaterialTheme.typography.bodyLarge
        )
    }
}
@Composable
fun PokemonList(pokemonList: List<Pokemon>) {
    LazyColumn(
        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(pokemonList) { pokemon ->
            PokemonCard(pokemon)
        }
    }
}




