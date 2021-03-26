public class DrawCard extends CardAttribute{
    private int power;

    public DrawCard() {
        super();
        setType(Type.DRAW);
        int value = (int) (Math.random() * 2);
        if (value == 1) {
            setValue(2);
        } else {
            setValue(4);
        }
        if (getValue() == 4) {
            setColor(Color.BLACK);
        } else {
            setColor(Color.values() [(int) ((Math.random() * 4) + 1)]);
        }
    }

    @Override
    public void usePower() {
        System.out.println("tes");
    }
}
