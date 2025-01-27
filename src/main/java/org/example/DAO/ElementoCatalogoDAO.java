package org.example.DAO;

import org.example.entities.ElementoCatalogo;
import org.example.entities.Libri;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class ElementoCatalogoDAO {

    private EntityManager em;

    public ElementoCatalogoDAO(EntityManager em){
        this.em = em;
    }

    public void saveEC(ElementoCatalogo elementoCatalogo){
       em.getTransaction().begin();
       em.persist(elementoCatalogo);
       em.getTransaction().commit();
    }

    public void removeEC(String isbn){
        em.getTransaction().begin();
        Query query = em.createQuery("DELETE FROM ElementoCatalogo element WHERE element.isbn = :isbn");
        query.setParameter("isbn",isbn);
        query.executeUpdate();
        em.getTransaction().commit();
    }

    public ElementoCatalogo cercaPerISBN(String isbn){
        return em.createQuery("SELECT elwmwnt FROM ElementoCatalogo element WHERE element.isbn = :isbn",ElementoCatalogo.class).setParameter("isbn",isbn).getSingleResult();
    }

    public List<ElementoCatalogo> cercaPerAnnoPubblicazioen(int annoPubblicazione){
        return em.createQuery("SELECT element FROM ElementoCatalogo element WHERE element.annoPubblicazione = :annoPubblicazione", ElementoCatalogo.class).setParameter("annoPubblicazione", annoPubblicazione).getResultList();
    }

    public List<Libri> cercaPerAutore(String autore){
        return em.createQuery("SELECT element FROM Libri element WHERE element.autore = :autore",Libri.class).setParameter("autore",autore).getResultList();
    }

    public List<ElementoCatalogo> cercaPerTitolo(String titolo){
        return em.createQuery("SELECT element FROM ElementoCatalogo element WHERE element.titolo = :titolo",ElementoCatalogo.class).setParameter("titolo",titolo).getResultList();
    }

}
