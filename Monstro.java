/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogo_rpg;

import java.util.Random;

/**
 *
 * @author natha
 */
public class Monstro extends Personagem {

    public Monstro(int ataque, int defesa, int vida, int armadura) {
        super(ataque, defesa, vida, armadura);
    }

    public int random(int min, int max) {
        Random r = new Random();
        return (r.nextInt(max - (min - 1)) + min);
    }
//        Random r = new Random();
//        if (r.nextInt() != 0) {
//            System.out.println(r.nextInt(10));
//            return r.nextInt();
//        }
//        return 0;
//    }
}
