import java.util.Random;

public class NumberCard extends CardAttribute {
    public NumberCard() {
        super();
        setColor((int) ((Math.random() * 5) + 1));
        setType(0);
        setValue((int) ((Math.random() * 9) +1));
    }
}
