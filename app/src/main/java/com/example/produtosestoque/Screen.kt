package com.example.produtosestoque

const val DETALHES_ARGUMENT_NOME = "nome"
const val DETALHES_ARGUMENT_CATEGORIA = "categoria"
const val DETALHES_ARGUMENT_PRECO = "preco"
const val DETALHES_ARGUMENT_QNTESTOQUE = "qntEstoque"

sealed class Screen(val route: String) {
    object Cadastro_Produto: Screen(route = "cadastro_screen")
    object Lista_Produto: Screen(route = "lista_screen")
    object Detalhes_Produto: Screen(route = "detalhes_screen/{$DETALHES_ARGUMENT_NOME}/{$DETALHES_ARGUMENT_CATEGORIA}/{$DETALHES_ARGUMENT_PRECO}/{$DETALHES_ARGUMENT_QNTESTOQUE}") {
        fun passArguments(nome: String, categoria: String, preco: Double, qntEstoque: Int) : String {
            return "detalhes_screen/$nome/$categoria/$preco/$qntEstoque"
        }
    }
    object Estatisticas_Produto: Screen(route = "estatisticas_screen")
}