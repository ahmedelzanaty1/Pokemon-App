import androidx.compose.ui.graphics.Color
import com.example.pocemonapp.R

data class Pokemon(
    val name: String,
    val type: String,
    val attack: Int,
    val defense: Int,
    val imageResId: Int,
    val backgroundColor: androidx.compose.ui.graphics.Color
)
val pokemonList = listOf(
    Pokemon("Bulbasaur", "grass", 65, 65, R.drawable.bulbasaur, Color(0xFF8BC34A)),
    Pokemon("Ivysaur", "grass", 80, 80, R.drawable.ivysaur, Color(0xFF8BC34A)),
    Pokemon("Venusaur", "grass", 122, 120, R.drawable.venusaur, Color(0xFF8BC34A)),
    Pokemon("Charmander", "fire", 60, 50, R.drawable.charmander, Color(0xFFF44336)),
    Pokemon("Charmeleon", "fire", 80, 65, R.drawable.charmeleon, Color(0xFFF44336))
)


