package br.com.lanches.pub.core.service

import br.com.lanches.pub.core.mapper.Convert
import br.com.lanches.pub.core.model.Lanche
import br.com.lanches.pub.core.port.EntrypointServicePort
import br.com.lanches.pub.core.port.InfrastructureServicePort
import org.slf4j.LoggerFactory
import javax.inject.Singleton

@Singleton
class LancheServiceImpl(val infraServicePort: InfrastructureServicePort): EntrypointServicePort {

    private val logger = LoggerFactory.getLogger(this::class.java)

    override fun salvarLanche(lanche: Lanche) {
        logger.info("\ncore/service : ${lanche}")
        infraServicePort.enviarLanche(Convert.lancheToLancheEvent(lanche))
    }

}