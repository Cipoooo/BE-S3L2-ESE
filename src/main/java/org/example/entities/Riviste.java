package org.example.entities;

import javax.persistence.*;

@Entity
@Table(name = "riviste")
public class Riviste extends ElementoCatalogo{

    @Enumerated(EnumType.STRING)
    @Column(name = "periodicità", nullable = false)
    private Periodicita periodicita;

    public Riviste(String titolo, int annoPubblicazione, int numeroPagine, Periodicita periodicita){
           super(titolo,annoPubblicazione,numeroPagine);
           this.periodicita = periodicita;
    }
    public Riviste(){

    }

    public enum Periodicita{
        SETTIMANALE,
        MENSILE,
        SEMESTRALE
    }

    public Periodicita getPeriodicita() {
        return periodicita;
    }

    public void setPeriodicita(Periodicita periodicita) {
        this.periodicita = periodicita;
    }
}
