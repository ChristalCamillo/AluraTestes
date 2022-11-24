package br.com.alura.orgs

import br.com.alura.orgs.model.Produto
import org.amshove.kluent.shouldBeFalse
import org.amshove.kluent.shouldBeTrue
import org.junit.Test
import java.math.BigDecimal

class ProdutoTeste {

    @Test
    fun `deve retornar verdadeiro quando o valor for valido`() {
        val produtoValido = Produto(
            nome = "Banana",
            descricao = "Banana prata",
            valor = BigDecimal("6.99")
        )

        val valorValido = produtoValido.valorValido

        valorValido.shouldBeTrue()
    }

    @Test
    fun `deve retornar falso quando o valor for maior que cem`() {
        //Arrange - Arrumar
        val produtoInvalido = Produto(
            nome = "Carambola",
            descricao = "Amarela",
            valor = BigDecimal("105.99")
        )

        //Act - Agir
        val valorValido = produtoInvalido.valorValido

        //Assert - Afirme
        valorValido.shouldBeFalse()
    }

    @Test
    fun `deve retornar falso quando o valor for menor ou igual a zero`() {
        val produtoComValorIgualAZero = Produto(
            nome = "Lichia",
            descricao = "Doce",
            valor = BigDecimal("0")
        )
        val produtoComValorMenorQueZero = Produto(
            nome = "Uva",
            descricao = "Thompson",
            valor = BigDecimal("-10.99")
        )

        val valorIgualAZeroEhValido = produtoComValorIgualAZero.valorValido
        val valorMenorQueZeroEhValido = produtoComValorMenorQueZero.valorValido

        valorIgualAZeroEhValido.shouldBeFalse()
        valorMenorQueZeroEhValido.shouldBeFalse()
    }
}
