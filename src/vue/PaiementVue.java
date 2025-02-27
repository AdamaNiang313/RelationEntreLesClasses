package vue;

import entity.Dettes;
import entity.Paiement;

import java.time.LocalDate;
import java.util.Scanner;

public class PaiementVue {
    private static Scanner sc = new Scanner(System.in);
    public static Paiement saisiPaiement(float montantDu){
        float montant;
        do {
            System.out.println("Veuillez saisir le paiement");
             montant = sc.nextFloat();

        }while (montant <= 0 || montant > montantDu);

        Paiement paiement = new Paiement();
        paiement.setMontant(montant);
        paiement.setDate(LocalDate.now().toString());
        return paiement;

    }

    public static void afficherPaiementDetts(Paiement[] paiements){
        for (Paiement paiement : paiements){
            if (paiement != null){
               System.out.println(paiement);
            }
        }
    }




}
