package vue;

import entity.Dettes;
import entity.Paiement;

import java.util.Scanner;

public class DetteVue {

    private static Scanner sc = new Scanner(System.in);

    public static Dettes saisiDette(){
        System.out.println("Veuillez saisir le Montant:");
        float montantDette = sc.nextFloat();
        Dettes dette = new Dettes();
        dette.setMontantDette(montantDette);
        dette.setMontantRestant(montantDette);

        return dette;
    }

    public static void afficherDettes(Dettes[] dette, int nombreDettes) {
        if (nombreDettes == 0) {
            System.out.println("Ce client n'a pas de dettes.");
        } else {
            System.out.println("nombre de dettes"+nombreDettes);
            for (int i = 0; i < nombreDettes; i++) {
                System.out.println(dette[i].toString());
            }
        }
    }





}
