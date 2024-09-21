package com.example.produtosestoque

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument

@Composable
fun SetupNavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screen.Lista_Produto.route) {
        composable(route = Screen.Lista_Produto.route) {
            ListaScreen(navController = navController)
        }
        composable(route = Screen.Cadastro_Produto.route) {
            CadastroScreen(navController = navController)
        }
        composable(route = Screen.Detalhes_Produto.route, arguments = listOf(
            navArgument(DETALHES_ARGUMENT_NOME) { type = NavType.StringType },
            navArgument(DETALHES_ARGUMENT_CATEGORIA) { type = NavType.StringType },
            navArgument(DETALHES_ARGUMENT_PRECO) { type = NavType.FloatType },
            navArgument(DETALHES_ARGUMENT_QNTESTOQUE) { type = NavType.IntType })
        ) { backStackEntry ->
            val nome = backStackEntry.arguments?.getString(DETALHES_ARGUMENT_NOME).toString()
            val categoria = backStackEntry.arguments?.getString(DETALHES_ARGUMENT_CATEGORIA).toString()
            val preco = backStackEntry.arguments?.getFloat(DETALHES_ARGUMENT_PRECO)
            val qntEstoque = backStackEntry.arguments?.getInt(DETALHES_ARGUMENT_QNTESTOQUE)
            if ((qntEstoque != null) && (preco != null)) {
                    DetalheScreen(navController = navController, nome = nome, categoria = categoria, preco = preco, qntEstoque = qntEstoque)
            }
        }
        composable(route = Screen.Estatisticas_Produto.route) {
            EstatisticasScreen(navController = navController)
        }
    }
}