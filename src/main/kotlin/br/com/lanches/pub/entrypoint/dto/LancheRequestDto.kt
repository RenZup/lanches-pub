package br.com.lanches.pub.entrypoint.dto

import io.micronaut.core.annotation.Introspected
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

@Introspected
data class LancheRequestDto(
    @field:NotBlank
    val nome: String,
    @field:NotBlank
    val ingredientes: String,
    @field:NotNull
    val preco: Double
)
