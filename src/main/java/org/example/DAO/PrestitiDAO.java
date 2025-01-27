package org.example.DAO;

import org.example.entities.Prestiti;
import org.example.entities.Utente;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.util.List;

public class PrestitiDAO {

    private EntityManager em;

    public PrestitiDAO(EntityManager em){
        this.em = em;
    }

    public void saveP(Prestiti prestiti){
        em.getTransaction().begin();
        em.persist(prestiti);
        em.getTransaction().commit();
    }

    public List<Prestiti> cercaPrestitiScadutiNonRestituiti(LocalDate data){
        return em.createQuery("SELECT element FROM Prestiti element WHERE element.dataRestituzionePrevista < :data AND p.dataRestituzioneEffettiva IS NULL",Prestiti.class).setParameter("data",data).getResultList();
    }

}
