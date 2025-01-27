package org.example.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "libri")
public class Libri extends ElementoCatalogo {

    @Column(name = "autore",nullable = false)
     private String autore;
    @Column(name = "genere",nullable = true)
     private String genere;

    public Libri(String titolo, int annoPubblicazione, int numeroPagine, String autore, String genere){
        super(titolo,annoPubblicazione,numeroPagine);
        this.autore = autore;
        this.genere = genere;
    }

    public Libri(){

    }

    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }

    @Override
    public String toString(){
        return super.toString() + " " + "Autore: " + autore + " " + "Genere: " + genere;
    }
}
