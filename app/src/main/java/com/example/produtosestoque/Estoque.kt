package com.example.produtosestoque

import android.content.Context
import android.widget.Toast

data class Estoque(
    val nome: String,
    val categoria: String,
    val preco: Double,
    var qntEstoque: Int
) {
    companion object {
        private val produtos = mutableListOf<Estoque>()

        fun adicionarProduto(context: Context, produto: Estoque) {
            if (produto.nome.isNotBlank() && produto.categoria.isNotBlank() &&
                produto.preco > 0 && produto.qntEstoque >= 0) {
                produtos.add(produto)
            } else {
                val mensagemErro = when {
                    produto.nome.isBlank() -> "Nome do produto não pode ser vazio."
                    produto.categoria.isBlank() -> "Categoria do produto não pode ser vazia."
                    produto.preco <= 0 -> "Preço deve ser maior que zero."
                    produto.qntEstoque < 0 -> "Quantidade em estoque não pode ser negativa."
                    else -> "Erro ao adicionar o produto."
                }
                Toast.makeText(context, mensagemErro, Toast.LENGTH_SHORT).show()
            }
        }

        fun calcularQuantidadeTotal(): Int {
            return produtos.sumOf { it.qntEstoque }
        }

        fun calcularValorTotalEstoque(): Double {
            return produtos.sumOf { it.preco * it.qntEstoque }
        }

        fun listarProdutos(): List<Estoque> {
            return produtos
        }
    }
}
