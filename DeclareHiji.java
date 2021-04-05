public class DeclareHiji extends Thread {
    int delay = 3000;

    Player currentPlayer;

    public DeclareHiji(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public void run() {
        try {
            Thread.sleep(delay);
        } catch(InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Selamat, berhasil declare HIJI");
            successHiji();
        }
    }

    public void successHiji() {
        currentPlayer.declareHiji();
    }

    public Player afterDeclare() {
        return currentPlayer;
    }
}
