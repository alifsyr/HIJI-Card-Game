public class WildCard extends CardAttribute {
    private int power;

    public WildCard() {
        super();
        setColor(Color.BLACK);
        setType(Type.WILDCARD);
        setValue(0);
    }

    @Override
    public void usePower() {

    }
}
