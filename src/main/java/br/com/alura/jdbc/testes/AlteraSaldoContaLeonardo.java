package br.com.alura.jdbc.testes;

import br.com.alura.jdbc.modelo.Conta;
import net.bytebuddy.implementation.bind.MethodDelegationBinder;
import org.hibernate.Transaction;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class AlteraSaldoContaLeonardo {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
        EntityManager em = emf.createEntityManager();

        Conta contaLeonardo = em.find(Conta.class,1L);

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        contaLeonardo.setSaldo(20.0);
        transaction.commit();

        System.out.println("Conta do Leonardo -> " + contaLeonardo.getTitular() + ". Saldo -> " + contaLeonardo.getSaldo());
    }
}
