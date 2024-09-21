package com.example.produtosestoque

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun DetalheScreen(navController: NavController, nome: String, categoria: String, preco: Float, qntEstoque: Int) {
    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        Text("DETALHES DO PRODUTO", style = TextStyle(fontSize = 30.sp, fontWeight = FontWeight.Thin))

        Divider(thickness = 2.dp, modifier = Modifier.padding(vertical = 8.dp))

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Nome: $nome", style = MaterialTheme.typography.bodyMedium)
        Text(text = "Categoria: $categoria", style = MaterialTheme.typography.bodyMedium)
        Text(text = "Preço: R$ $preco", style = MaterialTheme.typography.bodyMedium)
        Text(text = "Quantidade em Estoque: $qntEstoque", style = MaterialTheme.typography.bodyMedium)

        Spacer(modifier = Modifier.height(14.dp))

        Button(onClick = { navController.popBackStack() }) {
            Text(text = "Voltar")
        }
    }
}