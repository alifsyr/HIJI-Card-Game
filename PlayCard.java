import java.util.ArrayList;

public class PlayCard {

    private ArrayList<Card> cardList = new ArrayList<>();

    public PlayCard(Card tableCard) {
        cardList.add(tableCard);
    }

    public boolean checkIsValid(Card out, Card dimeja) {
        if (cardList.size() > 1) { // Kalau multiple discard
            Card temp = cardList.get(cardList.size() - 1);
            // System.out.println("card compare " + temp.printCard());
            // System.out.println("list card saat ini pas mau mult discard:");
            // for (Card c : cardList) {
            //     System.out.println(c.printCard());
            // }
            System.out.println("");
            return out.getType() == temp.getType() && out.getColor() == temp.getColor() && out.getValue() == temp.getValue();
        } else {
            if (out.getType() == AttributeType.WILDCARD) // Cek kalo kita mau keluarin wildcard
                return true;

            else if (dimeja.getType() == AttributeType.WILDCARD) // Cek kalo di table lagi wild card
                return dimeja.getColor() == out.getColor() || out.getColor() == AttributeColor.BLACK;

            else if (dimeja.getType() == AttributeType.DRAW && dimeja.getValue() == 4) // Cek kalo di table Draw +4
                // return out.getType() == AttributeType.DRAW && out.getValue() == 4;
                return out.getColor() == dimeja.getColor();
            
            else if (out.getType() == AttributeType.DRAW && out.getValue() == 4) // Cek kalo mau keluarin +4
                return dimeja.getType()!= AttributeType.DRAW && dimeja.getValue()!= 2;

            else if (dimeja.getType() == AttributeType.NUMBER && out.getType()!= AttributeType.NUMBER)
                return dimeja.getColor() == out.getColor();
            
            else if (dimeja.getType() == out.getType() && dimeja.getType() != AttributeType.NUMBER) // Cek kalo di table reverse/ draw/ skip
                return true;
            
            else if (out.getType() != AttributeType.NUMBER)
                return out.getColor() == dimeja.getColor(); 
            
            else if (out.getColor() == dimeja.getColor()) // Cek kalo warna sama
                return true;
            
            else if (out.getValue() == dimeja.getValue()) // cek kalo angka sama
                return true;
            
            else
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
        // System.out.println("list card saat ini:");
        // for (Card c : cardList) {
        //     System.out.println(c.printCard());
        // }
        System.out.println("");
        return true;
    }

    public int length() {
        return cardList.size();
    }

    public ArrayList<Card> discard() {
        return cardList;
    }

    public Card getLastCard() {
        // System.out.println("card " + cardList.get(cardList.size() - 1).printCard());
        return cardList.get(cardList.size() - 1);
    }
}
