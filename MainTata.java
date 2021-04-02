import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainTata {
    public static void main(String[] args){
        Game game = new Game();
        PalyerCard playercard = new PlayerCard();
        Scanner scan = new Scanner(System.in);
        String runGame;

        System.out.println("");
        System.out.println("Pilihan permainan");
        System.out.println("F01 - Start Game");
        System.out.println("F02 - List Cards");
        System.out.println("F03 - Discard");
        System.out.println("F04 - Draw");
        System.out.println("F05 - Declare HIJI");
        System.out.println("F06 - List Players");
        System.out.println("F07 - View Player in Turn");
        System.out.println("F08 - Help");

        for (int i = 0; i >= 0; i++){
            // input player
            runGame = scan.nextLine();
            System.out.println("");

            if (runGame.toUpperCase() == "F01"){
                game.startGame();
                runGame = scan.nextLine();
            } else if(runGame.toUpperCase() == "F02"){

            } else if(runGame.toUpperCase() == "F03"){
                playercard.throwcard();
            } else if(runGame.toUpperCase() == "F04"){

            } else if(runGame.toUpperCase() == "F05"){

            } else if(runGame.toUpperCase() == "F06"){

            } else if(runGame.toUpperCase() == "F07"){

            } else if(runGame.toUpperCase() == "F08"){
                game.help();
            } else {
                i = -2;
                System.exit(0);
            }
        }
        ;
        
    } 
}
