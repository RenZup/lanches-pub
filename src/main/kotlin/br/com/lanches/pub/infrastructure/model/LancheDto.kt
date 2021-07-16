package br.com.lanches.pub.infrastructure.model

import io.micronaut.core.annotation.Introspected
import java.util.*

@Introspected
data class LancheDto(
    var nome: String,
    var ingredientes: String,
    var preco: Double,
    val id: UUID? = null
)