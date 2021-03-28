public class CardSkip extends Card {
    private int power;

    public CardSkip() {
        super();

        setColor(AttributeColor.values() [(int) ((Math.random() * 1) + 1)]);
        setType(AttributeType.SKIP);
        setValue(0);
    }

    @Override
    public int usePower(int i) {
        return i += 1;
    }
}

