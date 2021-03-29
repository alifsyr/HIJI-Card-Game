public class CardWild extends Card {
    private int power;

    public CardWild() {
        super();
        setColor(AttributeColor.BLACK);
        setType(AttributeType.WILDCARD);
        setValue(0);
    }

    @Override
    public int usePower(int i) {
        return i;
    }
}