package br.com.lanches.pub.core.port

import br.com.lanches.pub.core.model.Lanche
import java.util.*
import javax.inject.Singleton

@Singleton
interface EntrypointServicePort {
    fun salvarLanche(lanche: Lanche)
    fun atualizarLanche(idLanche: UUID, lancheAtualizado: Lanche)
    fun deletarLanche(idLanche: UUID)
}
