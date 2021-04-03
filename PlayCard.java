import java.util.ArrayList;

public class PlayCard {

    private ArrayList<Card> cardList = new ArrayList<>();

    public PlayCard(Card tableCard) {
        cardList.add(tableCard);
    }

    public boolean checkIsValid(Card out, Card current) {
        if (out.getType() == AttributeType.WILDCARD) {
            return true;
        } else {
            if (out.getType() != current.getType()) {
                return false;
            }
            if (out.getValue() == current.getValue()) {
                return true;
            } else if (out.getColor() == current.getColor()) {
                if (cardList.size() > 1) {
                    return cardList.get(cardList.size() - 1).getColor() == out.getColor();
                } else {
                    return true;
                }
            }
            return false;
        }
    }

    public boolean addCard(Card card) {
        if (checkIsValid(card, cardList.get(cardList.size() - 1))) {
            cardList.add(card);
        } else {
            System.out.println("Kamu tidak bisa mengeluarkan kartu tersebut!");
            System.out.println("kartu yang tidak bisa dikeluarkan " + card.printCard());
            return false;
        }

        // System.out.println("last card " +
        // cardList.get(cardList.size()-1).printCard());
        System.out.println("list card saat ini:");
        for (Card c : cardList) {
            System.out.println(c.printCard());
        }
        return true;
    }

    public void getPower(int X) {

    }

    public ArrayList<Card> discard() {
        return cardList;
    }

    public Card getLastCard() {
        System.out.println("card " + cardList.get(cardList.size() - 1).printCard());
        return cardList.get(cardList.size() - 1);
    }
}
