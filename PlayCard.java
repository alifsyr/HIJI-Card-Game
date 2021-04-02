import java.util.ArrayList;

public class PlayCard {

    private ArrayList<Card> cardList = new ArrayList<>();

    public PlayCard() {

    }

    public boolean checkIsValid(Card out, Card current) {
        if (out.getType() != current.getType()) {
            return false;
        }
        if (out.getValue() == current.getValue()) {
            return true;
        } else if (out.getColor() == current.getColor()) {
            if (cardList.size() > 1) {
                return cardList.get(cardList.size()-1).getColor() == out.getColor();
            } else {
                return true;
            }
        }
        return false;
    }

    public void addCard(Card card) {
        if (cardList.size() != 0) {
            if (checkIsValid(card, cardList.get(cardList.size()-1))) {
                cardList.add(card);
            } else {
                System.out.println("Kamu tidak bisa mengeluarkan kartu tersebut!");
            }
        } else {
            cardList.add(card);
        }
        System.out.println("last card " + cardList.get(cardList.size()-1).printCard());
    }

    public void getPower() {

    }

    public ArrayList<Card> discard() {
        return cardList;
    }

    public Card getLastCard(){
        System.out.println("card " + cardList.get(cardList.size()-1).printCard());
        return cardList.get(cardList.size()-1);
    }
}
