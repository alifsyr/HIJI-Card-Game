import java.util.Random;
public class cardDeck {


    //method buat narik kartu random
    public getCard() {
        Random rand = new Random();
        //Jumlah jenis kartunya
        int upperbound = 54;
        int int_random = rand.nextInt(upperbound);
        //Hasil random ntar diubah ke kartunya
        System.out.println(int_random); //Contoh random
    }
}
