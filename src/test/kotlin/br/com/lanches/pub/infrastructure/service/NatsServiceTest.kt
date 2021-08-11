package br.com.lanches.pub.infrastructure.service

import br.com.lanches.pub.infrastructure.broker.nats.LancheClient
import br.com.lanches.pub.infrastructure.model.LancheDto
import br.com.lanches.pub.infrastructure.model.LancheEvent
import br.com.lanches.pub.infrastructure.model.Operacao
import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import io.mockk.every
import io.mockk.mockk
import java.util.*

@MicronautTest
class NatsServiceTest: AnnotationSpec() {

    private val lancheClient = mockk<LancheClient>()
    private val natsService = NatsService(lancheClient)

    @Test
    fun `deve enviar lanche para o Nats`(){
        //cenario
        every { lancheClient.enviarLanche(any()) } answers {}
        //acao
        val resposta = natsService.enviarLanche(LancheEvent(LancheDto("X-TUdo","Tudo",10.00, UUID.randomUUID()), Operacao.CADASTRAR))
        //validacao
        resposta shouldBe Unit

    }


}