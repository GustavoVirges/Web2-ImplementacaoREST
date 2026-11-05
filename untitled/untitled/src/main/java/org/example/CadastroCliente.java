package org.example;

import javax.persistence.*;

public class CadastroCliente {
    public static void main(String... args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Clientes-PU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Cliente cliente = new Cliente();
        cliente.setNome("Armazém Feliz");

        entityManager.getTransaction().begin();
        entityManager.persist(cliente);
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();
    }
}
