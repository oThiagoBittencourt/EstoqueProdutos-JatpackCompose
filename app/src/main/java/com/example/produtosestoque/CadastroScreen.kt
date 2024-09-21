package com.example.produtosestoque

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun CadastroScreen(navController: NavController){
    var nome by remember { mutableStateOf("") }
    var categoria by remember { mutableStateOf("") }
    var preco by remember { mutableStateOf("") }
    var qntEstoque by remember { mutableStateOf("") }

    val context = LocalContext.current

    Column (modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.spacedBy(space = 10.dp, alignment = Alignment.CenterVertically)){
        Text("CADASTRO DE PRODUTO", style = TextStyle(fontSize = 30.sp, fontWeight = FontWeight.Thin))

        Divider(thickness = 2.dp, modifier = Modifier.padding(vertical = 8.dp))

        Spacer(modifier = Modifier.height(14.dp))

        TextField(value = nome, onValueChange = {nome = it}, label = { Text("Nome") })
        TextField(value = categoria, onValueChange = {categoria = it}, label = { Text("Categoria") })
        TextField(value = preco, onValueChange = {preco = it.filter { it.isDigit() }}, label = { Text("Preço") }, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number))
        TextField(value = qntEstoque, onValueChange = {qntEstoque = it.filter { it.isDigit() }}, label = { Text("Quantidade") }, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number))

        Button(onClick = {
            try {
                val newProduto = Estoque(nome = nome, categoria = categoria, preco = preco.toDouble(), qntEstoque = qntEstoque.toInt())
                Estoque.adicionarProduto(context, newProduto)
            }
            catch (e: Exception) {
                Toast.makeText(context, "Erro ao cadastrar produto!", Toast.LENGTH_SHORT).show()
            }

            navController.popBackStack()
            },
            modifier = Modifier.fillMaxWidth().padding(horizontal = 40.dp, vertical = 10.dp)) {
            Text(text = "Cadastrar", style = TextStyle(fontWeight = FontWeight.Bold))
        }
    }
}

@Composable
@Preview(showBackground = true)
fun CadastroScreenPreview() {
    CadastroScreen(navController = rememberNavController())
}