package br.com.alura.jdbc.testes;

import br.com.alura.jdbc.modelo.Conta;
import br.com.alura.jdbc.modelo.Movimentacao;

import javax.persistence.*;
import java.util.Arrays;
import java.util.List;

public class TesteJPQL {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
        EntityManager em = emf.createEntityManager();

        String jpql = "select m from Movimentacao m where m.conta = :pConta order by m.valor desc";

        Conta conta = new Conta();
        conta.setId(2L);
        TypedQuery<Movimentacao> query = em.createQuery(jpql, Movimentacao.class);
        query.setParameter("pConta", conta);
        List<Movimentacao> resultList = query.getResultList();

        for (Movimentacao movimentacao : resultList) {
            System.out.println("Descrição: " + movimentacao.getDescricao());
            System.out.println("Tipo: " + movimentacao.getTipoMovimentacao());
            System.out.println("Valor: " + movimentacao.getValor());
        }
    }
}
