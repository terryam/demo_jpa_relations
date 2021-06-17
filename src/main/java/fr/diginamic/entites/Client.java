package fr.diginamic.entites;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "CLIENT")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    /**
     * Relations
     */
    // Relation client_livre 1-n, relation ManyToMany
    @ManyToMany
    @JoinTable(name = "compo",
            joinColumns = @JoinColumn(name = "ID_CLIENT", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "ID_LIV",referencedColumnName = "ID" )
    )
    private Set<Livre> livres;

    // Relation client_emprunt 1-1__1-n, relation OneToMany
    @OneToMany(mappedBy = "clients")
    private Set<Emprunt> emprunts;

    String nom;
    String prenom;

    /**
     * Constructeur par defaut
     */

    public Client() {
    }

    /**
     * Constructeur rempli
     * @param id
     * @param nom
     * @param prenom
     */

    public Client(int id, String nom, String prenom) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
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

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prennom) {
        this.prenom = prenom;
    }



}
