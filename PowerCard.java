public class PowerCard extends CardAttribute{
    private int power;

    public PowerCard() {
        super();

        setColor(Color.values() [(int) ((Math.random() * 4) + 1)]);

        int type = (int) ((Math.random() * 2) + 1);
        if (type == 1) {
            setType(Type.SKIP);
        } else {
            setType(Type.REVERSE);
        }

        setValue(0);
    }

    @Override
    public void usePower() {

    }
}

