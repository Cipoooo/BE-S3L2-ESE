package org.example.entities;


import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "elemento_del_catalogo")
public abstract class ElementoCatalogo {

    @Id
    @GeneratedValue
    private String isbn;
    @Column(name = "titolo", nullable = false)
    private String titolo;
    @Column(name = "Anno di Pubblicazione",nullable = false)
    private int annoPubblicazione;
    @Column(name = "Numero di Pagine Tot", nullable = false)
    private int numeroPagine;

    public ElementoCatalogo(String titolo, int annoPubblicazione, int numeroPagine){
        this.titolo = titolo;
        this.annoPubblicazione = annoPubblicazione;
        this.numeroPagine = numeroPagine;
    }

    public ElementoCatalogo(){

    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public int getAnnoPubblicazione() {
        return annoPubblicazione;
    }

    public void setAnnoPubblicazione(int annoPubblicazione) {
        this.annoPubblicazione = annoPubblicazione;
    }

    public int getNumeroPagine() {
        return numeroPagine;
    }

    public void setNumeroPagine(int numeroPagine) {
        this.numeroPagine = numeroPagine;
    }
}
