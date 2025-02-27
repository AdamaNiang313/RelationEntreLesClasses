import entity.Clients;
import entity.Dettes;
import entity.Paiement;
import service.ClientService;
import vue.ClientVue;
import vue.DetteVue;
import vue.PaiementVue;

import java.util.Scanner;

public class App {

    private static Scanner sc = new Scanner(System.in);
    private static int idClient;
    public static void main(String[] args) {
        menu();

    }

    public static void menu() {
        int choix;
        do {
            System.out.println("Faire votre choix:");
            System.out.println("1. Ajouter un client avec dette:");
            System.out.println("2. Afficher client:");
            System.out.println("3. Chercher un numéro:");
            System.out.println("4. Ajouter dette à un client:");
            System.out.println("5. Ajouter paiement à une dette:");
            System.out.println("6. Lister les paiements d'une dette:");
            System.out.println("7. Quitter:");
            choix = sc.nextInt();
            sc.nextLine();


            switch (choix) {
                case 1:
                    Clients client = ClientVue.saisiClient();

                    if (ClientService.addClient(client)) {
                        System.out.println("Client ajouté avec succès");
                    }else {
                        System.out.println("Le tableau est plein");
                    }
                    break;
                case 2:
                    ClientVue.afficherClient(ClientService.getAllClient(),ClientService.getNombreClients());
                    break;
                case 3:
                    System.out.println("Entrer le numéro à chercher");
                    String tel = sc.next();
                    client = ClientService.seachClientByPhoneClient(tel);
                    if (client != null) {

                        DetteVue.afficherDettes(client.getDettes(), client.getNombreDettes());
                    }else{
                        System.out.println("Numéro non trouvé");
                    }
                    break;
                case 4:
                    System.out.println("Entrer le numéro à chercher");
                    tel = sc.next();
                    client = ClientService.seachClientByPhoneClient(tel);
                    if (client != null) {

                        Dettes dette = DetteVue.saisiDette();
                        client.addDette(dette);
                    }else{
                        System.out.println("Numéro non trouvé");
                    }
                    break;
                    case 5:
                        System.out.println("Entrer le numéro à chercher");
                        tel = sc.next();
                        client = ClientService.seachClientByPhoneClient(tel);
                        if (client != null) {
                            System.out.println(client);
                            int idDette;
                            System.out.println("Entrez l'ID de la dette");
                            idDette=sc.nextInt();
                            Dettes dette ;
                            dette = ClientService.seachDetteById(idDette ,client.getDettes());
                            if (dette != null){
                                if (dette.getMontantRestant()==0){
                                    System.out.println("Dette déjà réglée"+"\n");
                                    break;
                                }
                                System.out.println(dette);
                                Paiement paiement = PaiementVue.saisiPaiement(dette.getMontantRestant());
                                dette.addPaiement(paiement);

                               // dette.setMontantRestant(dette.getMontantRestant() - paiement.getMontant());
                               // dette.setMontantPaye(dette.getMontantPaye()+paiement.getMontant());


                            }else {
                                System.out.println("Dette not found404");
                            }

                        }else{
                            System.out.println("Numéro non trouvé");
                        }
                        break;

                    case 6:
                        System.out.println("Entrer le numéro à chercher");
                        tel = sc.next();
                        client = ClientService.seachClientByPhoneClient(tel);
                        if (client != null) {
                            System.out.println(client);
                            int idDette;
                            System.out.println("Entrez l'ID de la dette");
                            idDette=sc.nextInt();
                            Dettes dette ;
                            dette = ClientService.seachDetteById(idDette ,client.getDettes());
                            if (dette != null){
                                System.out.println(dette);
                                System.out.println("Les paiements de la dette");
                                PaiementVue.afficherPaiementDetts(dette.getPaiements());

                            }else {
                                System.out.println("Dette not found404");
                            }

                        }else{
                            System.out.println("Numéro non trouvé");
                        }
                        break;
                default:
                    System.out.println("Choix invalide, veuillez réessayer.");
            }
        } while (choix != 7);
    }



}