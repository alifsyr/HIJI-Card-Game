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

        // Check getName Player
        System.out.println("Player 2 : "+playerList.get(1).getName());
        
        CardWild wildcard = new CardWild();
        // PlayerCard.addCard(wildcard); ini kenapa error :(
        CardSkip skipcard = new CardSkip();
        CardReverse reversecard = new CardReverse();
        CardNumber numbercard = new CardNumber();
        CardDraw drawcard = new CardDraw();
        
        // Check declareHiji
        playerList.get(1).declareHiji();
        System.out.println("Player 2 isHiji : "+playerList.get(1).getHiji());



    }
}