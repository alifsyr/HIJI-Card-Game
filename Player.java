public class Player extends PlayerCard {
    // public static Object PlayerCard;
    private final String name;
    private Boolean isHiji = false;

    CardDeck deck = new CardDeck();

    // Atribut class player
    public Player(String name) {
        super();
        this.name = name;
    }

    // Method menapatkan nama
    public String getName() {
        return this.name;
    }

    // Method mengucapkan Hiji
    public void declareHiji() {
        if (getCardLeft() != 1) {
            System.out.println("Kamu tidak bisa declare Hiji sekarang!");
            System.out.println("Kamu mendapatkan penalti 2 kartu dari deck!");
            addCard(deck.getCard());
            addCard(deck.getCard());
        } else {
            System.out.println("Declare Hiji Berhasil");
            this.isHiji = true;
        }
    }

    public Boolean getHiji() {
        return isHiji;
    }
}
