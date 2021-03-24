abstract class CardAttribute {
    private int value = 0;
    private int color = 0;
    /* Color Guide
        No Color    = 0
        Blue        = 1
        Green       = 2
        Yellow      = 3
        Red         = 4
     */
    private int type = 0;
    /* Type Guide
        Normal  = 0
        Draw    = 1
        Reverse = 2
        Skip    = 3
        WildCard= 4
     */

    // Konstruktor
    public CardAttribute() {
    }

    // Setter
    public void setValue(int value) {
        this.value = value;
    }
    public void setColor(int color) {
        this.color = color;
    }
    public void setType(int type) {
        this.type = type;
    }

    // Getter
    public int getValue(){
        return value;
    }
    public int getColor() {
        return color;
    }
    public int getType() {
        return type;
    }
}
