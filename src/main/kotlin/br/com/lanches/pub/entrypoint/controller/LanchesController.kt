package br.com.lanches.pub.entrypoint.controller

import br.com.lanches.pub.core.mapper.Convert
import br.com.lanches.pub.core.port.EntrypointServicePort
import br.com.lanches.pub.entrypoint.dto.LancheRequestDto
import io.micronaut.http.HttpResponse
import io.micronaut.http.MutableHttpResponse
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import io.micronaut.validation.Validated
import org.slf4j.LoggerFactory
import javax.validation.Valid

@Controller("lanches")
@Validated
class LanchesController(private val lancheServicePort: EntrypointServicePort) {

    private val logger = LoggerFactory.getLogger(this::class.java)

    @Post
    fun salvaLanche(@Body @Valid form: LancheRequestDto): MutableHttpResponse<LancheRequestDto>? {
        logger.info("\nValores Receboidos do CLient : $form")
        lancheServicePort.salvarLanche(Convert.lancheRequestDtoToLanche(form))
        return HttpResponse.created(form)
    }


}