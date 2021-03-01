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
        conta.setTitular("Márcia");
        conta.setNumero(new Long(12345));
        conta.setAgencia(new Long(54321));
        conta.setSaldo(100.0);

        em.getTransaction().begin();
        em.persist(conta);
        em.getTransaction().commit();
        em.close();
        //Objeto se tornou DETACHED

        EntityManager em2 = emf.createEntityManager();
        System.out.println("Id da conta da Márcia -> " + conta.getId());
        conta.setSaldo(500.0);

        //Passando um objeto novamente de DETACHED para MANAGED
        em2.getTransaction().begin();
        em2.merge(conta);
        em2.getTransaction().commit();

    }
}
