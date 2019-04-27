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
    private String nome;
    private int ataque;
    private int defesa;
    private int vida;
    private int armadura;
    private final int max_arm = 100;
    private final int max_vida = 100;
    protected Location location;

    Character(String nome, int ataque, int defesa, int vida, int armadura, Location location) {
        this.nome = nome;
        this.ataque = ataque;
        this.defesa = defesa;
        this.vida = vida;
        this.armadura = armadura;
        this.location = location;
    }

    @Override
    public String toString() {
        return "\n\tStatus " + "\nAtaque: " + ataque + "   Defesa: " + defesa + "\nVida: " + vida + "/" + max_vida
                + "   Armadura: " + armadura + "/" + max_arm;
    }

    public String getNome() {
        return nome;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public int getDefesa() {
        return defesa;
    }

    public void setDefesa(int defesa) {
        this.defesa = defesa;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }
}
