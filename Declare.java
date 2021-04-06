import java.util.Timer;
import java.util.TimerTask;
import java.util.Scanner;

public class teshiji{
    private String str = "";

    public void getInput() throws Exception{
        Timer timer = new Timer();
        timer.schedule( task, 3*1000 );

        System.out.println("Ketik HIJI dalam 3 detik!");
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
    
        timer.cancel();
        System.out.println(str + "berhasil diinput"); 
    }

    TimerTask task = new TimerTask(){
        public void run(){
            if(str.equals("")){
                System.out.println( "Waktu kamu habis, kamu akan mendapat tambahan 2 kartu!" );
                // tambah dua kartu
                System.exit( 0 );
            }
        }    
    };

    public static void main( String[] args){
        try {
            (new teshiji()).getInput();
        } catch( Exception e ){
            System.out.println( e );
            
        }  
    }
}