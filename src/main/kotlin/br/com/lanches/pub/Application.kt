package br.com.lanches.pub

import io.micronaut.runtime.Micronaut.*
fun main(args: Array<String>) {
	build()
	    .args(*args)
		.packages("br.com.lanches.pub")
		.start()
}

