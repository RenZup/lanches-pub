package br.com.lanches.pub.core.service

import br.com.lanches.pub.core.model.Lanche
import br.com.lanches.pub.core.port.InfrastructureServicePort
import br.com.lanches.pub.core.service.LancheServiceImpl
import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe
import io.micronaut.test.extensions.kotest.annotation.MicronautTest
import io.mockk.every
import io.mockk.mockk
import java.util.*

@MicronautTest
class LancheServiceTest: AnnotationSpec() {

    private val infraServicePort = mockk<InfrastructureServicePort>()
    private val lancheServiceImpl = LancheServiceImpl(infraServicePort)

    @Test
    fun `deve chamar a funcao salvarLanche`(){
        //cenario
        every { infraServicePort.enviarLanche(any()) } answers {}
        //acao
        val resposta= lancheServiceImpl.salvarLanche(Lanche("X-Tudo","Tudo",10.00))
        //validacao
        resposta shouldBe Unit //faz sentido validar isso ?
    }
    @Test
    fun`deve chamar a funcao atualizarLanche`(){
        //cenario
        every { infraServicePort.enviarLanche(any()) } answers {}
        //acao
        val resposta= lancheServiceImpl.atualizarLanche(UUID.randomUUID(),Lanche("X-Tudo","Tudo",10.00))
        //validacao
        resposta shouldBe Unit
    }
    @Test
    fun`deve chamar a funcao deletarLanche`(){
        //cenario
        every { infraServicePort.enviarLanche(any()) } answers {}
        //acao
        val resposta= lancheServiceImpl.deletarLanche(UUID.randomUUID())
        //validacao
        resposta shouldBe Unit
    }







}