public class cardDeck {
    ArrayList<Card> cardDeck = new ArrayList<Card>();
    // Create Deck --> Insert CardNumber
    for(
    var c = 0;c<4;c++)
    {
        for (var i = 1; i < 10; i++) {
            CardNumber newCard = new CardNumber(i, AttributeColor.values()[c]);
            cardDeck.add((Card) newCard);
        }
    }
    // Create Deck --> Insert DrawCard
    for(
    var c = 0;c<4;c++)
    {
        for (var i = 1; i < 3; i++) {
            CardDraw newDrawCard = new CardDraw(2, AttributeColor.values()[c]);
            cardDeck.add((Card) newDrawCard);
            CardSkip newSkipCard = new CardSkip(AttributeColor.values()[c]);
            cardDeck.add((Card) newSkipCard);
            CardReverse newReverseCard = new CardReverse(AttributeColor.values()[c]);
            cardDeck.add((Card) newReverseCard);
        }
    }
    // Create Deck --> Insert Wild & Draw 4
    for(
    var c = 0;c<4;c++)
    {
        CardDraw newDrawCard = new CardDraw(4, AttributeColor.BLACK);
        cardDeck.add((Card) newDrawCard);
        CardWild newWildCard = new CardWild();
        cardDeck.add((Card) newWildCard);
    }
}