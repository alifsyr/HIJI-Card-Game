public class CardReverse extends Card {
    private int power;

    public CardReverse() {
        super();
        setColor(AttributeColor.values() [(int) ((Math.random() * 1) + 1)]);
        setType(AttributeType.REVERSE);
        setValue(0);
    }

    @Override
    public int usePower(int i) {
        return i *= -1;
    }
}

