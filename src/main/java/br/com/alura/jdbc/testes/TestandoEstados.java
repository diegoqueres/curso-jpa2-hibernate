package br.com.alura.jdbc.testes;

import br.com.alura.jdbc.modelo.Conta;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestandoEstados {
    public static void main(String[] args) {
        //Estado TRANSIENT
        Conta conta = new Conta();
        conta.setTitular("Almiro");
        conta.setAgencia(12123L);
        conta.setNumero(12344566L);

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        //TRANSIENT -> MANAGED
        em.persist(conta);

        //MANAGED -> REMOVED
        em.remove(conta);

        em.getTransaction().commit();

    }
}
