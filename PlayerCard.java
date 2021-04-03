import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.List;

//inheritance playerCard
public class PlayerCard {
    // Atribut
    private Boolean cardAvail = false;

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
        for (Card c : playerCardList) {
            if (c.getType() == card.getType() || c.getColor() == card.getColor() || c.getValue() == card.getValue()) {
                return true;
            } 
        }
        return playerCardList.contains(new CardWild()) || playerCardList.contains(new CardDraw(4, AttributeColor.BLACK));
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