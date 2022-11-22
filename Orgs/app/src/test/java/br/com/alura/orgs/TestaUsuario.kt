package br.com.alura.orgs

import br.com.alura.orgs.model.Usuario
import org.junit.Assert
import org.junit.Test

class TestaUsuario {

    @Test
    fun retornaVerdadeiroSeOsDadosDoUsuarioEstaoCertos(){
        val usuarioValido = Usuario(
            email = "fulano@gmail.com",
            senha = "766880",
            id = "teste"
        )

        val ehValido = usuarioValido.ehValido()
        Assert.assertTrue(ehValido)
    }

    @Test
    fun returnFalseifUserisInvalid(){
        val usuarioInvalido =Usuario(
            "invalido",
            "jsakdhks",
        "97"
        )

        val ehValido = usuarioInvalido.ehValido()
        Assert.assertFalse(ehValido)
    }
}
