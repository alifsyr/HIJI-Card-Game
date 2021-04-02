import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

class SetupGame extends CardDeck {
    // atribut
    Card tableCard;
    Player[] player;
    int jumlahPemain;
    List<List<Card>> playerCardList = new ArrayList<>();

    // method untuk melakukan pengacakan kartu di cardDeck
    // perlu ditunjukkin deck nya kah (?)
    public void shuffleDeck() {
        Collections.shuffle(cardDeck);
        for (Card c : cardDeck) {
            System.out.print(c.getType() + " ");
            System.out.print(c.getColor() + " ");
            System.out.print(c.getValue() + " ");
            System.out.println("");
        }
        System.out.println("Deck kartu sudah diacak!");
        System.out.println("");
    }

    // method untuk mendapatkan jumlah pemain
    // dan menerima nama pemain.
    public void getPlayer() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Ada berapa pemain?");

        // exception buat input.
        try {
            jumlahPemain = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Harap masukkan bilangan integer!");
            System.out.println("Ulangi permainan.");
            System.exit(0);
        }

        while (jumlahPemain <= 1 || jumlahPemain >= 7) {
            System.out.println("Maaf, hanya jumlah pemain diantara 2-6 yang diperbolehkan.");
            System.out.println("Silahkan masukkan jumlah pemain.");
            jumlahPemain = sc.nextInt();
        }

        player = new Player[jumlahPemain];

        for (int i = 0; i < jumlahPemain; i++) {
            System.out.println("Masukkan nama pemain " + (i + 1) + " : ");
            String namaPemain = sc.next();

            player[i] = new Player(namaPemain);
        }
        System.out.println("Berikut daftar pemain.");

        for (int i = 0; i < player.length; i++) {
            System.out.println((i + 1) + ". " + player[i].getName());
        }
        System.out.println("Selamat bermain!");
        sc.close();
    }

    // method untuk melakukan pembagian kartu ketiap player
    // + 1 kartu untuk di table
    // tinggal remove card dari cardDeck
    public void distributeCard() {
        // for (int i = 0; i < jumlahPemain; i++) {
        // playerCardList = new ArrayList<Card>(7);
        // }

        // for (int i = 0; i < cardDeck.size(); i++) {
        // // int numOfCardsPerPlayer = 7;
        // // int positionInHand = i % numOfCardsPerPlayer;
        // playerCardList.add(cardDeck.get(i));
        // }
        // // for (Card c : playerCardList) {
        // // System.out.print(c.getType() + " ");
        // // System.out.print(c.getColor() + " ");
        // // System.out.print(c.getValue() + " ");
        // // }
        // System.out.println("Deck Pemain 1.");
        // System.out.println("");

        // // for (player arrPlayer : player) {
        // // int deckPemain = cardDeck.size() / jumlahPemain;
        // // for (int i = 0; i < deckPemain; i++) {
        // // arrPlayer.addCard(cardDeck.get(i));
        // // }
        // // System.out.println(arrPlayer);
        // // }

        for (int i = 0; i < jumlahPemain; i++) {
            ArrayList<Card> myGroup = new ArrayList<>();
            playerCardList.add(myGroup);
            for (int j = 0; j < cardDeck.size(); j++) {
                // int numOfCardsPerPlayer = 7;
                // int positionInHand = i % numOfCardsPerPlayer;
                playerCardList.get(i).add(cardDeck.get(j));
            }
        }

        // for (int i = 0; i < jumlahPemain; i++) {
        // for (Card c : playerCardList.get(0)) {
        // System.out.print(c.getType() + " ");
        // System.out.print(c.getColor() + " ");
        // System.out.print(c.getValue() + " ");
        // }
        // }
        // for (int i = 0; i < playerCardList.size(); i++) {
        // for (int j = 0; j < playerCardList.get(j).size(); j++) {
        // for (Card c : playerCardList.get(i)) {
        // c.getType();
        // c.getColor();
        // c.getValue();
        // }
        // }
        // }
        // for (int i = 0; i < playerCardList.size(); i++) {
        //     System.out.println("Deck kartu " + player[i].getName() + ":");
        //     for (int j = 0; j < playerCardList.get(i).size(); j++) {
        //         Card c = playerCardList.get(i).get(j);
        //         System.out.print(c.getType() + " ");
        //         System.out.print(c.getColor() + " ");
        //         System.out.print(c.getValue() + " ");
        //     }
        //     System.out.println("");
        //     System.out.println("Jumlah kartu " + player[i].getName() + ": " + playerCardList.get(i).size());
        //     System.out.println("");
        // }
    }

    // method untuk mendapatkan kartu di meja dari cardDeck
    // sebenarnya tinggal ambil kartu pertama dari hasil shuffle
    // tinggal remove card dari cardDeck
    Card getTableCard() {
        return cardDeck.get(0);
    }

    // untuk dapetin pemain yang main pertama kali secara acak.
    // tinggal diubah jadi type player
    Player getFirstPlayer() {
        Random indeksAcak = new Random();
        int i = indeksAcak.nextInt(player.length);
        return player[i];
    }

    // //method untuk shuffle
    // public void shuffleArray(player[] array) {
    // int n = array.length;
    // Random random = new Random();
    // // Loop over array.
    // for (int i = 0; i < array.length; i++) {
    // // Get a random index of the array past the current index.
    // // ... The argument is an exclusive bound.
    // // It will not go past the array's end.
    // int randomValue = i + random.nextInt(n - i);
    // // Swap the random element with the present element.
    // player randomElement = array[randomValue];
    // array[randomValue] = array[i];
    // array[i] = randomElement;
    // }
    // }
}
