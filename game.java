import java.util.Timer;
import java.util.Scanner;
import java.util.ArrayList;

public class Game{
    private static int handSize = 7; // untuk jumlah kartu
    private boolean isReverse; //untuk membalik
    // false = maju; true = mundur
    private int drawPenalty; //menambah jumlah draw (+2 / +4)
    private int turn; //giliran keberapa
    private player winner; //menampilkan nama pemenang
    private player player[]; // array nama pemain

    private static int nextTurn; //giliran bermain

    turn = 0;

// manggil deck
// jumlah pemain

    public void startGame(){
        //manggil setup game
    }

    public int step(){
        this.turn = turn;
        if (isReverse == true){
            return (turn + 1) % jmlhPemain; //manggil jumlah pemain
        } else if (isReverse == false){

        }
    }

    public void setTimer(){
    // ini pake thread
    
    }

    public player getWinner(){
        if (Card.checkCard = 0){
            System.out.println(player.getName() + "has win the Game!");
        }
        return false;
    }

    public player[] viewPlayer(){
        if (isReverse == false) {
            return (nextPlayer + 1) % 6;
        } else if (isReverse == true){
            return (nextPlayer + 6 - 1) % 6;
        }
    }

    public player[] listPlayer(){

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
