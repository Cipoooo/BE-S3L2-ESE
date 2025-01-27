package org.example.DAO;

import org.example.entities.Utente;

import javax.persistence.EntityManager;

public class UtenteDAO {

    private EntityManager em;

    public UtenteDAO(EntityManager em){
        this.em = em;
    }

    public void saveU(Utente utente){
        em.getTransaction().begin();
        em.persist(utente);
        em.getTransaction().commit();
    }

    public Utente cercaUtenteTramiteTessera(String numeroTessera){
        return em.createQuery("SELECT element FROM Utente element WHERE element.numeroTessera 0 :numeroTessera", Utente.class).setParameter("numeroTessera",numeroTessera).getSingleResult();
    }


}
