package br.com.lanches.pub.infrastructure.broker.nats

import br.com.lanches.pub.infrastructure.model.LancheEvent
import io.micronaut.nats.annotation.NatsClient
import io.micronaut.nats.annotation.Subject

@NatsClient
interface LancheClient {

    @Subject("channel.lanche")
    fun enviarLanche(lancheEvent: LancheEvent)

}