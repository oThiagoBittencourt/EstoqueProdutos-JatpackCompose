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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun EstatisticasScreen(navController: NavController) {
    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        Text("ESTATÍSTICAS", style = TextStyle(fontSize = 30.sp, fontWeight = FontWeight.Thin))

        Divider(thickness = 2.dp, modifier = Modifier.padding(vertical = 8.dp))

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Quantidade Total de Produtos (u): ${Estoque.calcularQuantidadeTotal()}", style = MaterialTheme.typography.bodyMedium)
        Text(text = "Valor Total do Estoque: R$${Estoque.calcularValorTotalEstoque()}", style = MaterialTheme.typography.bodyMedium)

        Spacer(modifier = Modifier.height(14.dp))

        Button(onClick = { navController.popBackStack() }) {
            Text(text = "Voltar")
        }
    }
}

@Composable
@Preview(showBackground = true)
fun EstatisticasScreenPreview() {
    EstatisticasScreen(navController = rememberNavController())
}