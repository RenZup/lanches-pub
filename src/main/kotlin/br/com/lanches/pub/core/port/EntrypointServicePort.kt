package br.com.lanches.pub.core.port

import br.com.lanches.pub.core.model.Lanche
import javax.inject.Singleton

@Singleton
interface EntrypointServicePort {
    fun salvarLanche(lanche: Lanche)
}
