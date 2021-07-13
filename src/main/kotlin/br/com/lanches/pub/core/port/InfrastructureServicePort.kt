package br.com.lanches.pub.core.port

import br.com.lanches.pub.infrastructure.model.LancheEvent
import javax.inject.Singleton

@Singleton
interface InfrastructureServicePort {
    fun enviarLanche(lancheEvent: LancheEvent)
}