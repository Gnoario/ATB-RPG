import java.util.Random;
import java.util.Scanner;

public class Combat{

Scanner scanner = new Scanner(System.in);

public void batalha(Monster m, Protagonist p, int atm, int defm, int vidm) {
    //Fazer o método que realiza as batalhas entre o personagem e os monstros.
    Random r = new Random();

    System.out.println("\n\t\t\tSeus Atributos");
    System.out.println("Ataque: " + p.getDamage());
    System.out.println("Defesa: " + p.getDefense());
    System.out.println("Vida: " + p.getHealth() + "\n");

    m.setDamage(atm + r.nextInt(50));
    m.setDefense(defm + r.nextInt(30));
    m.setHealth(vidm + r.nextInt(100));

    System.out.println("\t\t\tAtributos Iniciais Inimigo");
    System.out.println("Ataque Monstro: " + m.getDamage());
    System.out.println("Defesa Monstro: " + m.getDefense());
    System.out.println("Vida Monstro: " + m.getHealth() + "\n");
    int i = 0;

    System.out.println("\t\t\t---------- BATALHA ----------\n");
    do {
        int dano = (p.getDamage() - m.getDamage());
        int critical = r.nextInt(10);
        System.out.println("Numero sorteado: " + critical);
        if (critical == 7) {
            System.out.println("Causou dano crítico (+50).");
            dano = dano + 50;
        }

        if (dano <= 0) {
            System.out.println("Dano\n");
            dano = 0;
            int control = (p.getDamage() / 2);
            int quebraDef = r.nextInt(control);
            int defesa = m.getDefense() - quebraDef;
            System.out.println("Defesa do inimigo diminuida para: " + defesa);
        }

        System.out.println("Dano: " + dano + "\n");
        int vidaM = (m.getHealth() - dano);
        System.out.println("Vida restante: " + vidaM);
        if (vidaM <= 0) {
            System.out.println("O inimigo foi destruído");
        } else {
            //Iniciando a defesa
            dano = m.getDamage() - p.getDamage();
            critical = r.nextInt(10);
            if (critical == 7) {
                System.out.println("Sofreu dano crítico (+50)");
                dano = dano + 50;
            }
            if (dano <= 0) {
                System.out.println("Dano\n");
                dano = 0;
                int control = m.getDamage() / 2;
                int quebradef = r.nextInt(control);
                int defesa = p.getDefense() - quebradef;
                System.out.println("Sua defesa foi diminuída para: " + defesa);
            }
        }
        System.out.println("Dano sofrido = " + dano);
        int vida = (p.getHealth() - dano);
        System.out.println("Sua vida restante: " + vida);
        if (p.getHealth() == 0 || m.getHealth() == 0) {
            System.out.println(" Game Over :( ");
            i = 0;
        }
    } while (i != 0);
}
}