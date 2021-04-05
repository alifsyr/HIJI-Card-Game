import java.util.ArrayList;
import java.util.List;

//inheritance playerCard
abstract class PlayerCard {
    // Atribut

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
        Boolean avail = false; 
        for (Card c : playerCardList) {
            if (c.getType() == AttributeType.WILDCARD){ // Cek kalo kita mau keluarin wildcard
                avail = true;
                // System.out.println("check 1");
            }
            else if (card.getType() == AttributeType.WILDCARD) { // Cek kalo di table lagi wild card
                avail = card.getColor() == c.getColor();
                // System.out.println("check 2");
            }
            else if (card.getType() == AttributeType.DRAW && card.getColor() == AttributeColor.BLACK) { // Cek kalo di table Draw +4
                avail = c.getType() == AttributeType.DRAW && c.getColor() == AttributeColor.BLACK; 
                // System.out.println("check 3");
            }
            else if (card.getType() == c.getType() && card.getType() != AttributeType.NUMBER){ // Cek kalo di table reverse/ draw/ skip
                avail = card.getColor() == c.getColor();
                // System.out.println("check 4");
            }
            else if (c.getType() != AttributeType.NUMBER) {
                avail = c.getColor() == card.getColor(); 
                // System.out.println("check 5");
            }
            else if (c.getColor() == card.getColor()) { // Cek kalo warna sama
                avail = true;
                // System.out.println("check 6");
            }
            else if (c.getValue() == card.getValue()){ // cek kalo angka sama
                avail = true;
                // System.out.println("check 7");
            }
            else {
                avail = false;
                // System.out.println("nop");
            }

            if (avail) {
                // System.out.println("check avail " + c.printCard());
                break;
            }

            // System.out.println("check avail " + c.printCard());
        }
        return avail;
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