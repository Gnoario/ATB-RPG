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
public class Jogo_RPG {

    public static void main(String[] args) {

        Personagem p = new Personagem(100, 50, 100, 100);
        System.out.println("" + p);
        Monstro m = new Monstro(10, 100, 60, 0);
        System.out.println(m.random(5, 10));

        Batalha b = new Batalha();
        b.batalha(0, 0, 0);
    }
}
