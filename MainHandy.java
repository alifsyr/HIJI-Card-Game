import java.util.ArrayList;
import java.util.List;

// driver untuk
// 1. minta jumlah pemain dan masukin nama pemain ke array;
// 2. tentuin pemain pertama yang akan mulai secara acak;
// 3. shuffleDeck
public class MainHandy {

    public static void main(String[] args) {
        SetupGame setupGame = new SetupGame();
        // input player
        System.out.println("");
        setupGame.getPlayer();
        System.out.println("");

        // ngeshuffle
        System.out.println("Shuffling deck...");
        setupGame.shuffleDeck();

        // distribusi kartu
        setupGame.distributeCard();

        // // tablecard
        // System.out.println("Table Card: ");
        // System.out.print(setupGame.getTableCard().getType() + " ");
        // System.out.print(setupGame.getTableCard().getColor() + " ");
        // System.out.print(setupGame.getTableCard().getValue() + " ");
        // System.out.println("");

        // // player pertama
        // System.out.println("Pemain pertama: " +
        // setupGame.getFirstPlayer().getName());
        // System.out.println("");

    }
}
