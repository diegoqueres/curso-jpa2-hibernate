package br.com.alura.jdbc.testes;

import br.com.alura.jdbc.modelo.Categoria;
import br.com.alura.jdbc.modelo.Conta;
import br.com.alura.jdbc.modelo.Movimentacao;
import br.com.alura.jdbc.modelo.TipoMovimentacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;

public class TestaRelacionamentoMovimentacaoCategoria {
    public static void main(String[] args) {
        Categoria categoria = new Categoria("Viagem");
        Categoria categoria2 = new Categoria("Negócios");

        Conta conta = new Conta();
        conta.setId(2L);

        Movimentacao movimentacao = new Movimentacao();
        movimentacao.setDescricao("Viagem a SP");
        movimentacao.setTipoMovimentacao(TipoMovimentacao.SAIDA);
        movimentacao.setData(LocalDateTime.now());
        movimentacao.setValor(new BigDecimal(300));
        movimentacao.setCategorias(Arrays.asList(categoria, categoria2));
        movimentacao.setConta(conta);

        Movimentacao movimentacao2 = new Movimentacao();
        movimentacao2.setDescricao("Viagem a RJ");
        movimentacao2.setTipoMovimentacao(TipoMovimentacao.SAIDA);
        movimentacao2.setData(LocalDateTime.now());
        movimentacao2.setValor(new BigDecimal(400));
        movimentacao2.setCategorias(Arrays.asList(categoria, categoria2));
        movimentacao2.setConta(conta);

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.persist(categoria);
        em.persist(categoria2);
        em.persist(movimentacao);
        em.persist(movimentacao2);
        em.getTransaction().commit();


    }
}
