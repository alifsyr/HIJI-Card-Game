import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // ************************************************** Inisiasi Data **************************************************//

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
        Player currentPlayer;
        Player winner = null;
        Card tableCard = null;

        // ************************************************** SetUp Game **************************************************//

        SetupGame setupGame = new SetupGame();

        // input player
        // System.out.println("");
        // System.out.println(".----------------.  .----------------.  .----------------.  .----------------. ");
        // System.out.println("| .--------------. || .--------------. || .--------------. || .--------------. |");
        // System.out.println("| |  ____  ____  | || |     _____    | || |     _____    | || |     _____    | |");
        // System.out.println("| | |_   ||   _| | || |    |_   _|   | || |    |_   _|   | || |    |_   _|   | |");
        // System.out.println("| |   | |__| |   | || |      | |     | || |      | |     | || |      | |     | |");
        // System.out.println("| |   |  __  |   | || |      | |     | || |   _  | |     | || |      | |     | |");
        // System.out.println("| |  _| |  | |_  | || |     _| |_    | || |  | |_' |     | || |     _| |_    | |");
        // System.out.println("| | |____||____| | || |    |_____|   | || |  `.___.'     | || |    |_____|   | |");
        // System.out.println("| |              | || |              | || |              | || |              | |");
        // System.out.println("| '--------------' || '--------------' || '--------------' || '--------------' |");
        // System.out.println(" '----------------'  '----------------'  '----------------'  '----------------' ");
        // System.out.println("             Kelompok 21 | IF2212 Pemrograman Berorientasi Objek");
        // System.out.println("");

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

        System.out.println("");

        for (int i = 0; i < setupGame.jumlahPemain; i++) {
            System.out.print("Masukkan nama pemain " + (i + 1) + " : ");
            String namaPemain = sc.next();

            setupGame.player[i] = new Player(namaPemain);
        }
        System.out.println("");

        System.out.println("Berikut daftar pemain.");

        for (int i = 0; i < setupGame.player.length; i++) {
            System.out.println((i + 1) + ". " + setupGame.player[i].getName());
        }
        System.out.println("Selamat bermain!");
        System.out.println("");
        System.out.println("--------------------------------------");
        System.out.println("");

        currentPlayer = setupGame.getFirstPlayer();
        System.out.println("Pemain pertama: " + currentPlayer.getName());
        System.out.println("");

        // Shuffle Kartu di Deck
        System.out.println("Shuffling deck...");
        setupGame.shuffleDeck();

        System.out.println("--------------------------------------");

        // distribusi kartu
        setupGame.distributeCard();

        tableCard = setupGame.getTableCard();

        // ************************************************** Game Dimulai **************************************************//

        // Looping Player

        while (winner == null) {
            System.out.println("Table Card: ");
            System.out.println(tableCard.printCard());
            System.out.println("");
            
            System.out.println("Pemain Saat Ini: ");
            System.out.println(currentPlayer.getName());
            System.out.println("");
 
            game.listCommand();
            boolean isTurn = true;
            try {
                System.out.println("");
                System.out.print("Command yang ingin dijalankan: ");
                runGame = sc.next();
                while (isTurn) {
                    if (runGame.equals("1")) {
                        game.listCard(currentPlayer.getKartu());
                        
                    } else if (runGame.equals("2")) {
                        System.out.println("");
                        System.out.println("Table Card: ");
                        System.out.println(tableCard.printCard());
                        System.out.println("");


                        PlayCard temp = new PlayCard(tableCard);
                        boolean cont = true;

                        // Looping Throw Card 
                        while (!runGame.toLowerCase().equals("n") && cont) {
                            game.listCard(currentPlayer.getKartu());
                            System.out.println("");
                            System.out.print("Kartu mana yang akan kamu keluarkan? ");
                            int index = sc.nextInt();
                            try {
                                Card throwCard = currentPlayer.getKartu().get(index-1);
                                if (temp.addCard(throwCard)) {
                                    currentPlayer.throwCard(throwCard);
                                } 

                                // Handle Multiple Discard
                                if (throwCard.getType() == AttributeType.WILDCARD) {
                                    System.out.println("Kamu mengeluarkan sebuah wildcard");
                                    System.out.println("1. Red");
                                    System.out.println("2. Green");
                                    System.out.println("3. Blue");
                                    System.out.println("4. Yellow");
                                    System.out.print("Warna apa yang kamu inginkan? ");
                                    index = sc.nextInt();
                                    cont = false;
                                } else {
                                    System.out.println("");
                                    System.out.print("Apakah kamu mau mengeluarkan kartu lagi? ");
                                    runGame = sc.next();
                                    while (!runGame.toLowerCase().equals("n") && !runGame.toLowerCase().equals("y")) {
                                        System.out.println("Input tidak valid!");
                                        System.out.println("");
                                        System.out.print("Apakah kamu mau mengeluarkan kartu lagi (Y/N)? ");
                                        runGame = sc.next();
                                    }
                                }
                                
                            } catch (IndexOutOfBoundsException e){
                                System.out.println("Pilihan kartu tidak valid!");
                            }

                        }
                        tableCard = temp.getLastCard();
                        isTurn = false;
                        
                        // cek udah winner apa belom
                    } else if (runGame.equals("3")) {
                        System.out.println("List Pemain: ");
                        game.listPlayer(setupGame.player, currentPlayerOrder);

                    } else if (runGame.equals("4")) {
                        System.out.println("Urutan pemain: ");
                        game.viewPlayer(setupGame.player, currentPlayerOrder);
    
                    } else if (runGame.equals("5")) {
                        System.out.println("Giliran diskip, kamu mendapat sebuah kartu dari deck");
                        currentPlayer.addCard(deck.getCard());
                        isTurn = false;
                        
                    } else if (runGame.equals("6")) {
                        System.out.println("Declare Hiji");
                        currentPlayer.declareHiji();

                    } else if (runGame.equals("7")) {
                        game.help();
                        
                    } else if (runGame.equals("cheat")) {
                        winner = currentPlayer;
                        isTurn = false;
                        
                    } else {
                        System.out.println("Command tidak valid!");

                    }

                    // Conditional sebelum ganti pemain selanjutnya
                    if (winner != null) {
                        System.out.println("");
                        System.out.println("Pemenang permainan HIJI adalah " + winner.getName());
                        
                    } else if (isTurn) {
                        System.out.println("");
                        System.out.print("Command yang ingin dijalankan: ");
                        runGame = sc.next();

                    } else {
                        System.out.println("");
                        System.out.println("Giliran akan diganti ke pemain selanjutnya");
                    }
                }
            } catch (NoSuchElementException e) {
                System.out.println(e);
            }
            
            System.out.println("--------------------------------------");
            currentPlayerOrder = (currentPlayerOrder + playerOrder) %setupGame.jumlahPemain; 
            currentPlayer = setupGame.player[currentPlayerOrder];
        }
        System.out.println("Terima kasih telah bermain HIJI!");
        System.out.println("Selamat kepada " + winner.getName() + " sebagai pemenang game kali ini!");

        sc.close();
    }
}
