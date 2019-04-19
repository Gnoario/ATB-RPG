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
public class Batalha {

    private Monstro m;
    private Personagem p;

    public void batalha(int defesa, int ataque, int vida) {
        //Fazer o método que realiza as batalhas entre o personagem e os monstros.
        
        System.out.println("\n\t\t\tSeus atributos:");
        System.out.println("Ataque: " + p.getAtaque());
        System.out.println("Defesa: " + defesa);
        System.out.println("Vida: " + vida);
        
    }

    public Monstro getM() {
        return m;
    }

    public void setM(Monstro m) {
        this.m = m;
    }

    public Personagem getP() {
        return p;
    }

    public void setP(Personagem p) {
        this.p = p;
    }
}
