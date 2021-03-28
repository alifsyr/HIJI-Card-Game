import java.util.Timer;
import java.util.Scanner;
import java.util.ArrayList;

public class game{
    static final int handSize; // untuk jumlah kartu
    boolean isReverse; //untuk membalik
    // false = maju; true = mundur
    int drawPenalty; //menambah jumlah draw (+2 / +4)
    int turn; //giliran keberapa
    Player winner; //menampilkan nama pemenang
    Player player[]; // array nama pemain


    public static int nextTurn; //giliran bermain

    handSize = 7; 
// manggil deck
// jumlah pemain
    public startGame(){
        //manggil setup game
        for (int i = 1; i < 6; i++){
            System.out.println("Player" + i + ": " + player[i])
        }
    }
    public void step(){
        this.turn = turn;
    }

    public void setTimer(){
    // ini pake thread
    }

    public Card getTableCard(){

    }

    public Player getWinner(){

    }

    public Player[] viewPlayer(){
        if (isReverse == false) {
            return (nextPlayer + 1) % 6;
        } else if (isReverse == true){
            return (nextPlayer + 6 - 1) % 6;
        }
    }

    public Player[] listPlayer(){

    }

    public String help(){
        System.out.println('How to play the game?');
        System.out.println('F01 - Start Game');
        System.out.println('F02 - List Cards');
        System.out.println('F03 - Discard');
        System.out.println('F04 - Draw');
        System.out.println('F05 - Declare HIJI');
        System.out.println('F06 - List Players');
        System.out.println('F07 - View Player in Turn');
        System.out.println('F08 - Help');
    }
}
