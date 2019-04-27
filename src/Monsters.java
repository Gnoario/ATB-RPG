
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Random;

/**
 *
 * @author natha
 */
public class Monsters extends Character {

    public Monsters(String name, int damage, int defense, int health, int max_health, int arm, int location) {
        super(name, damage, defense, health, max_health, arm, location);
    }

    public int random(int min, int max) {
        Random r = new Random();
        return (r.nextInt(max - (min - 1)) + min);
    }

    public void respawnMonsters(){
        
    }
    // Random r = new Random();
    // if (r.nextInt() != 0) {
    // System.out.println(r.nextInt(10));
    // return r.nextInt();
    // }
    // return 0;
    // }
}
