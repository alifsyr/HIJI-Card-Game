public class CardAttribute<Color, Type> extends CardPower{
    private int value;
    private Color color;
    private Type type;

    // Setter
    public void setValue(int value) {
        this.value = value;
    }
    public void setColor(Color color) {
        this.color = color;
    }
    public void setType(Type type) {
        this.type = type;
    }

    // Getter
    public int getValue(){
        return value;
    }
    public Color getColor() {
        return color;
    }
    public Type getType() {
        return type;
    }
}
