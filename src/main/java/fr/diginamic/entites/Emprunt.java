package fr.diginamic.entites;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "EMPRUNT")
public class Emprunt {
    @Id
    int id;
    @Column(name = "DATE_DEBUT")
    LocalDate dateDebut;

    @Column(name = "DATE_FIN")
    LocalDate dateFin;


    int delai;

    /**
     * Relations
     */

    // Relation emprunt_client 1-1__1-n, relation ManyToOne
    @ManyToOne
    @JoinColumn(name = "ID_CLIENT")
    private Client clients;

    // Relation emprunt_livre  1-n
    @ManyToMany
    @JoinTable(name = "compo",
            joinColumns = @JoinColumn(name = "ID_EMP", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "ID_LIV",referencedColumnName = "ID" )
    )
    private Set<Livre> livres;

    /**
     * Constructeur par defaut
     */
    public Emprunt() {
    }

    /**
     * Constructeur
     * @param id
     * @param dateDebut
     * @param dateFin
     * @param delai
     */
    public Emprunt(int id, LocalDate dateDebut, LocalDate dateFin, int delai) {
        this.id = id;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.delai = delai;
    }

    /**
     * Getters and Setters
     */

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(LocalDate dateDebut) {
        this.dateDebut = dateDebut;
    }

    public LocalDate getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }

    public int getDelai() {
        return delai;
    }

    public void setDelai(int delai) {
        this.delai = delai;
    }


    public Client getClients() {
        return clients;
    }

    public void setClients(Client clients) {
        this.clients = clients;
    }

    public Set<Livre> getLivres() {
        return livres;
    }

    public void setLivres(Set<Livre> livres) {
        this.livres = livres;
    }
}
