import java.util.Timer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Game {
    private static int handSize = 7; // untuk jumlah kartu
    private static boolean isReverse; // untuk membalik
    // false = maju; true = mundur
    private int drawPenalty; // menambah jumlah draw (+2 / +4)
    // private static int turn = 0; //giliran keberapa
    private Player winner; // menampilkan nama pemenang
    int currTurn = 0;
    private static int nextTurn; // giliran bermain
    int playerOrder = 1;

    Card currCard;
    Card tableCard;
    Player[] player; // array nama pemain
    PlayerCard playercard = new PlayerCard();
    ArrayList<Card> card = new ArrayList<>();
    List<List<Card>> playerCardList = new ArrayList<>();
    ArrayList<Player> playerList = new ArrayList<>();

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

    public void listCommand() {
        System.out.println("Command yang dapat kamu jalankan:");
        System.out.println("[1] Lihat list kartu");
        System.out.println("[2] Pilih Kartu");
        System.out.println("[3] List Pemain");
        System.out.println("[4] Urutan Pemain");
        System.out.println("[5] Skip Turn");
        System.out.println("[6] Declare Hiji");
    }

    public void step() {
        currTurn = (currTurn + playerOrder) % player.length;
        if (currCard instanceof CardReverse) {
            playerOrder = card.get(2).usePower(playerOrder);
        }
    }

    public void listCard() {
        for (int j = 0; j < playerCardList.size(); j++) {
            System.out.println((j + 1) + ". " + playercard.getKartu().get(j));
        }
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

    public void checkHiji() {
        for (Player p : player) {
            for (int j = 0; j < playerCardList.size(); j++) {
                if (player[j] == player[currTurn]) {
                    p.getName();
                    // if (playerList.get(j).getCardLeft() == 1 && !p.getHiji){
                    // nambah dua kartu
                    // }
                }
            }
        }

    }

    public void getWinner() {
        for (int j = 0; j < playerCardList.size(); j++) {
            if (playerList.get(j).getCardLeft() == 0) {
                System.out.println(player[j].getName() + " telah memenangkan game!");
            }
        }
    }

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
            System.out.println("Pemain " + (j+1) + ": " + playerList[j].getName());
            System.out.println("Jumlah Kartu: " + (j+1) + ": " + playerList[j].getCardLeft());
            if (playerList[j] == playerList[currTurn]) {
                System.out.println("Sedang giliran");
            } else {
                System.out.println("Tidak sedang giliran");
            }
            System.out.println("");
        }
    }

    public void help() {
        System.out.println("How to play the game?");
        System.out.println("F01 - Start Game");
        System.out.println("F02 - List Cards");
        System.out.println("F03 - Discard");
        System.out.println("F04 - Draw");
        System.out.println("F05 - Declare HIJI");
        System.out.println("F06 - List Players");
        System.out.println("F07 - View Player in Turn");
        System.out.println("F08 - Help");
    }
}
