package br.com.alura.orgs

import br.com.alura.orgs.model.Produto
import org.junit.Assert
import org.junit.Test
import java.math.BigDecimal

class ProdutoTeste {

    @Test
    fun aoCriarUmProdutoComValorCertoOValorDeveSerValido(){
        val produtoValido = Produto(
            nome = "Banana",
            descricao = "prata",
            valor = BigDecimal("6.99")
        )

        val valorValido = produtoValido.valorValido

        Assert.assertEquals(true, valorValido)
    }

    @Test
    fun seOValorForMaiorQueCemTrowError(){
        //Arrange - Arrumar, vamos criar um produto invalido
        val produtoInvalido = Produto(
            nome = "Invalido",
            descricao = "iwdil",
            valor = BigDecimal(105)
        )

        // Act - Ação do teste

        val valorValido = produtoInvalido.valorValido

        //Assert
        Assert.assertEquals(false, valorValido)
    }
}