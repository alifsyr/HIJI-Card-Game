
// import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // ************************************************** Inisiasi Data **************************************************//

        // Inisiasi Variabel yang Diperlukan
        int playerOrder = 1; // Urutan pemain, -1 untuk reverse, 1 untuk normal
        int currentPlayerOrder = 0; // Urutan pemain saat ini
        int drawPenalty = 0; // Jumlah Draw Card yang sedang digunakan saat ini (dapat ditumpuk)

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
 
            //game.listCommand();
            boolean isTurn = true;
            boolean multDisc = false;
            try {
                game.listCommand();
                System.out.println("");
                System.out.print("Command yang ingin dijalankan: ");
                runGame = sc.next();
                while (isTurn) {
                    PlayCard temp = new PlayCard(tableCard);

// ************************************************** Melihat List Kartu **************************************************//

                    if (runGame.equals("1")) {
                        game.listCard(currentPlayer.getKartu());
                        System.out.println(" ");

// ************************************************** Pilih Kartu **************************************************//

                    } else if (runGame.equals("2")) {
                        if (drawPenalty == 0) {
                            boolean cont = true;
                            int tempColor = 0;
                            int index;
    
                            // Looping Throw Card 
                            while (!runGame.toLowerCase().equals("n") && cont && (currentPlayer.getCardLeft() != 0)) {
                                game.getTableCard(tableCard);
                                game.listCard(currentPlayer.getKartu());
                                if (!currentPlayer.checkCard(tableCard) && !multDisc) {
                                    System.out.println("Kamu tidak memiliki kartu yang dapat dibuang!");
                                    System.out.println("Kamu harus mengambil kartu dari deck!");
                                    Card localCard = deck.getCard();
                                    System.out.println("Kartu yang kamu peroleh dari deck adalah " + localCard.printCard());
                                    if (temp.checkIsValid(localCard, tableCard)) {
                                        System.out.println("Apakah kamu ingin mengeluarkan kartu yang diperoleh dari deck (Y/N)? ");
                                        String decision = sc.next();
                                        List<String> acceptedAnswers = Arrays.asList("y", "n");

                                        // do {
                                        //     decision = sc.next();
                                        // }
                                        if (decision.toLowerCase().equals("y")) {
                                            if (localCard.getType() == AttributeType.REVERSE) {
                                                playerOrder = localCard.usePower(playerOrder);
                                            } else if (localCard.getType() == AttributeType.SKIP) {
                                                currentPlayerOrder = localCard.usePower(currentPlayerOrder);
                                            } else if (localCard.getType() == AttributeType.DRAW) {
                                                drawPenalty = localCard.usePower(drawPenalty);
                                            } 
                                            if (localCard.getColor() == AttributeColor.BLACK) {
                                                game.getColorOption();
                                                int choiceColor = sc.nextInt();
                                                localCard.setColor(AttributeColor.values() [choiceColor-1]);
                                            } 
                                            tableCard = localCard;
                                            System.out.println("Kartu dikeluarkan");
                                        }
                                    }
                                    System.out.println("\nGiliran selesai");
                                    isTurn = false;
                                } else {
                                    System.out.println("");
                                    System.out.print("Kartu mana yang akan kamu keluarkan? ");
                                    boolean input = false;
                                    index = 0;
                                    while(!input){
                                        try {
                                            index = sc.nextInt();
                                            if (index <= currentPlayer.getCardLeft() && index > 0){
                                                input = true;
                                            }
                                        } catch (InputMismatchException e) {
                                            System.out.println("Inputan tidak valid!");
                                            sc.next();
                                        }
                                    }
                                    try {
                                        Card throwCard = currentPlayer.getKartu().get(index - 1);
                                        if (temp.addCard(throwCard)) {
                                            currentPlayer.throwCard(throwCard);
                                            tableCard = temp.getLastCard();
                                            if (throwCard.getType() == AttributeType.REVERSE) {
                                                playerOrder = throwCard.usePower(playerOrder);
                                            } else if (throwCard.getType() == AttributeType.SKIP) {
                                                currentPlayerOrder = throwCard.usePower(currentPlayerOrder);
                                            } else if (throwCard.getType() == AttributeType.DRAW) {
                                                drawPenalty = throwCard.usePower(drawPenalty);
                                            } 
                                            if (throwCard.getColor() == AttributeColor.BLACK) {
                                                game.getColorOption();
                                                tempColor = sc.nextInt();
                                                cont = false;
                                            } 
                                        } else {
                                            System.out.println("tes");
                                        }

                                        // Handle Multiple Discard
                                        if (cont){
                                            System.out.println("");
                                            System.out.print("Apakah kamu mau mengeluarkan kartu lagi (Y/N) ? ");
                                            runGame = sc.next();
                                            while (!runGame.toLowerCase().equals("n")
                                                    && !runGame.toLowerCase().equals("y")) {
                                                System.out.println("Input tidak valid!");
                                                System.out.println("");
                                                System.out.print("Apakah kamu mau mengeluarkan kartu lagi (Y/N)? ");
                                                runGame = sc.next();
                                            }
                                            if (temp.length() > 2 && runGame.toLowerCase().equals("y")) {
                                                multDisc = true;
                                            }
                                        }
    
                                    } catch (IndexOutOfBoundsException e) {
                                        System.out.println("Pilihan kartu tidak valid!");
                                    }
                                }
                            }
                            tableCard = temp.getLastCard();
                            if (tableCard.getType() == AttributeType.WILDCARD && tableCard.getColor() == AttributeColor.BLACK) {
                                tableCard.setColor(AttributeColor.values() [tempColor-1]);
                            }
                            if (currentPlayer.getCardLeft() == 1) {
                                System.out.println("harusnya declare hiji qm");
                            } else if (currentPlayer.getCardLeft() == 0) {
                                winner = currentPlayer;
                                isTurn = false;
                            } else {
                                isTurn = false;
                            }
                
                        } else {
                            game.listCard(currentPlayer.getKartu());

                            System.out.println("draw " + drawPenalty);
                            boolean anyDraw = false;

                            // Ngecek punya kartu draw atau engga
                            for (Card c: currentPlayer.getKartu()) {
                                if (c instanceof CardDraw) {
                                    anyDraw = true;
                                }
                            }

                            if (anyDraw) {
                                boolean cont = true;
                                while (!runGame.toLowerCase().equals("n") && cont) {
                                    int index;
                                    game.listCard(currentPlayer.getKartu());
                                    System.out.println("");
                                    System.out.print("Kartu mana yang akan kamu keluarkan? ");
                                    try {
                                        index = sc.nextInt();
                                    } catch (InputMismatchException e) {
                                        System.out.println("Inputan tidak valid!");
                                        index = sc.nextInt();
                                    }
                                    try {
                                        Card throwCard = currentPlayer.getKartu().get(index - 1);
                                        if (temp.addCard(throwCard)) {
                                            currentPlayer.throwCard(throwCard);
                                            if (throwCard.getType() == AttributeType.DRAW) {
                                                drawPenalty = throwCard.usePower(drawPenalty);
                                            }
                                        } else {
                                            System.out.println("tes");
                                        }

                                        // Handle Multiple Discard
                                        System.out.println("");
                                        System.out.print("Apakah kamu mau mengeluarkan kartu lagi (Y/N) ? ");
                                        runGame = sc.next();
                                        while (!runGame.toLowerCase().equals("n") && !runGame.toLowerCase().equals("y")) {
                                            System.out.println("Input tidak valid!");
                                            System.out.println("");
                                            System.out.print("Apakah kamu mau mengeluarkan kartu lagi (Y/N)? ");
                                            runGame = sc.next();
                                        }

                                    } catch (IndexOutOfBoundsException e) {
                                        System.out.println("Pilihan kartu tidak valid!");
                                    }
                                }
                            } else {
                                System.out.println("Kamu tidak memiliki kartu draw!");
                                for (int i = 0; i < drawPenalty; i++) {
                                    Card Temp = deck.getCard();
                                    currentPlayer.addCard(Temp);
                                    System.out.println("Kartu "+ Temp.printCard() + " ditambahkan ke dalamlist card pemain");
                                }
                                drawPenalty = 0;
                            }
                            isTurn = false;
                        }
                        
// ************************************************** List Pemain **************************************************//
                        
                    } else if (runGame.equals("3")) {
                        System.out.println("List Pemain: ");
                        game.listPlayer(setupGame.player, currentPlayerOrder);
                        System.out.println(" ");

// ************************************************** Urutan Pemain **************************************************//

                    } else if (runGame.equals("4")) {
                        System.out.println("Urutan pemain: ");
                        game.viewPlayer(setupGame.player, currentPlayerOrder);
    
// ************************************************** Ambil karu dari Deck **************************************************//

                    } else if (runGame.equals("5")) {
                        if (drawPenalty == 0) {
                            System.out.println("Kamu mengambil sebuah kartu dari deck");
                            Card fromDeck = deck.getCard();
                            System.out.println("Kartu yang kamu peroleh dari deck adalah " + fromDeck.printCard());
                            currentPlayer.addCard(fromDeck);
    
                            if (temp.checkIsValid(fromDeck, tableCard)) {
                                System.out.println(
                                        "Apakah kamu ingin mengeluarkan kartu yang diperoleh dari deck (Y/N)? ");
                                String decision = sc.nextLine();

                                // tadi make .equals gatahu kenapa gabisa
                                List<String> acceptedAnswers = Arrays.asList("y", "n");

                                do {
                                    System.out.println("Mohon masukkan opsi Y/N.");
                                    decision = sc.next();
                                } while (!acceptedAnswers.contains(decision));

                                if (decision.toLowerCase().equals("y")) {
                                    if (fromDeck.getType() == AttributeType.REVERSE) {
                                        playerOrder = fromDeck.usePower(playerOrder);
                                    } else if (fromDeck.getType() == AttributeType.SKIP) {
                                        currentPlayerOrder = fromDeck.usePower(currentPlayerOrder);
                                    } else if (fromDeck.getType() == AttributeType.DRAW) {
                                        drawPenalty = fromDeck.usePower(drawPenalty);
                                    } 
                                    if (fromDeck.getColor() == AttributeColor.BLACK) {
                                        game.getColorOption();
                                        int tempColor = sc.nextInt();
                                        fromDeck.setColor(AttributeColor.values() [tempColor-1]);
                                    } 
                                    tableCard = fromDeck;
                                    System.out.println("Kartu dikeluarkan");
                                }
                                // System.out.println("Kartu dikeluarkan");
                                else {
                                    // tes kartu disimpan
                                    System.out.println("Kartu disimpan.");
                                }

                            }
                            System.out.println("\nGiliran selesai");
                            isTurn = false;
                        } else {
                            System.out.println("Kamu terkena penalty draw sebanyak " + drawPenalty);
                            for (int i = 0 ; i < drawPenalty; i++) {
                                Card fromDeck = deck.getCard();
                                System.out.println("Kartu yang kamu peroleh dari deck adalah " + fromDeck.printCard());
                                currentPlayer.addCard(fromDeck);
                            }
                            System.out.println("Giliran selesai");
                            drawPenalty = 0;
                            isTurn = false;
                        }

// ************************************************** Declare Hiji **************************************************//

                    } else if (runGame.equals("6")) {
                        System.out.println("Declare Hiji");
                        currentPlayer.declareHiji();
                        System.out.println(" ");

// ************************************************** Bantuan **************************************************//

                    } else if (runGame.equals("7")) {
                        game.help();
                        System.out.println(" ");
                        
// ************************************************** Else **************************************************//

                    } else if (runGame.equals("cheat")) {
                        winner = currentPlayer;
                        isTurn = false;
                        
                    } else {
                        System.out.println("Command tidak valid!");
                        System.out.println(" ");

                    }

// ************************************************** Conditional Changing Player **************************************************//

                    // Conditional sebelum ganti pemain selanjutnya
                    if (winner != null) {
                        System.out.println("");
                        System.out.println("Pemenang permainan HIJI adalah " + winner.getName());
                        Game.clearScreen();
                        
                    } else if (isTurn) {
                        game.listCommand();
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
            currentPlayerOrder = (currentPlayerOrder + playerOrder + setupGame.jumlahPemain) % setupGame.jumlahPemain; 
            currentPlayer = setupGame.player[currentPlayerOrder];
        }

// ************************************************** End Game **************************************************//

        System.out.println("Terima kasih telah bermain HIJI!");
        System.out.println("Selamat kepada " + winner.getName() + " sebagai pemenang game kali ini!");

        sc.close();
    }
}