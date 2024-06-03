package com.osaigbovo.composebottomnavigationbar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.osaigbovo.composebottomnavigationbar.ui.screen.MainScreen
import com.osaigbovo.composebottomnavigationbar.ui.theme.ComposeBottomNavigationBarTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            ComposeBottomNavigationBarTheme {
                val navController = rememberNavController()
                Surface(modifier = Modifier.fillMaxSize()) {
                    MainScreen(navController = navController)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeBottomNavigationBarTheme {
        val navController = rememberNavController()
        Surface(modifier = Modifier.fillMaxSize()) {
            MainScreen(navController = navController)
        }
    }
}
