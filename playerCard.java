import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

//inheritance playerCard
public class playerCard{
    // Atribut

    private final List<Card> playerCardList = new ArrayList<>(); //belom ada array list card

    // method mengambil kartu
    // masih gak ngerti

    // method menghitung sisa kartu player
    public int getCardLeft(){
        // belum ada array list card
        int count = 0;
        return count;
    }

    // method mengecek kartu yang tersedia
    public void checkCard(Card card){

    }

    // method menambahkan kartu
    //belom ada array list card
    public void addCard(Card newCard){
        playerCardList.add(newCard);
    }

    // method mengeluarkan kartu
    public void throwCard(){

    }
}