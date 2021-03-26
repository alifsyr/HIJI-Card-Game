import java.util.Timer;
import java.util.Scanner;

public class game{
    boolean isReverse;
    int drawPenalty;
    int turn;
    Player winner;

    public void startGame(){
        //manggil setup game
    }
    public void step(){

    }
    public void setTimer(){
        Timer timer = new Timer();
    }

    public Card getTableCard(){

    }

    public Player getWinner(){

    }

    public Player[] viewPlayer(){

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
