import java.util.ArrayList;
import java.util.Scanner;

public class TesCard {
    public static void main(String args[]) {
        ArrayList<Card> card = new ArrayList<Card>();
        ArrayList<String> player = new ArrayList<String>();
        int playerOrder = 1;
        int currentDrawCard = 0;
        int currentPlayer = 0;
        AttributeColor tableCardColor;

        // Inisiasi Pemain
        player.add("Pemain 1");
        player.add("Pemain 2");
        player.add("Pemain 3");
        player.add("Pemain 4");

        CardWild wildcard = new CardWild();
        card.add((Card) wildcard);                                  // Typecasting
        System.out.print("color " + wildcard.getColor());
        System.out.print(" type " + wildcard.getType());
        System.out.println(" value " + wildcard.getValue());

        CardSkip skipcard = new CardSkip();
        card.add((Card) skipcard);                                  // Typecasting
        System.out.print("color " + skipcard.getColor());
        System.out.print(" type " + skipcard.getType());
        System.out.println(" value " + skipcard.getValue());

        CardReverse reversecard = new CardReverse();
        card.add((Card) reversecard);                                  // Typecasting
        System.out.print("color " + reversecard.getColor());
        System.out.print(" type " + reversecard.getType());
        System.out.println(" value " + reversecard.getValue());

        CardNumber numbercard = new CardNumber();
        card.add((Card) numbercard);                                  // Typecasting
        System.out.print("color " + numbercard.getColor());
        System.out.print(" type " + numbercard.getType());
        System.out.println(" value " + numbercard.getValue());

        CardDraw drawcard = new CardDraw();
        card.add((Card) drawcard);                                  // Typecasting
        System.out.print("color " + drawcard.getColor());
        System.out.print(" type " + drawcard.getType());
        System.out.println(" value " + drawcard.getValue());

        // Looping through card
        for(Card c : card) {
            System.out.println("type card " + c.getType());
        }

        // Check usePower CardDraw
        currentDrawCard = drawcard.usePower(currentDrawCard);
        System.out.println("currentDrawCard " + currentDrawCard);

        // Check usePower CardSkip
        System.out.println(player.get(currentPlayer));
        currentPlayer = card.get(1).usePower(currentPlayer);
        currentPlayer++;
        System.out.println(card.get(1).getType() + " -> " + currentPlayer);
        System.out.println(player.get(currentPlayer));

        // Check usePower CardReverse
        playerOrder = card.get(2).usePower(playerOrder);
        System.out.println(card.get(2).getType() + " -> " + playerOrder);

        // Check usePower CardWild
        Scanner sc = new Scanner(System.in);
        System.out.println("1. Red");
        System.out.println("2. Blue");
        System.out.println("3. Green");
        System.out.println("4. Yellow");
        int choosenColor = sc.nextInt();
        tableCardColor = AttributeColor.values() [choosenColor];
        System.out.println(tableCardColor);
    }
}
