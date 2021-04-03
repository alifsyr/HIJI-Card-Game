import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainTata {
    public static void main(String[] args) {
        Player p = new Player("nama");
        CardDeck cardDeck = new CardDeck();

        int i = 0;
        while (i < 7) {
            // p.addCard(new CardDraw());
            p.addCard(new CardNumber(4, AttributeColor.RED));
            i++;
        }

        for (Card c : p.getKartu()) {
            System.out.println(c.printCard());
        }

        // Card temp = new CardDraw(4, AttributeColor.BLACK);
        Card temp = new CardNumber(5, AttributeColor.BLUE);
        System.out.println("temp " + temp.printCard());
        if (p.checkCard(temp)) {
            System.out.println("ok");
        } else {
            System.out.println("no");
        }


        // Scanner sc = new Scanner(System.in);

        // Thread t = new Thread(new DeclareHiji());
        // t.start();

        // String input = sc.next();
        // System.out.println("tes");
        // if (input.equals("ok")) {
        //     t.interrupt();
        // }

        // sc.close();
        // Game game = new Game();
        // PlayerCard playercard = new PlayerCard();
        // List<List<Card>> playerCardList = new ArrayList<>();
        // Scanner scan = new Scanner(System.in);
        // String runGame;
        // boolean play = true;

        // String F01 = "F01";
        // String F02 = "F02";
        // String F03 = "F03";
        // String F04 = "F04";
        // String F05 = "F05";
        // String F06 = "F06";
        // String F07 = "F07";
        // String F08 = "F08";

        // System.out.println("");
        // System.out.println("Pilihan permainan");
        // System.out.println("F01 - Start Game");
        // System.out.println("F02 - List Cards");
        // System.out.println("F03 - Discard");
        // System.out.println("F04 - Draw");
        // System.out.println("F05 - Declare HIJI");
        // System.out.println("F06 - List Players");
        // System.out.println("F07 - View Player in Turn");
        // System.out.println("F08 - Help");

        // while (play) {
        //     // input player
        //     System.out.println("Selamat bermain!");
        //     System.out.println("");
        //     runGame = scan.next();

        //     if (runGame.equals(F01)) {
        //         // game.startGame();
        //     } else if (runGame.equals(F02)) {
        //         game.listCard();
        //     } else if (runGame.equals(F03)) {

        //     } else if (runGame.equals(F04)) {

        //     } else if (runGame.equals(F05)) {
        //         // hoo bingung nanti winner taro mana
        //     } else if (runGame.equals(F06)) {
        //         game.listPlayer();
        //     } else if (runGame.equals(F07)) {
        //         game.viewPlayer();
        //     } else if (runGame.equals(F08)) {
        //         game.help();
        //     } else {
        //         System.out.println("NGECEK");
        //         play = false;
        //     }
        // }
        // scan.close();
    }
}