package com.example.jogovestir

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
        2 -> R.drawable.boneca_saia
        3 -> R.drawable.boneca_jardineira
        else -> R.drawable.boneca_vestido_vermelho
    }
    var cor by remember { mutableStateOf(1) }
    var corResult = when(cor){
        1 -> Color(0xFFFFD8F8)
        2 -> Color(0xFFFFC9D6)
        3 -> Color(0xFFF6E6FF)
        4 -> Color(0xFFFFD4A8)
        else -> Color(0xFFFFDDE4)
    }

    var corHFResult = when(cor){
        1 -> Color(0xFFFF9EEA)
        2 -> Color(0xFFFF6F91)
        3 -> Color(0xFFE2B8FF)
        4 -> Color(0xFFFFA64D)
        else -> Color(0xFFFFA3B8)
    }

    Column{
        Column(modifier = Modifier
            .background(corHFResult)
            .fillMaxWidth()){
            Row(modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween){
                Text(text = "DressUP",
                    modifier = Modifier.padding(16.dp),
                    color = Color.White)
                Button(onClick = { roupas = 1 },
                    colors = ButtonDefaults.buttonColors(containerColor = corHFResult)) {
                    Image(painter = painterResource(R.drawable.reiniciar),
                        contentDescription = "Reiniciar",
                        modifier = Modifier.size(40.dp))
                }
            }
        }

        Column(modifier = Modifier
            .background(corResult)
            .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center){

            Image(painter = painterResource(id = roupasResult), contentDescription = "Roupas" )


            Row{
                Button(onClick = {roupas = (2..5).random()},
                    colors = ButtonDefaults.buttonColors(containerColor = corHFResult),
                    modifier = Modifier.padding(10.dp)
                        .size(100.dp, 50.dp)) {
                    Text(stringResource(R.string.roupas))
                }
                Button(onClick = {cor = (1..5).random()},
                    colors = ButtonDefaults.buttonColors(containerColor = corResult),
                    modifier = Modifier.size(140.dp, 70.dp)) {
                    Image(painter = painterResource(R.drawable.paletepincel),
                        contentDescription = "Mudar Tema")
                }
            }

        }

    }
}
