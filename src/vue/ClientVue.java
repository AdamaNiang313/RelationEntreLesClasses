package vue;

import entity.Clients;
import entity.Dettes;

import java.util.Scanner;

public class ClientVue {
    private static Scanner sc = new Scanner(System.in);


    public static Clients saisiClient(){
        System.out.println("Saisir un client");
        System.out.println("Nom");
        String nom = sc.nextLine();
        System.out.println("Téléphone");
        String telephone = sc.nextLine();
        System.out.println("Adresse");
        String adresse = sc.nextLine();
        Clients client = new Clients(nom,telephone,adresse);
        String rep;
        do {
            System.out.println("Voulez-vous ajouté une dette?");
            rep = sc.next();
            if (rep.compareToIgnoreCase("oui") == 0) {
                Dettes dette = DetteVue.saisiDette();
                client.addDette(dette);
            }

        } while (rep.compareToIgnoreCase("oui") == 0 && client.getNombreDettes() < Clients.N);

        return client;
    }

    public static void afficherClient(Clients[] clients,int nombreClients) {
        if (nombreClients == 0) {
            System.out.println("Aucun client à afficher.");
        } else {
            for (int i = 0; i < nombreClients; i++) {
                System.out.println(clients[i].toString());
            }
        }
    }

}
