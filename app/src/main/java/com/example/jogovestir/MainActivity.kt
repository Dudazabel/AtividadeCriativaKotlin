package com.example.jogovestir

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import com.example.jogovestir.ui.theme.JogoVestirTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JogoVestirTheme {
                JogoVestir(modifier = Modifier
                    .fillMaxSize()
                    .safeDrawingPadding())
            }
        }
    }
}

@Composable
fun JogoVestir(modifier: Modifier = Modifier){
    var roupas by remember { mutableStateOf(1) }
    var roupasResult = when(roupas){
        1 -> R.drawable.boneca
        2 -> R.drawable.boneca_jardineira
        3 -> R.drawable.boneca_saia
        4 -> R.drawable.boneca_vestido_rosa
        else -> R.drawable.boneca_vestido_vermelho
    }
    var cor by remember { mutableStateOf(1) }
    var corResult = when(cor){
        1 -> Color(0xFFFFA3EE)
        2 -> Color(0xFFFF6E8B)
        3 -> Color(0xFFE6BEFA)
        4 -> Color(0xFFFFA754)
        else -> Color(0xFFFFAAB8)
    }

    Column(modifier = modifier.background(corResult),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center){

        Spacer(modifier = Modifier.height(30.dp))
        Image(painter = painterResource(id = roupasResult), contentDescription = "Roupas" )
        Spacer(modifier = Modifier.height(30.dp))
        Button(onClick = {roupas = (2..5).random()}) {
            Text(stringResource(R.string.roupas))
        }
        Spacer(modifier = Modifier.height(30.dp))
        Button(onClick = {cor = (1..5).random()}) {
            Text(stringResource(R.string.cor))
        }

    }
}
