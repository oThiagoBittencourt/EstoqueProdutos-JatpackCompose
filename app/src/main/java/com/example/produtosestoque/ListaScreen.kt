package com.example.produtosestoque

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun ProdutoItem(produto: Estoque, navController: NavController) {

    Column(modifier = Modifier.fillMaxWidth().padding(8.dp)) {
        Text(text = "Nome: ${produto.nome}", style = MaterialTheme.typography.bodyLarge)
        Text(text = "Categoria: ${produto.categoria}", style = MaterialTheme.typography.bodyMedium)

        Button(onClick = { navController.navigate(route = Screen.Detalhes_Produto.passArguments(nome = produto.nome, categoria = produto.categoria, preco = produto.preco, qntEstoque = produto.qntEstoque)) }, modifier = Modifier.padding(top = 8.dp) ) {
            Text(text = "Detalhes")
        }

        Divider(thickness = 2.dp, modifier = Modifier.padding(vertical = 8.dp))
    }
}

@Composable
fun ListaScreen(navController: NavController) {

    val produtos = Estoque.listarProdutos()

    Column (modifier = Modifier.fillMaxSize().padding(50.dp), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.spacedBy(space = 10.dp, alignment = Alignment.CenterVertically)) {
        Text("LISTA DE PRODUTOS", style = TextStyle(fontSize = 30.sp, fontWeight = FontWeight.Thin))

        Divider(thickness = 2.dp, modifier = Modifier.padding(vertical = 8.dp))

        Button(onClick = { navController.navigate(route = Screen.Cadastro_Produto.route) }) {
            Text(text = "Registrar Produto")
        }

        Button(onClick = { navController.navigate(route = Screen.Estatisticas_Produto.route) }) {
            Text(text = "Estatísticas")
        }

        LazyColumn (modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center, contentPadding = PaddingValues(10.dp)) {
            items(produtos) { produto ->
                ProdutoItem(produto = produto, navController = navController)
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun ListaScreenPreview() {
    ListaScreen(navController = rememberNavController())
}