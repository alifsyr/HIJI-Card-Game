import java.util.ArrayList;
import java.util.List;

//inheritance playerCard
public class PlayerCard {
    // Atribut
    private Boolean cardAvail = false;
    private Card playingCard;

    private final List<Card> playerCardList = new ArrayList<Card>(); // belom ada array list card

    // method mengambil kartu
    public List<Card> getKartu() {
        return playerCardList;
    }

    // method menghitung sisa kartu player
    public int getCardLeft() {
        // belum ada array list card
        int count = playerCardList.size();
        return count;
    }

    // method mengecek kartu yang tersedia
    public void checkCard(Card card) {
        if (playerCardList.contains(card)) {
            System.out.println("Kartu tersedia");
            this.cardAvail = true;
            return;
        }
        System.out.println("Kartu tidak tersedia!");
    }

    // method menambahkan kartu
    public void addCard(Card newCard) {
        playerCardList.add(newCard);
    }

    // method mengeluarkan kartu
    public Card throwCard(Card card) {
        checkCard(card);
        if (this.cardAvail == true) {
            Card playingCard = card;
            playerCardList.remove(card);
            return playingCard;
        }
        return playingCard;
    }
}