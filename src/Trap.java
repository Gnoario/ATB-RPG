public class Trap{
    private String name;
    private int damage;

    public Trap(String name, int damage){
        this.name = name;
        this.damage = damage;
    }

    public String getName(){
        return name;
    }

    public int getDamage(){
        return damage;
    }
}