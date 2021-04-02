import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainTata {
    public static void main(String[] args) {
        Game game = new Game();
        PlayerCard playercard = new PlayerCard();
        List<List<Card>> playerCardList = new ArrayList<>();
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
            System.out.println("Selamat bermain!");
            System.out.println("");
            runGame = scan.next();
            
            game.startGame();
            game.help();
            game.viewPlayer();
            game.listPlayer();

            if (runGame.toUpperCase() == "1"){
                game.startGame();
            } else if(runGame.toUpperCase() == "F02"){
                System.out.println("Selamat bermain!");
            } else if(runGame.toUpperCase() == "F03"){
                // playercard.throwcard();
            } else if(runGame.toUpperCase() == "F04"){

            } else if(runGame.toUpperCase() == "F05"){

            } else if(runGame.toUpperCase() == "F06"){
                game.listPlayer();
            } else if(runGame.toUpperCase() == "F07"){

            } else if(runGame.toUpperCase() == "F08"){
                game.help();
            } else {
                i = -2;
            }    
    }
}
}