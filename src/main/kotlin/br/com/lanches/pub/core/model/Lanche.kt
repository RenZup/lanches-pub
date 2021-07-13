package br.com.lanches.pub.core.model

import io.micronaut.core.annotation.Introspected

@Introspected
data class Lanche(
    var nome: String,
    var ingredientes: String,
    var preco: Double
)