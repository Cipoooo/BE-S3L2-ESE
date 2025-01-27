package org.example.entities;

import org.example.DAO.ElementoCatalogoDAO;
import org.example.DAO.PrestitiDAO;
import org.example.DAO.UtenteDAO;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.util.List;

public class Archivio {

    private static ElementoCatalogoDAO elementoCatalogoDAO;
    private static PrestitiDAO prestitiDAO;
    private static UtenteDAO utenteDAO;

    public static void init(EntityManager em){
        elementoCatalogoDAO = new ElementoCatalogoDAO(em);
        utenteDAO = new UtenteDAO(em);
        prestitiDAO = new PrestitiDAO(em);
    }

    public static void aggiungiElemento(ElementoCatalogo elemento){
      elementoCatalogoDAO.saveEC(elemento);
    }

    public static void aggiungiUtente(Utente utente){
        utenteDAO.saveU(utente);
    }

    public static void aggiungiPrestito(Prestiti prestiti){
        prestitiDAO.saveP(prestiti);
    }

    public static void rimuoviElementoPerISBN(String isbn){
        elementoCatalogoDAO.removeEC(isbn);
    }

    public static ElementoCatalogo ricercaPerISBN(String isbn){
        return elementoCatalogoDAO.cercaPerISBN(isbn);
    }

    public static List<ElementoCatalogo> ricercaPerAnnoDiPubblicazione(int annoPubblicazione){
        return elementoCatalogoDAO.cercaPerAnnoPubblicazioen(annoPubblicazione);
    }

    public static List<Libri> ricercaPerAutore(String autore){
        return elementoCatalogoDAO.cercaPerAutore(autore);
    }

    public static List<ElementoCatalogo> ricercaPerTitolo(String titolo){
        return elementoCatalogoDAO.cercaPerTitolo(titolo);
    }

    public static List<Prestiti> ricercaPerPrestitiScadutiNonRestituiti(LocalDate data){
        return prestitiDAO.cercaPrestitiScadutiNonRestituiti(data);
    }


}
