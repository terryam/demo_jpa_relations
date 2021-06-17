package fr.diginamic.entites;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "LIVRE")

public class Livre {
    @Id
    int id;
    private String titre;
    private String auteur;


    /**
     * Relations
     */
    // Relation livre_client  1-n
    @ManyToMany
    @JoinTable(name = "ID_LIV",
            joinColumns = @JoinColumn(name = "ID_LIV", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "ID_CLIENT",referencedColumnName = "ID" )
    )
    private Set<Client> clients;

    // Relation livre_emprunt  1-n @ManyToMany
    @ManyToMany
    @JoinTable(name = "ID_LIV",
            joinColumns = @JoinColumn(name = "ID_LIV", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "ID_EMP",referencedColumnName = "ID" )
    )
    private Set<Emprunt> emprunts;

    /**
     * Constructeur vide
     */
    public Livre() {

    }

    /**
     * Constructeur
     * @param id
     * @param titre
     * @param auteur
     */
    public Livre(int id, String titre, String auteur) {
        this.id = id;
        this.titre = titre;
        this.auteur = auteur;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public Set<Client> getClients() {
        return clients;
    }

    public void setClients(Set<Client> clients) {
        this.clients = clients;
    }

    public Set<Emprunt> getEmprunts() {
        return emprunts;
    }

    public void setEmprunts(Set<Emprunt> emprunts) {
        this.emprunts = emprunts;
    }
}
