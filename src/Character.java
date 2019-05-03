/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author natha
 */
public class Character {
    private String name;
    private int damage;
    private int defense;
    private int health;
    private int arm;
    private final int max_arm = 100;
    private final int max_health;
    private int gold;
    private int location;
    Location locations[] = new Location[9];
    Object bag[] = new Object[30];
    int size = 0;

    Character(String name, int damage, int defense, int health, int max_health, int arm, int location, int gold) {
        this.name = name;
        this.damage = damage;
        this.defense = defense;
        this.health = health;
        this.arm = arm;
        this.location = location;
        this.max_health = max_health;
        this.gold = gold;
    }

    // Status do jogador
    @Override
    public String toString() {
        return "\n\tStatus " + "\nAtaque: " + damage + "   Defesa: " + defense + "\nVida: " + health + "/" + max_health
                + "   Armadura: " + arm + "/" + max_arm;
    }

    /**
     * @return the gold
     */
    public int getGold() {
        return gold;
    }

    /**
     * @param gold the gold to set
     */
    public void setGold(int gold) {
        this.gold = gold;
    }

    public String getName() {
        return name;
    }

    public int getLocation() {
        return location;
    }

    public void setLocation(int location) {
        this.location = location;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getHealth() {
        return health;
    }

    public int getMax_health() {
        return max_health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public Location get(int index) {
        if (index >= 0 && index < size) {
            return locations[index];
        }
        return null;
    }

    // Adiciona localizações ao mapa
    public void adLocation(Location location) {
        if (size >= 0 && size < 9) {
            locations[size] = location;
            size++;
        }
    }

    public void adObject(Object object) {
        int nElements = 0;
        if (nElements >= 0 && nElements < 30) {
            bag[nElements] = object;
            nElements++;
        }
        else{
            System.out.println("\nVocê atingiu o limite máximo do seu inventário\n");
        }
    }
}
