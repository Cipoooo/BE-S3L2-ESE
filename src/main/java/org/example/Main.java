package org.example;

import org.example.entities.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("s3l5");
    private static EntityManager em = emf.createEntityManager();

    public static void main(String[] args){

        Archivio archivio = new Archivio();
        archivio.init(em);

        Libri l1 = new Libri("L' Arte della Guerra", 123,320,"Sun Tzu","Storico" );
        Libri l2 = new Libri("Harry Potter e La Pietra Filosofale", 1997,304, "Rowling","Fantasy");
        Libri l3 = new Libri("Harry Potter e La Camera dei Segreti",1998,272,"Rowling","fantasy");
        Libri l4 = new Libri("Harry Potter e Il prigioniero di Azkaban",1999,300,"Rowling","fantasy");
        Libri l5 = new Libri("Harry Potter e il Calice di Fuoco", 2000,330,"Rowling","Fantasy");

        Riviste r1 = new Riviste("Magazine1",2020,210, Riviste.Periodicita.SETTIMANALE);
        Riviste r2 = new Riviste("Magazine2",2021, 273, Riviste.Periodicita.SETTIMANALE);
        Riviste r3 = new Riviste("MAgazine3",2014,179, Riviste.Periodicita.MENSILE);
        Riviste r4 = new Riviste("MAgazine4",2018,364, Riviste.Periodicita.SEMESTRALE);
        Riviste r5 = new Riviste("Magazine5",2024,138, Riviste.Periodicita.SETTIMANALE);

        Utente u1 = new Utente("Gabriele", "Cipolloni", LocalDate.of(2004,11,19), "43628");
        Utente u2 = new Utente("Leopoldo", "Poldo", LocalDate.of(1999,7,31),"362727");
        Utente u3 = new Utente("Giorgio","Giorgetti",LocalDate.of(1968,3,30),"182291");
        Utente u4 = new Utente("Bruna","Brunelli",LocalDate.of(1969,2,28),"279273");
        Utente u5 = new Utente("Letizia","Letizietti",LocalDate.of(1934,3,27),"927341");

        archivio.aggiungiElemento(l1);
        archivio.aggiungiElemento(l2);
        archivio.aggiungiElemento(l3);
        archivio.aggiungiElemento(l4);
        archivio.aggiungiElemento(l5);

        archivio.aggiungiElemento(r1);
        archivio.aggiungiElemento(r2);
        archivio.aggiungiElemento(r3);
        archivio.aggiungiElemento(r4);
        archivio.aggiungiElemento(r5);

        archivio.aggiungiUtente(u1);
        archivio.aggiungiUtente(u2);
        archivio.aggiungiUtente(u3);
        archivio.aggiungiUtente(u4);
        archivio.aggiungiUtente(u5);

        List<ElementoCatalogo> listaP1 = new ArrayList<>();
        listaP1.add(l1);
        listaP1.add(r1);

        List<ElementoCatalogo> listaP2 = new ArrayList<>();
        listaP1.add(l2);
        listaP1.add(r2);

        List<ElementoCatalogo> listaP3 = new ArrayList<>();
        listaP1.add(l3);
        listaP1.add(r3);

        List<ElementoCatalogo> listaP4 = new ArrayList<>();
        listaP1.add(l4);
        listaP1.add(r4);

        List<ElementoCatalogo> listaP5 = new ArrayList<>();
        listaP1.add(l5);
        listaP1.add(r5);


        Prestiti p1 = new Prestiti(u1,listaP1,LocalDate.of(2022,3,16),LocalDate.of(2023,10,18),LocalDate.of(2024,8,28));
        Prestiti p2 = new Prestiti(u2,listaP2,LocalDate.of(2016,7,29),LocalDate.of(2016,8,23),LocalDate.of(2016,8,15));
        Prestiti p3 = new Prestiti(u3,listaP3,LocalDate.of(2024, 3,18),LocalDate.of(2025,12,27),LocalDate.of(2025,1,23));
        Prestiti p4 = new Prestiti(u4,listaP4,LocalDate.of(2022,4,3),LocalDate.of(2022,5,13),LocalDate.of(2023,1,3));
        Prestiti p5 = new Prestiti(u5,listaP5,LocalDate.of(2025,1,1),LocalDate.of(2025,3,24),LocalDate.of(2025,1,26));

        archivio.aggiungiPrestito(p1);
        archivio.aggiungiPrestito(p2);
        archivio.aggiungiPrestito(p3);
        archivio.aggiungiPrestito(p4);
        archivio.aggiungiPrestito(p5);

        //TEST METODI

       /* System.out.println("Ricerca per ISBN:");
        ElementoCatalogo elemento = Archivio.ricercaPerISBN("1");
        System.out.println(elemento);*/

        System.out.println("\nRicerca per anno Pubblicazione: ");
        List<ElementoCatalogo> elementiAnooPubblicazione = Archivio.ricercaPerAnnoDiPubblicazione(1997);
        System.out.println(elementiAnooPubblicazione);

        /*System.out.println("\nRicerca Per autore: ");
        List<Libri> libriPerAut = Archivio.ricercaPerAutore("Rowling");
        System.out.println(libriPerAut);*7

        /*System.out.println("\nRicerca Per titolo: ");
        List<ElementoCatalogo> elementiPerTitolo = Archivio.ricercaPerTitolo("Magazine1");
        System.out.println(elementiPerTitolo);*/

        /*System.out.println("\nRimozione per ISBN: ");
        Archivio.rimuoviElementoPerISBN("3");
        System.out.println("Elemento Rimosso");*/
    }


}
