public class DeclareHiji extends Thread {
    int delay = 3000;

    Player currentPlayer;
    CardDeck deck = new CardDeck();

    public DeclareHiji(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public void run() {
        try {
            Thread.sleep(delay);
            System.out.println("\nDeclare HIJI terlambat!");
            System.out.println("Sudah lewat 3 detik!");
            System.out.println("Kamu mendapat dua buah kartu dari deck!");
            currentPlayer.addCard(deck.getCard());
            currentPlayer.addCard(deck.getCard());
        } catch(InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Selamat, berhasil declare HIJI");
            currentPlayer.declareHiji();
        }
    }

    public Player afterDeclare() {
        return currentPlayer;
    }
}
