package br.com.lanches.pub.entrypoint.controller

import br.com.lanches.pub.core.port.EntrypointServicePort
import br.com.lanches.pub.entrypoint.controller.LanchesController
import br.com.lanches.pub.entrypoint.dto.LancheRequestDto
import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.should
import io.kotest.matchers.shouldBe
import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpStatus
import io.micronaut.http.MutableHttpResponse
import io.micronaut.test.extensions.kotest.annotation.MicronautTest
import io.mockk.every
import io.mockk.mockk
import java.util.*

@MicronautTest
class LanchesControllerTest: AnnotationSpec() {


    //private val port = mockk<EntrypointServicePort>()
  //  private val controller = LanchesController(port)
    lateinit var  port: EntrypointServicePort
    lateinit var  controller: LanchesController

    @BeforeEach
    fun setup(){
        port = mockk<EntrypointServicePort>()
        controller = LanchesController(port)
    }
    @Test
    fun `deve cadastrar um lanche`(){
        //cenario
        every { port.salvarLanche(any()) } answers {}
        //acao
        val form = LancheRequestDto("X-Tudo", "Tudo", 9.90)
        val resposta = controller.salvaLanche(form)
        //validacao
        resposta.status shouldBe HttpStatus.CREATED
    }
     @Test
    fun `deve atualizar um lanche`(){
        //cenario
        every{port.atualizarLanche(any(),any())} answers {}
        //acao
        val resposta = controller.atualizarLanche(UUID.randomUUID(), LancheRequestDto("X","x sem tudo",1.0))
        //validacao
        resposta.status shouldBe HttpStatus.OK
    }
    @Test
    fun `deve deletar um lanche`(){
        //cenario
        every { port.deletarLanche(any()) } answers {}
        //acao
        val resposta = controller.deletarLanche(UUID.randomUUID())
        //validacao
        resposta.status shouldBe HttpStatus.OK
    }
}