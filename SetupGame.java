import java.util.Arrays;
import java.util.Scanner;

class SetupGame {
    // atribut

    // belum ada abstract class CardAttribute
    // CardAttribute tableCard;

    // belum ada array of player karena belum gabung sama class Player.
    // jadi untuk sementara buatnya array of string dulu.
    String[] player;

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

        while (jumlahPemain <= 1 | jumlahPemain >= 7) {
            System.out.println("Maaf, hanya jumlah pemain diantara 2-6 yang diperbolehkan.");
            System.out.println("Silahkan masukkan jumlah pemain.");
            jumlahPemain = sc.nextInt();
        }

        String[] player = new String[jumlahPemain];

        for (int i = 0; i < jumlahPemain; i++) {
            System.out.println("Masukkan nama pemain " + (i + 1) + " : ");
            String namaPemain = sc.next();

            player[i] = namaPemain;
        }
        System.out.println("Berikut daftar pemain.");
        System.out.println(Arrays.toString(player));
        System.out.println("Selamat bermain!");
        sc.close();
    }

    // belum ada abstract class
    // AttributeCard getTableCard() {

    // }

    // belum ada class Player
    // Player getFirstPlayer() {

    // }
}