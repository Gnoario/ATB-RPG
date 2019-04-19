/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogo_rpg;

/**
 *
 * @author natha
 */
public class Personagem {

    private int ataque;
    private int defesa;
    private int vida;
    private int armadura;
    private final int max_arm = 100;
    private final int max_vida = 100;

    Personagem(int ataque, int defesa, int vida, int armadura) {
        this.ataque = ataque;
        this.defesa = defesa;
        this.vida = vida;
        this.armadura = armadura;
    }

    @Override
    public String toString() {
        return "\n\tStatus " + "\nAtaque: " + ataque + "   Defesa: " + defesa + "\nVida: " + vida + "/" + max_vida + "   Armadura: " + armadura + "/" + max_arm;
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
