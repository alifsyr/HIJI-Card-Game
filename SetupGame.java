import java.util.Random;
import java.util.Scanner;

class SetupGame {
    // atribut
    Card tableCard;
    player[] player;
    int jumlahPemain;

    // method untuk melakukan pengacakan kartu di cardDeck
    public void shuffleDeck() {

    }

    // method untuk melakukan pembagian kartu ketiap player
    // + 1 kartu untuk di table
    public void distributeCard() {

    }

    // method untuk mendapatkan jumlah pemain
    // dan menerima nama pemain.
    public void getPlayer() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Ada berapa pemain?");
        int jumlahPemain = sc.nextInt();

        while (jumlahPemain <= 1 || jumlahPemain >= 7) {
            System.out.println("Maaf, hanya jumlah pemain diantara 2-6 yang diperbolehkan.");
            System.out.println("Silahkan masukkan jumlah pemain.");
            jumlahPemain = sc.nextInt();
        }

        player = new player[jumlahPemain];

        for (int i = 0; i < jumlahPemain; i++) {
            System.out.println("Masukkan nama pemain " + (i + 1) + " : ");
            String namaPemain = sc.next();

            player[i] = new player(namaPemain);
        }
        System.out.println("Berikut daftar pemain.");

        for (int i = 0; i < player.length; i++) {
            System.out.println((i + 1) + ". " + player[i].getName());
        }
        System.out.println("Selamat bermain!");
        sc.close();
    }

    // method untuk mendapatkan kartu di meja dari cardDeck
    Card getTableCard() {

    }

    // untuk dapetin pemain yang main pertama kali secara acak.
    // tinggal diubah jadi type player
    player getFirstPlayer() {
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
