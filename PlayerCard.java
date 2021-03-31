import java.util.ArrayList;
import java.util.List;

//inheritance playerCard
public class PlayerCard {
    // Atribut
    private Boolean cardAvail = false;
    private Card playingCard;

    private final List<Card> playerCardList = new ArrayList<>(); // belom ada array list card

    // method mengambil kartu
    public List<Card> getKartu() {
        return playerCardList;
    }

    // method menghitung sisa kartu player
    public int getCardLeft() {
        // belum ada array list card
        return playerCardList.size();
    }

    // method mengecek kartu yang tersedia
    public Boolean checkCard(Card card) {
        return playerCardList.contains(card);
    }

    // method menambahkan kartu
    public void addCard(Card newCard) {
        playerCardList.add(newCard);
    }

    // method mengeluarkan kartu
    public Card throwCard(Card card) {
        if (checkCard(card)) {
            Card playingCard = card;
            playerCardList.remove(card);
            return playingCard;
        } else {
            return null;
        }
    }
}