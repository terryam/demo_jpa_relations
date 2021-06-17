package fr.diginamic;

import fr.diginamic.entites.Emprunt;
import fr.diginamic.entites.Livre;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class ConnexionJpaLivre {
    public static void main(String[] args) {
        /**
         * Connexion à la bdd
         */
        EntityManagerFactory biblioJpa = Persistence.createEntityManagerFactory("bibliotheque");
        EntityManager manage = biblioJpa.createEntityManager();

        EntityTransaction transaction = manage.getTransaction();
        transaction.begin();

        /**
         * Extraire un livre en fonction de son id
         */
        Livre livre = manage.find(Livre.class, 2);
        if (livre != null) {
            System.out.println( livre.getId());
        }

        /**
         * Extraire un emprunt en fonction de son id
         */
        Emprunt emprunt = manage.find(Emprunt.class, 3);
         if (emprunt != null) {
            System.out.println( emprunt.getId());
        }

        // Afficher tous les livres associés à l'emprunt
        for (Livre livre1:emprunt.getLivres()) {
            System.out.println(livre1);
        }
        transaction.commit();
        manage.close();

    }



    /**
     * Réaliser une requête qui permet d’extraire tous les emprunts d’un client donné.
     */
}
