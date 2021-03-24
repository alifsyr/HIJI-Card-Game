public class PowerCard extends CardAttribute implements CardPower{
    private int power;

    public PowerCard() {
        super();
        setColor((int) ((Math.random() * 5) + 1));
        int type = (int) ((Math.random() * 2) + 2);
        setType(type);
        setValue(0);
    }

    @Override
    public void usePower() {

    }
}

