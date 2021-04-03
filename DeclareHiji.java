public class DeclareHiji extends Thread {
    int delay = 3000;

    public void run() {
        try {
            Thread.sleep(delay);
            System.out.println("kena");
        } catch(InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Selamat, berhasil declare HIJI");
        }
    } 
}
