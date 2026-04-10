package com.example.ca1sem6

import android.annotation.SuppressLint
import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ca1sem6.ui.theme.CA1Sem6Theme
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MainScreen()
        }
    }
}

@Composable
fun MainScreen(){
    val navController = rememberNavController();
    NavHost(
        navController = navController,
        startDestination = "Splash"
    ){
        composable("Splash") {
            Splash(navController)
        }
        composable("Home") {
            Home(navController)
        }
    }


}

@Composable
fun Splash(navController: NavController){
    LaunchedEffect(1) {
        delay(3000)
        navController.navigate("Home")
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Weather App", fontSize = 40.sp, color = Color.Black)
    }
}

data class Weather(val city: String, val temp: Int)

@Composable
fun Home(navController: NavController){
    val city = listOf(Weather("Lucknow", 32),Weather("Lucknow", 32),Weather("Lucknow", 32),Weather("Lucknow", 32),Weather("Lucknow", 32),Weather("Lucknow", 32),Weather("Lucknow", 32),Weather("Lucknow", 32),Weather("Lucknow", 32),Weather("Lucknow", 32),Weather("Lucknow", 32),Weather("Lucknow", 32),Weather("Lucknow", 32),Weather("Lucknow", 32),Weather("Lucknow", 32),Weather("Lucknow", 32),Weather("Lucknow", 32),Weather("Lucknow", 32))
    Text("Weather App", fontSize = 50.sp)
    Spacer(modifier = Modifier.height(80.dp))
    LazyColumn {
        items(city){items ->
            Row(
                modifier = Modifier.fillMaxWidth().padding(20.dp).background(color = Color.Black),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(items.city, fontSize = 40.sp, color = Color.White)
                Text("${items.temp}", fontSize = 40.sp, color = Color.White)
            }
        }
    }

}
