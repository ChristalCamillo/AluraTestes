package br.com.alura.orgs.database.repository

import br.com.alura.orgs.database.dao.ProdutoDao
import br.com.alura.orgs.model.Produto
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Test

class ProdutoRepositoryTests {
    @Test
    fun `deve chamar o dao quando salva um produto`() = runTest {
        //Arrange - Config
        val dao = mockk<ProdutoDao>()
        val produtoRepository = ProdutoRepository(dao)
        val produto = Produto(
            nome = "Banana",
            descricao = "Banana prata",
            valor = java.math.BigDecimal("6.99")
        )

        coEvery {
            dao.salva(produto)
        }.returns(Unit)
        //Act
        produtoRepository.salva(produto)

        coVerify {
            dao.salva(produto)
        }
    }
}