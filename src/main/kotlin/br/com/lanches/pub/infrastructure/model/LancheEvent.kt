package br.com.lanches.pub.infrastructure.model

data class LancheEvent(
    val lanche: LancheDto,
    val operacao: Operacao
){
}

enum class Operacao(){
    CADASTRAR
}