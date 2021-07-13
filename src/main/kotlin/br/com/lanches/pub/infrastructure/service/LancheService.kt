package br.com.lanches.pub.infrastructure.service

import br.com.lanches.pub.core.port.InfrastructureServicePort
import br.com.lanches.pub.infrastructure.broker.nats.LancheClient
import br.com.lanches.pub.infrastructure.model.LancheEvent
import org.slf4j.LoggerFactory
import javax.inject.Singleton

@Singleton
class LancheService(val lancheClient: LancheClient): InfrastructureServicePort {

    private val logger = LoggerFactory.getLogger(this::class.java)

    override fun enviarLanche(lancheEvent: LancheEvent) {
        logger.info("\ninfrasctructure/service : $lancheClient")
        lancheClient.enviarLanche(lancheEvent)
    }

}