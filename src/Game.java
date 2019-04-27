import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author natha
 */
public class Game {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Declarações
        String way;

        // Protagonista
        // Nome/ataque/defesa/vida/vida_max/armadura/location/special/danoLanca/danoEspada/danoFlecha/aljavaMax
        Protagonist p = new Protagonist("Lireelf", 100, 50, 100,100, 100, 0, 2, 25, 20, 40, 20);

        // Monstros
        // Nome/Ataque/defesa/vida/vida_max/armadura/location
        Monsters goblin = new Monsters("Goblin", 10, 100, 60, 60, 0, 0);
        Monsters orc = new Monsters("Orc", 10, 100, 60, 60, 0, 0);
        Monsters ogro = new Monsters("Ogro", 10, 100, 60, 60, 0, 0);
        Monsters lord_goblin = new Monsters("Lord Goblin", 10, 100, 60, 60, 0, 0);

        // Localizações
        // Descrição/Tag/Objetivo/localização
        Location guilda = new Location("description", "Guilda", "bundinha", 0);
        Location florest = new Location("description", "Floresta de Rammith", "caguei", 1);
        Location monstersGroups = new Location("description", "Caverna Rasa", "objective", 2);
        Location rammith = new Location("description", "Rammith", "perereca", 6);
        Location akatosh = new Location("description", "Monte Akatosh", "objective", 7);
        Location cave = new Location("description", "Caverna de Monstros", "objective", 3);
        Location skellige = new Location("description", "Skellige", "objective", 10);
        Location skelligeFlorest = new Location("description", "Pântano de Skellige", "objective", 11);
        Location jumanju = new Location("description", "Cidade perdida de Jumanju", "objective", 12);

        //adicionando locais para o jogador caminhar pelo mapa
        p.adLocation(guilda);
        p.adLocation(florest);
        p.adLocation(monstersGroups);
        p.adLocation(rammith);
        p.adLocation(akatosh);
        p.adLocation(cave);
        p.adLocation(skellige);
        p.adLocation(skelligeFlorest);
        p.adLocation(jumanju);

        // Armadilhas
        // Nome/Dano
        Trap poison = new Trap("Veneno", 5);
        Trap arrow = new Trap("Flechas", 5);
        Trap gas = new Trap("Gás", 5);
        Trap trap = new Trap("Arataca", 5);

        // Menu
        System.out.println(
                "\n\tBem-vindo ao jogo\n" + "Aqui estão os comandos do jogo, divitar-se!!\n" + p.lookComands());

        do {
            System.out.println("Por favor digite um comando: \n");
            way = scanner.nextLine();
            switch (way) {
            case "UP":
                p.movePlayer(way);
                break;

            case "DOWN":
                p.movePlayer(way);
                break;

            case "LEFT":
                p.movePlayer(way);
                break;

            case "RIGHT":
                p.movePlayer(way);
                break;

            case "STATUS":
                System.out.println(p.toString());
                break;

            case "LOOK MONSTER":

                break;

            case "ATTACK":

                break;

            case "RUN":
                p.run();
                System.out.println("Você retorna emergencialmente para o ponto inicial.");
                break;

            case "MAP":
                System.out.println(p.lookMap());
                break;

            case "LOOK OBJECTIVE":
                System.out.println(p.lookObjective());
                break;

            case "LOOK COMANDS":
                System.out.println(p.lookComands());
                break;

            default:
                System.out.println("Por favor digite um comando válido!!\n");
                System.out.println(p.lookComands());
                break;
            }

        } while (way.equalsIgnoreCase("EXIT"));

    }
}