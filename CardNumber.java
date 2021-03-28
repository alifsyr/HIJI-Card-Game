public class CardNumber extends Card {
    public CardNumber() {
        super();
        setColor(AttributeColor.values() [(int) ((Math.random() * 4) + 1)]);
        setType(AttributeType.NUMBER);
        setValue((int) ((Math.random() * 9) +1));
    }
}
