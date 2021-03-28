public class player extends playerCard{
    private final String name;
    private Boolean isHiji;

    // Atribut class player
    public player(String name){
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
