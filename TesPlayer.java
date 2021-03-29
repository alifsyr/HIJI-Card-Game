import java.util.ArrayList;
import java.util.Scanner;

public class TesPlayer {
    public static void main(String args[]){
        ArrayList<String> listNama = new ArrayList<String>();
        ArrayList<Player> playerList = new ArrayList<Player>();


        // Inisiasi Pemain
        listNama.add("Alif");
        listNama.add("Boi");
        listNama.add("Eko");

        // Masukin nama pemain dari listNama dan ngebuat object palyer dengan nama dari listNama
        for (int i = 0; i < listNama.size(); i++){
            Player player = new Player(listNama.get(i));
            playerList.add((Player) player);
        }

        System.out.println("Player 2 : "+playerList.get(1).getName());
        playerList.get(1).declareHiji();
        System.out.println("Player 2 isHiji : "+playerList.get(1).getHiji());
    }
}