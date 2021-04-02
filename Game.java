import java.util.Timer;
import java.util.Scanner;
import java.util.ArrayList;

public class Game{
    private static int handSize = 7; // untuk jumlah kartu
    private static boolean isReverse; //untuk membalik
    // false = maju; true = mundur
    private int drawPenalty; //menambah jumlah draw (+2 / +4)
    private static int turn = 0; //giliran keberapa
    private Player winner; //menampilkan nama pemenang
    private Player player[]; // array nama pemain

    private static int nextTurn; //giliran bermain

    PlayerCard playercard = new PlayerCard();

    public void startGame(){
        //manggil setup game
        SetupGame setupGame = new SetupGame();

        System.out.println("");
        setupGame.getPlayer();
        System.out.println("");

        // ngeshuffle
        System.out.println("Shuffling deck...");
        setupGame.shuffleDeck();

        // distribusi kartu
        System.out.println("Distribute card...");
        setupGame.distributeCard();

        // tablecard
        System.out.print("Table Card: ");
        System.out.print(setupGame.getTableCard().getType() + " ");
        System.out.print(setupGame.getTableCard().getColor() + " ");
        System.out.print(setupGame.getTableCard().getValue() + " ");
        System.out.println("");

        // player pertama
        System.out.println("Pemain pertama: " + setupGame.getFirstPlayer().getName());
        System.out.println("");
    }

    public static int step(int jmlhPemain){
        if (isReverse == true){
            return (turn + 1) % jmlhPemain; //manggil jumlah pemain
        } else {
            return (turn + jmlhPemain - 1) % jmlhPemain;
        }
    }

    // public void timer(){
    //     try {
    //         Thread.sleep(3000);
    //         ArrayList<Card> card = new ArrayList<>();
    //         playerCardList.add(card);
    //         playerCardList.get(i).add(cardDeck.get(j));
    //     } catch (InterruptedException ex) {

    //     }
    // }

    // public void setTimer(){
    //     // ini pake thread

    // }

//    public Player getWinner(){
//        if (Player[].size() == 0){
//            System.out.println(Player[] + "has win the Game!");
//        }
//        return false;
//    }

//    public Player[] viewPlayer(){
//        if (isReverse == false) {
//            return (nextPlayer + 1) % 6;
//        } else if (isReverse == true){
//            return (nextPlayer + 6 - 1) % 6;
//        }
//    }

//    public Player[] listPlayer(int jmlhPemain){
//        for (int i = 0; i < jmlhPemain; i++){
//            System.out.println("Pemain " + i + ": ");
//            System.out.println("Jumlah Kartu: " + Card.getSize);
//            if (turn == ){
//                System.out.println("Sedang giliran");
//            } else if (turn == false){
//                System.out.println("Tidak sedang giliran");
//            }
//        }
//
//    }

    public void help(){
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
