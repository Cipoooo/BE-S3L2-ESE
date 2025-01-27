package org.example.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "Prestiti")
public class Prestiti {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_utente", nullable = false)
    private Utente utente;

    @ManyToMany
    @JoinTable(
            name = "prestito_elementi",
            joinColumns = @JoinColumn(name = "prestito_id"),
            inverseJoinColumns = @JoinColumn(name = "ele_cat_isbn")
    )
    private List<ElementoCatalogo> elementiPrestati;

    @Column(name = "data_inizio_prestito", nullable = false)
    private LocalDate dataInizioPrestito;
    @Column(name = "data_restituzione_prevista", nullable = false)
    private LocalDate dataRestituzionePrevista;
    @Column(name = "data_restituzione_effettiva",nullable = false)
    private LocalDate dataRestituzioneEffettiva;

    public Prestiti(){}

    public Prestiti(Utente utente, List<ElementoCatalogo> elementiPrestati, LocalDate dataInizioPrestito, LocalDate dataRestituzionePrevista, LocalDate dataRestituzioneEffettiva){
     this.utente = utente;
     this.elementiPrestati = elementiPrestati;
     this.dataInizioPrestito = dataInizioPrestito;
     this.dataRestituzionePrevista = dataRestituzionePrevista;
     this.dataRestituzioneEffettiva = dataRestituzioneEffettiva;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public List<ElementoCatalogo> getElementiPrestati() {
        return elementiPrestati;
    }

    public void setElementiPrestati(List<ElementoCatalogo> elementiPrestati) {
        this.elementiPrestati = elementiPrestati;
    }

    public LocalDate getDataInizioPrestito() {
        return dataInizioPrestito;
    }

    public void setDataInizioPrestito(LocalDate dataInizioPrestito) {
        this.dataInizioPrestito = dataInizioPrestito;
    }

    public LocalDate getDataRestituzionePrevista() {
        return dataRestituzionePrevista;
    }

    public void setDataRestituzionePrevista(LocalDate dataRestituzionePrevista) {
        this.dataRestituzionePrevista = dataRestituzionePrevista;
    }

    public LocalDate getDataRestituzioneEffettiva() {
        return dataRestituzioneEffettiva;
    }

    public void setDataRestituzioneEffettiva(LocalDate dataRestituzioneEffettiva) {
        this.dataRestituzioneEffettiva = dataRestituzioneEffettiva;
    }

    @Override
    public String toString(){
        return "id" + id + " " + "Utente: " + utente + " " + "elementiPrestati" + elementiPrestati + " " + "Inizio Prestito" + dataInizioPrestito + " " + "Prestito aspettato: " + dataRestituzionePrevista + " " + "Restituzione Prestito" + dataRestituzioneEffettiva;
    }
}
