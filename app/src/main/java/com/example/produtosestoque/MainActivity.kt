package com.example.produtosestoque

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.produtosestoque.ui.theme.ProdutosEstoqueTheme

class MainActivity : ComponentActivity() {

    lateinit var navController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProdutosEstoqueTheme {
                navController = rememberNavController()
                SetupNavGraph(navController = navController)
            }
        }
    }
}