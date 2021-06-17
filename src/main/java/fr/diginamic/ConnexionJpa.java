package fr.diginamic;


import fr.diginamic.entites.Fournisseur;

import javax.persistence.*;
import java.sql.SQLOutput;

public class ConnexionJpa {
    public static void main(String[] args) {
        /**
         * Créer la connexion à la bdd
         */
        EntityManagerFactory firstJpa = Persistence.createEntityManagerFactory("compta");
        EntityManager manage = firstJpa.createEntityManager();

        EntityTransaction transaction = manage.getTransaction();
        transaction.begin();

        /**
         * Extraire un fournisseur
         */
        Fournisseur fournisseur = manage.find(Fournisseur.class, 2);
        if (fournisseur != null) {
            System.out.println( fournisseur.getNom());
        }

        /**
         * Insérer un nouveau fournisseur dans la bdd
         */
        Fournisseur nouveauFournisseur = new Fournisseur(4,"L'île de beauté");
        manage.persist(nouveauFournisseur);
        System.out.println(nouveauFournisseur);


        transaction.commit();

        manage.close();

    }
}
