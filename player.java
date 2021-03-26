public class player extends playerCard{
    private final String name;
    private final Boolean isHiji;

    // Atribut class player
    public player(String name, Boolean isHiji){
        this.name = name;
        this.isHiji = isHiji;
    }

    // Method menapatkan nama
    public String getName(){
        return this.name;
    }

    // Method mengucapkan Hiji
    public void declareHiji(){
        if(isHiji){
            getName(); // mengambil nama pemenang
        }
        else{
            addCard() // mungkin(?)
        }
    }
}
