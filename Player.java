public class Player extends PlayerCard{
    private final String name;
    private Boolean isHiji;

    // Atribut class player
    public Player(String name){
        super();
        this.name = name;
    }

    // Method menapatkan nama
    public String getName(){
        return this.name;
    }

    // Method mengucapkan Hiji
    public void declareHiji(){
        this.isHiji = true;
    }
}
