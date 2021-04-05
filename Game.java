
// import java.util.Timer;
// import java.util.ArrayList;
// import java.util.Collections;
import java.util.List;
import java.util.Scanner;
// import java.util.Timer;
// import java.util.TimerTask;
// import java.util.Random;
// import java.util.Scanner;

public class Game {
    // Card currCard;
    // Card tableCard;
    // Player[] player; // array nama pemain
    // PlayerCard playercard = new PlayerCard();
    // ArrayList<Card> card = new ArrayList<>();
    // List<List<Card>> playerCardList = new ArrayList<>();
    // ArrayList<Player> playerList = new ArrayList<>();

    // public void startGame(){
    // //manggil setup game
    // SetupGame setupGame = new SetupGame();

    // System.out.println("");
    // setupGame.getPlayer();
    // System.out.println("");

    // // ngeshuffle
    // System.out.println("Shuffling deck...");
    // setupGame.shuffleDeck();

    // // distribusi kartu
    // System.out.println("Distribute card...");
    // setupGame.distributeCard();

    // // tablecard
    // System.out.print("Table Card: ");
    // System.out.print(setupGame.getTableCard().getType() + " ");
    // System.out.print(setupGame.getTableCard().getColor() + " ");
    // System.out.print(setupGame.getTableCard().getValue() + " ");
    // System.out.println("");

    // // player pertama
    // System.out.println("Pemain pertama: " +
    // setupGame.getFirstPlayer().getName());
    // System.out.println("");
    // }

    public void start(Scanner sc) {
        System.out.println("");
        System.out.println(".----------------.  .----------------.  .----------------.  .----------------. ");
        System.out.println("| .--------------. || .--------------. || .--------------. || .--------------. |");
        System.out.println("| |  ____  ____  | || |     _____    | || |     _____    | || |     _____    | |");
        System.out.println("| | |_   ||   _| | || |    |_   _|   | || |    |_   _|   | || |    |_   _|   | |");
        System.out.println("| |   | |__| |   | || |      | |     | || |      | |     | || |      | |     | |");
        System.out.println("| |   |  __  |   | || |      | |     | || |   _  | |     | || |      | |     | |");
        System.out.println("| |  _| |  | |_  | || |     _| |_    | || |  | |_' |     | || |     _| |_    | |");
        System.out.println("| | |____||____| | || |    |_____|   | || |  `.___.'     | || |    |_____|   | |");
        System.out.println("| |              | || |              | || |              | || |              | |");
        System.out.println("| '--------------' || '--------------' || '--------------' || '--------------' |");
        System.out.println(" '----------------'  '----------------'  '----------------'  '----------------' ");
        System.out.println("             Kelompok 21 | IF2212 Pemrograman Berorientasi Objek");
        System.out.println("                              Ketik 1 untuk memulai");
        System.out.println("");
        
        String start = sc.next();
        while (!start.equals("1")) {
            System.out.println("Ketik 1 untuk memulai!");
            start = sc.next();
        }
        System.out.println("");
    }

    public void listCommand() {
        System.out.println("Command yang dapat kamu jalankan:");
        System.out.println("[1] Lihat list kartu");
        System.out.println("[2] Pilih Kartu");
        System.out.println("[3] List Pemain");
        System.out.println("[4] Urutan Pemain");
        System.out.println("[5] Ambil Kartu Dari Deck");
        System.out.println("[6] Declare Hiji");
        System.out.println("[7] Bantuan");
    }

    public void space() {
        System.out.println("");
        System.out.println("--------------------------------------");
        System.out.println("");
    }

    public void tableCardInfo(Card tableCard) {
        System.out.println("Table Card: ");
        System.out.println(tableCard.printCard());
        System.out.println("");
    }
    // public void step() {
    // currTurn = (currTurn + playerOrder) % player.length;
    // if (currCard instanceof CardReverse) {
    // playerOrder = card.get(2).usePower(playerOrder);
    // }
    // }

    public void listCard(List<Card> playerCardList) {
        if (playerCardList.size() != 0) {
            System.out.println("Berikut adalah list kartumu:");
            for (int j = 0; j < playerCardList.size(); j++) {
                System.out.println((j + 1) + ". " + playerCardList.get(j).printCard());
            }
        } else {
            System.out.println("Kamu tidak memiliki kartu lagi!");
        }
    }

    public void getColorOption() {
        new Print<String>("Kamu mengeluarkan sebuah wildcard").enterPrint();
        new Print<String>("1. Red").enterPrint();
        new Print<String>("2. Blue").enterPrint();
        new Print<String>("3. Yellow").enterPrint();
        new Print<String>("4. Green").enterPrint();
        new Print<String>("Warna apa yang kamu inginkan?").noEnterPrint();
        // System.out.println("Kamu mengeluarkan sebuah wildcard");
        // System.out.println("1. Red");
        // System.out.println("2. Blue");
        // System.out.println("3. Yellow");
        // System.out.println("4. Green");
        // System.out.print("Warna apa yang kamu inginkan? ");
    }

    public void getTableCard(Card card) {
        new Print<Character>(' ').enterPrint();;
        // System.out.println("");
        System.out.println("Table Card: ");
        System.out.println(card.printCard());
        // System.out.println("");
        new Print<Character>(' ').enterPrint();;
    }

    public void currentPlayerInfo(Player currentPlayer) {
        System.out.println("Pemain Saat Ini: ");
        System.out.println(currentPlayer.getName());
        System.out.println("");
    }

    // public void timer(){
    // try {
    // Thread.sleep(3000);
    // ArrayList<Card> card = new ArrayList<>();
    // playerCardList.add(card);
    // playerCardList.get(i).add(cardDeck.get(j));
    // } catch (InterruptedException ex) {

    // }
    // }

    // public void setTimer(){
    // // ini pake thread

    // }

    // public void checkHiji() {
    // for (Player p : player) {
    // for (int j = 0; j < playerCardList.size(); j++) {
    // if (player[j] == player[currTurn]) {
    // p.getName();
    // // if (playerList.get(j).getCardLeft() == 1 && !p.getHiji){
    // // nambah dua kartu
    // // }
    // }
    // }
    // }

    // }

    // public void getWinner() {
    //     for (int j = 0; j < playerCardList.size(); j++) {
    //         if (playerList.get(j).getCardLeft() == 0) {
    //             System.out.println(player[j].getName() + " telah memenangkan game!");
    //         }
    //     }
    // }

    public void viewPlayer(Player[] playerList, int currTurn) {
        for (int j = 0; j < playerList.length; j++) {
            if (playerList[j] == playerList[currTurn]) {
                System.out.println(playerList[j].getName() + " sedang giliran");
                j += 1;
                System.out.println(playerList[j].getName() + " giliran berikutnya");
                System.out.println("");
            }
        }
    }

    public void listPlayer(Player[] playerList, int currTurn) {
        for (int j = 0; j < playerList.length; j++) {
            System.out.println("Pemain " + (j + 1) + ": " + playerList[j].getName());
            System.out.println("Jumlah Kartu: " + (j + 1) + ": " + playerList[j].getCardLeft());
            if (playerList[j] == playerList[currTurn]) {
                System.out.println("Sedang giliran");
            } else {
                System.out.println("Tidak sedang giliran");
            }
            System.out.println("");
        }
    }

    public void help() {
        System.out.println("Bagaimana cara memainkan game ini?");
        System.out.println("Pertama, pemain harus memasukkan banyaknya dan nama pemain");
        System.out.println("Setelahnya kartu yang ada akan diacak dan dibagikan kepada pemain dengan setiap pemain mendapat 7 kartu");
        System.out.println("Lalu dipilih kartu pertama untuk acuan dan pemain pertama");
        System.out.println("Terdapat beberapa command penting. Diantaranya:");
        System.out.println("[1] Lihat list kartu");
        System.out.println("[2] Pilih Kartu");
        System.out.println("[3] List Pemain");
        System.out.println("[4] Urutan Pemain");
        System.out.println("[5] Ambil Kartu Dari Deck");
        System.out.println("[6] Declare Hiji");
        System.out.println("[7] Bantuan");
        
    }

    public static void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }
}
