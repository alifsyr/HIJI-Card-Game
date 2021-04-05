import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Declare {
    static int time = 1;


    Timer timer = new Timer();
    TimerTask task = new TimerTask() {

    @Override
    public void run() {
        if (time == 1) {
            System.out.println("Waktu kamu habis, kamu akan mendapat tambahan 2 kartu!");
            System.exit(0);
            }
         }
    };
    timer.schedule(task, 3000);

    System.out.println("Ketik HIJI dalam 3 detik!");

    Scanner sc = new Scanner(System.in);
    String str = sc.nextLine();
    time = 0;


    System.out.println("Berhasil!");
    System.exit(0);
}
