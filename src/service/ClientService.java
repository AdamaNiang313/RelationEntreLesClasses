package service;

import entity.Clients;
import entity.Dettes;

public class ClientService {
    private static final int N = 10;
    private static Clients[] clients = new Clients[N];
    private static int nombreClients;

    public static boolean seachClientByPhone(String telephone){
        Clients clients1 = new Clients(telephone);
        for (int i = 0; i < clients.length; i++) {
            if (clients[i] != null){
                if (clients[i].equals(clients1)){
                    return true;
                }
            }
        }
        return false;
    }

    public static int getNombreClients() {
        return nombreClients;
    }

    public static int seachClientByPhonePosition(String telephone){
        Clients clients1 = new Clients(telephone);
        for (int i = 0; i < clients.length; i++) {
            if (clients[i] != null){
                if (clients[i].equals(clients1)){

                    return i;
                }
            }
        }
        return -1;
    }

    public static Clients seachClientByPhoneClient(String telephone){
        Clients clients1 = new Clients(telephone);
        for (int i = 0; i < clients.length; i++) {
            if (clients[i] != null){

                if (clients[i].equals(clients1)){
                    return clients[i];
                }
            }
        }
        return null;
    }



    public static boolean addClient(Clients client){
        if (nombreClients < N){
            clients[nombreClients] = client;
            return true;
        }
            return false;
    }

    public static Clients[] getAllClient(){
        return clients;
    }

    public static Dettes seachDetteById(int id, Dettes[] dettes){
        for (Dettes dette : dettes){
            if (dette != null){
                if (dette.getId()==id){
                    return dette;
                }
            }
        }
        return null;
    }
}
