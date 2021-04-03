import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // ************************************************** Inisiasi Data **************************************************//

        int number = 0; // Dummy

        // Inisiasi Variabel yang Diperlukan
        int playerOrder = 1; // Urutan pemain, -1 untuk reverse, 1 untuk normal
        int currentPlayerOrder = 0; // Urutan pemain saat ini
        int currentDrawCard = 0; // Jumlah Draw Card yang sedang digunakan saat ini (dapat ditumpuk)
        // Inisiasi scanner
        Scanner sc = new Scanner(System.in);
        String runGame;

        // Inisiasi class yang digunakan
        Game game = new Game();
        CardDeck deck = new CardDeck();
        PlayCard play = new PlayCard();
        Player currentPlayer;
        Player winner = null;

        ArrayList<Player> playerList = new ArrayList<>();
        playerList.add(new Player("player1"));
        playerList.add(new Player("player2"));

        // ************************************************** SetUp Game **************************************************//

        SetupGame setupGame = new SetupGame();

        // input player
        System.out.println("");
        System.out.print("Ada berapa pemain? ");

        // exception buat input.
        try {
            setupGame.jumlahPemain = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("InputMismatchException catched.");
            System.out.println("Harap masukkan bilangan integer!");
            System.out.println("Ulangi permainan.");
            System.exit(0);
        }

        while (setupGame.jumlahPemain <= 1 || setupGame.jumlahPemain >= 7) {
            System.out.println("Maaf, hanya jumlah pemain diantara 2-6 yang diperbolehkan.");
            System.out.println("Silahkan masukkan jumlah pemain.");
            setupGame.jumlahPemain = sc.nextInt();
        }

        setupGame.player = new Player[setupGame.jumlahPemain];

        for (int i = 0; i < setupGame.jumlahPemain; i++) {
            System.out.print("Masukkan nama pemain " + (i + 1) + " : ");
            String namaPemain = sc.next();

            setupGame.player[i] = new Player(namaPemain);
        }
        System.out.println("Berikut daftar pemain.");

        for (int i = 0; i < setupGame.player.length; i++) {
            System.out.println((i + 1) + ". " + setupGame.player[i].getName());
        }
        System.out.println("Selamat bermain!");
        System.out.println("");

        // Shuffle Kartu di Deck
        System.out.println("Shuffling deck...");
        setupGame.shuffleDeck();

        // distribusi kartu
        setupGame.distributeCard();

        // tablecard
        System.out.println("Table Card: ");
        System.out.println(setupGame.getTableCard().printCard());
        System.out.println("");
        System.out.println("");

        currentPlayer = setupGame.getFirstPlayer();
        System.out.println("Pemain pertama: " + currentPlayer.getName());
        System.out.println("");

        // ************************************************** Game Dimulai **************************************************//

        // Looping Player

        while (winner == null) {
            System.out.println("Giliran " + currentPlayer.getName());
            System.out.println("Berikut adalah list kartumu:");
            int i = 1;
            for (Card c: currentPlayer.getKartu()) {
                System.out.println(i + ". " + c.printCard());
                i++;
            }
            
            System.out.println("");
            try {
                System.out.print("Next Move: ");
                runGame = sc.nextLine();

                if (runGame.equals("F01")) {
                    System.out.println("Game 1");
                    // game.startGame();
                } else if (runGame.equals("F02")) {
                    System.out.println("Game 2");
                    // game.listCard();
                } else if (runGame.equals("F03")) {
                    System.out.println("Game 3");

                } else if (runGame.equals("F04")) {
                    System.out.println("Game 4");

                } else if (runGame.equals("F05")) {
                    System.out.println("Game 5");
                    // hoo bingung nanti winner taro mana
                } else if (runGame.equals("F06")) {
                    System.out.println("Game 6");
                    game.listPlayer();
                } else if (runGame.equals("F07")) {
                    System.out.println("Game 7");
                    game.viewPlayer();
                } else if (runGame.equals("F08")) {
                    System.out.println("Game 8");
                    game.help();
                } else {
                    System.out.println("NGECEK");
                    // play = false;
                }
            } catch (NoSuchElementException e) {
                System.out.println(e);
            }
        }
        sc.close();
    }
}
