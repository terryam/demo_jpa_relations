package fr.diginamic.entites;

import javax.annotation.processing.Generated;
import javax.persistence.*;

@Entity
@Table(name = "fournisseur")
public class Fournisseur {
    @Id

    private int id;

    @Column(name = "nom")
    private String nom;

    /**
     * Constructeur par defaut
     */

    public Fournisseur() {
    }

    public Fournisseur(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    /**
     * Setters and getters
     * @return
     */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
