import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class TesCard {
    public static void main(String args[]) {

        WildCard wildcard = new WildCard();
        System.out.println("color " + wildcard.getColor());
        System.out.println("type " + wildcard.getType());
        System.out.println("value " + wildcard.getValue());

        PowerCard powercard = new PowerCard();
        System.out.println("color " + powercard.getColor());
        System.out.println("type " + powercard.getType());
        System.out.println("value " + powercard.getValue());

        NumberCard numbercard = new NumberCard();
        System.out.println("color " + numbercard.getColor());
        System.out.println("type " + numbercard.getType());
        System.out.println("value " + numbercard.getValue());

        DrawCard drawcard = new DrawCard();
        System.out.println("color " + drawcard.getColor());
        System.out.println("type " + drawcard.getType());
        System.out.println("value " + drawcard.getValue());

//        CardAttribute<Color, Type> cardDeck = new CardAttribute<Color, Type>();
        CardAttribute cardDeck = (CardAttribute) drawcard;
        System.out.println("color " + cardDeck.getColor());
        System.out.println("type " + cardDeck.getType());
        System.out.println("value " + cardDeck.getValue());
        cardDeck.usePower();
    }
}
