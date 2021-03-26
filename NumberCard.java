import java.util.Random;

public class NumberCard extends CardAttribute {
    public NumberCard() {
        super();
        setColor(Color.values() [(int) ((Math.random() * 4) + 1)]);
        setType(Type.NUMBER);
        setValue((int) ((Math.random() * 9) +1));
    }
}
