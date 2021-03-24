import java.util.Random;

public class TesCard {
    public static void main(String args[]) {
        WildCard card = new WildCard();
        System.out.println("color " + card.getColor());
        System.out.println("type " + card.getType());
        System.out.println("value " + card.getValue());
    }
}
