public class DrawCard extends CardAttribute implements CardPower{
    private int power;

    public DrawCard() {
        super();
        setColor((int) ((Math.random() * 5) + 1));
        setType(1);
        int value = (int) (Math.random() * 2);
        if (value == 1) {
            setValue(2);
        } else {
            setValue(4);
        }
    }

    @Override
    public void usePower() {

    }
}
