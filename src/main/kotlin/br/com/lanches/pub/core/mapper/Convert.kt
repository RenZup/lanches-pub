package br.com.lanches.pub.core.mapper

import br.com.lanches.pub.core.model.Lanche
import br.com.lanches.pub.entrypoint.dto.LancheRequestDto
import br.com.lanches.pub.infrastructure.model.LancheEvent

class Convert {
    companion object{
        fun lancheRequestDtoToLanche(dto: LancheRequestDto)=
            Lanche(dto.nome,dto.ingredientes,dto.preco)

        fun lancheToLancheEvent(lanche: Lanche) =
            LancheEvent(lanche.nome,lanche.ingredientes,lanche.preco)
//cometantario main
    }

}