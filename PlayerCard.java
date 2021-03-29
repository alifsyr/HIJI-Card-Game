import java.util.ArrayList;
import java.util.List;

//inheritance playerCard
public class PlayerCard{
    // Atribut

    private final List<Card> playerCardList = new ArrayList<Card>(); //belom ada array list card

    // method mengambil kartu
    public List<Card> getKartu() {
        return playerCardList;
    }

    // method menghitung sisa kartu player
    public int getCardLeft(){
        // belum ada array list card
        int count = playerCardList.size();
        return count;
    }

    // method mengecek kartu yang tersedia
    public void checkCard(Card card){
        for (int i = 0; i < playerCardList.size(); i++){
            if(playerCardList.contains(card)){
                throwCard(i,card);
            }
            else{
                System.out.println("Kartu tidak tersedia!");
            }
        }
    }

    // method menambahkan kartu
    //belom ada array list card
    public void addCard(Card newCard){
        playerCardList.add(newCard);
    }

    // method mengeluarkan kartu
    public Card throwCard(int index, Card card){
        Card playingCard = card;
        playerCardList.remove(index);
        return playingCard;
    }
}
