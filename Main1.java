import java.util.ArrayList;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args){
        int playerOrder = 1;
        int number = 0;
        int currentPlayer = 0;
        int currentDrawCard = 0;
        Card tableCard;

        ArrayList<Player> playerList = new ArrayList<>();
        playerList.add(new Player("player1"));
        playerList.add(new Player("player2"));

        Scanner sc = new Scanner(System.in);

        CardDeck deck = new CardDeck();
        tableCard = deck.getCard();
        PlayCard play = new PlayCard();

        for (Player p: playerList) {
            for (int i = 0; i < 7; i ++) {
                p.addCard(deck.getCard());
            }
            System.out.println("Kartu player "+ p.getName());
            for (Card c: p.getKartu()) {
                System.out.print(c.printCard() + " | ");
            }
            System.out.println();
        }

        System.out.println("Giliran player: " + playerList.get(currentPlayer).getName());

        number = sc.nextInt();

        while (number < 7) {
            Player playerNow = playerList.get(currentPlayer);
            play.addCard(playerNow.getKartu().get(number-1));
            number = sc.nextInt();
        }

        System.out.println("cardList");
        for (Card c: play.discard()) {
            System.out.println(c.printCard());
        }
    }
}
