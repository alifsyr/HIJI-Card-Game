import java.util.ArrayList;
import java.util.Scanner;

public class TesPlayer {
    public static void main(String args[]){
        ArrayList<String> listNama = new ArrayList<String>();
        ArrayList<Player> playerList = new ArrayList<Player>();
        Card kartutersedia;

        // membuat objek playerCard
        PlayerCard playerCard =new PlayerCard();

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
        System.out.println("Nama player 2 : "+playerList.get(1).getName());
        
        // Check addCard to playerCardList
        CardWild wildcard = new CardWild();
        CardSkip skipcard = new CardSkip();
        CardReverse reversecard = new CardReverse();
        CardNumber numbercard = new CardNumber();
        CardDraw drawcard = new CardDraw();

        playerList.get(1).addCard(drawcard);
        playerList.get(1).addCard(wildcard);
        playerList.get(1).addCard(skipcard);
        playerList.get(0).addCard(reversecard);
        playerList.get(0).addCard(numbercard);

        // Check playerCardList
        System.out.println("List kartu player 1 : "+ playerList.get(0).getKartu());
        System.out.println("List kartu player 2 : "+ playerList.get(1).getKartu());

        // Mengecek kartu yang tersedia
        kartutersedia = playerList.get(0).throwCard(reversecard);
        System.out.println("Kartu yang dimainkan " + kartutersedia);

        playerList.get(1).throwCard(numbercard);

        // Check getCardLeft (sisa kartu) pemain
        System.out.println("Sisa kartu player 1 : "+ playerList.get(0).getCardLeft());
        System.out.println("Sisa kartu player 2 : "+ playerList.get(1).getCardLeft());

        
        // Check declareHiji
        System.out.println("Player 1 isHiji sebeleum declareHiji : "+playerList.get(0).getHiji());
        playerList.get(0).declareHiji();
        System.out.println("Player 1 isHiji sesudah declareHiji: "+playerList.get(0).getHiji());
    }
}