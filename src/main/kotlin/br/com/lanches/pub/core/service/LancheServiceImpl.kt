package br.com.lanches.pub.core.service

import br.com.lanches.pub.core.mapper.Convert
import br.com.lanches.pub.core.model.Lanche
import br.com.lanches.pub.core.port.EntrypointServicePort
import br.com.lanches.pub.core.port.InfrastructureServicePort
import br.com.lanches.pub.infrastructure.model.Operacao
import org.slf4j.LoggerFactory
import java.util.*
import javax.inject.Singleton

@Singleton
class LancheServiceImpl(val infraServicePort: InfrastructureServicePort): EntrypointServicePort {

    private val logger = LoggerFactory.getLogger(this::class.java)

    override fun salvarLanche(lanche: Lanche) {
        logger.info("\ncore/service : ${lanche}")
        infraServicePort.enviarLanche(Convert.lancheToLancheEvent(lanche,Operacao.CADASTRAR))
    }

    override fun atualizarLanche(idLanche: UUID,lancheAtualizado: Lanche) {
        logger.info("\ncore/service: $lancheAtualizado, $idLanche")
        val lancheEvent = Convert.lancheToLancheEvent(lancheAtualizado,Operacao.ATUALIZAR)
        lancheEvent.lanche.id = idLanche
        infraServicePort.enviarLanche(lancheEvent)
    }

}