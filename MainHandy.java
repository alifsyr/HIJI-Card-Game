// driver untuk
// 1. minta jumlah pemain dan masukin nama pemain ke array;
// 2. tentuin pemain pertama yang akan mulai secara acak;
public class MainHandy {

    public static void main(String[] args) {
        SetupGame setupGame = new SetupGame();

        setupGame.getPlayer();

        System.out.println("Pemain pertama: " + setupGame.getFirstPlayer().getName());

    }
}
