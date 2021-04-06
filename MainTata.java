
// import java.util.ArrayList;
// import java.util.List;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MainTata {

    public static int scan(Scanner sc) {
        int x = -1;
        try {
            x = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Inputan tidak valid");
        }
        return x;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // int userInput;
        // Scanner input = new Scanner(System.in);
        // while(true) {    
        //     try {
        //         System.out.println("Please enter a number: ");
        //         userInput = input.nextInt();
        //         break;
        //     }
        //     catch(InputMismatchException | NumberFormatException ex ) {
        //         System.out.println("Invalid Number, Please try again");
        //         input.next();
        //     }
        // }

        // Player currentPlayer = new Player("nama");

        // int index = 0;
        // while (true) {
        //     try {
        //         index = sc.nextInt();
        //         if (index <= currentPlayer.getCardLeft() && index > 0) {
        //             break;
        //         }
        //     } catch (InputMismatchException e) {
        //         System.out.println("Inputan tidak valid!");
        //     }
        // }
        

        // int index = 0;
        // while (index == 0) {
        //     try {
        //         index = sc.nextInt();
        //     } catch (InputMismatchException e) {
        //         System.out.println(e);
        //     }
        //     index = sc.nextInt();
        // }

        // sc.close();

        // new Print<Integer>(2).enterPrint();
        // new Print<String>("2").enterPrint();
        // new Print<Character>('2').enterPrint();
        // new Print<AttributeColor>(AttributeColor.BLACK).enterPrint();

        // Player p = new Player("nama");
        // // CardDeck cardDeck = new CardDeck();

        // int i = 0;
        // while (i < 7) {
        // // p.addCard(new CardDraw());
        // p.addCard(new CardNumber(4, AttributeColor.RED));
        // i++;
        // }

        // for (Card c : p.getKartu()) {
        // System.out.println(c.printCard());
        // }

        // // Card temp = new CardDraw(4, AttributeColor.BLACK);
        // Card temp = new CardNumber(5, AttributeColor.BLUE);
        // System.out.println("temp " + temp.printCard());
        // if (p.checkCard(temp)) {
        // System.out.println("ok");
        // } else {
        // System.out.println("no");
        // }

        // Mulai dari sini
        // Scanner sc = new Scanner(System.in);

        Player testPlayer = new Player("test");
        testPlayer.addCard(new CardWild());
        System.out.println("card left before " + testPlayer.getCardLeft());

        DeclareHiji declare = new DeclareHiji(testPlayer);

        Thread t = new Thread(declare);

        System.out.println("before " + testPlayer.getHiji());
        // SetupGame game = new SetupGame();
        // game.getPlayer(sc);
        
        // Boolean isTrue = false;
        t.start();
        
        String input = sc.next();
        while (!input.equals("no")) {
            // while (!isTrue) {
            //     t.start();
            //     isTrue = true;
            // }
            System.out.println("tes");
            if (input.equals("ok")) {
                t.interrupt();
        System.out.println(t.isInterrupted());

                testPlayer = declare.afterDeclare();
            }
            input = sc.next();
        }
        System.out.println("after " + testPlayer.getHiji());
        System.out.println("card left after " + testPlayer.getCardLeft());

        System.out.println(t.isInterrupted());
        if (t.isInterrupted()) {
            System.out.println("sudah dideclare hiji");
        }
        
        // // System.out.println("break");
        // // int x = -1;
        // // while (x != -1) {
        // //     x = MainTata.scan(sc);
        // // }

        sc.close();
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
        // // input player
        // System.out.println("Selamat bermain!");
        // System.out.println("");
        // runGame = scan.next();

        // if (runGame.equals(F01)) {
        // // game.startGame();
        // } else if (runGame.equals(F02)) {
        // game.listCard();
        // } else if (runGame.equals(F03)) {

        // } else if (runGame.equals(F04)) {

        // } else if (runGame.equals(F05)) {
        // // hoo bingung nanti winner taro mana
        // } else if (runGame.equals(F06)) {
        // game.listPlayer();
        // } else if (runGame.equals(F07)) {
        // game.viewPlayer();
        // } else if (runGame.equals(F08)) {
        // game.help();
        // } else {
        // System.out.println("NGECEK");
        // play = false;
        // }
        // }
        // scan.close();
    }
}