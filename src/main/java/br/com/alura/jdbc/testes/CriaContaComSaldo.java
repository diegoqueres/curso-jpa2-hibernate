package br.com.alura.jdbc.testes;

import br.com.alura.jdbc.modelo.Conta;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CriaContaComSaldo {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
        EntityManager em = emf.createEntityManager();

        Conta conta = new Conta();
        conta.setTitular("Juliano");
        conta.setNumero(new Long(12345));
        conta.setAgencia(new Long(54321));
        conta.setSaldo(500.0);

        em.getTransaction().begin();
        em.persist(conta);
        em.getTransaction().commit();
    }
}
