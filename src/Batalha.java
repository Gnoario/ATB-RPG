/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogo_rpg;

import java.awt.BorderLayout;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author natha
 */
public class Batalha {

    Scanner scanner = new Scanner(System.in);

    public void batalha(Monstro m, Personagem p, int atm, int defm, int vidm) {
        //Fazer o método que realiza as batalhas entre o personagem e os monstros.
        Random r = new Random();

        System.out.println("\n\t\t\tSeus Atributos");
        System.out.println("Ataque: " + p.getAtaque());
        System.out.println("Defesa: " + p.getDefesa());
        System.out.println("Vida: " + p.getVida() + "\n");

        m.setAtaque(atm + r.nextInt(50));
        m.setDefesa(defm + r.nextInt(30));
        m.setVida(vidm + r.nextInt(100));

        System.out.println("\t\t\tAtributos Iniciais Inimigo");
        System.out.println("Ataque Monstro: " + m.getAtaque());
        System.out.println("Defesa Monstro: " + m.getDefesa());
        System.out.println("Vida Monstro: " + m.getVida() + "\n");
        int i = 0;

        System.out.println("\t\t\t---------- BATALHA ----------\n");
        do {
            int dano = (p.getAtaque() - m.getAtaque());
            int critical = r.nextInt(10);
            System.out.println("Numero sorteado: " + critical);
            if (critical == 7) {
                System.out.println("Causou dano crítico (+50).");
                dano = dano + 50;
            }

            if (dano <= 0) {
                System.out.println("Dano\n");
                dano = 0;
                int control = (p.getAtaque() / 2);
                int quebraDef = r.nextInt(control);
                int defesa = m.getDefesa() - quebraDef;
                System.out.println("Defesa do inimigo diminuida para: " + defesa);
            }

            System.out.println("Dano: " + dano + "\n");
            int vidaM = (m.getVida() - dano);
            System.out.println("Vida restante: " + vidaM);
            if (vidaM <= 0) {
                System.out.println("O inimigo foi destruído");
            } else {
                //Iniciando a defesa
                dano = m.getAtaque() - p.getAtaque();
                critical = r.nextInt(10);
                if (critical == 7) {
                    System.out.println("Sofreu dano crítico (+50)");
                    dano = dano + 50;
                }
                if (dano <= 0) {
                    System.out.println("Dano\n");
                    dano = 0;
                    int control = m.getAtaque() / 2;
                    int quebradef = r.nextInt(control);
                    int defesa = p.getDefesa() - quebradef;
                    System.out.println("Sua defesa foi diminuída para: " + defesa);
                }
            }
            System.out.println("Dano sofrido = " + dano);
            int vida = (p.getVida() - dano);
            System.out.println("Sua vida restante: " + vida);
            if (p.getVida() == 0 || m.getVida() == 0) {
                System.out.println(" Game Over :( ");
                i = 0;
            }
        } while (i != 0);
    }
}
