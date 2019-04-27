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
        Protagonist p = new Protagonist("Lireelf", 100, 50, 100, 100, 0, 2, 25, 20, 40, 20);
        // Monstros
        Monsters goblin = new Monsters("Goblin", 10, 100, 60, 0, 0);
        Monsters orc = new Monsters("Orc", 10, 100, 60, 0, 0);
        Monsters ogro = new Monsters("Ogro", 10, 100, 60, 0, 0);
        Monsters lord_goblin = new Monsters("Lord Goblin", 10, 100, 60, 0, 0);
        // Localizações
        Location locations = new Location();
        Location guilda = new Location("description", "Guilda", "objective", 0);
        Location florest = new Location("description", "Floresta de Rammith", "objective", 1);
        Location monstersGroups = new Location("description", "Caverna Rasa", "objective", 2);
        Location rammith = new Location("description", "Rammith", "objective", 6);
        Location akatosh = new Location("description", "Monte Akatosh", "objective", 7);
        Location cave = new Location("description", "Caverna de Monstros", "objective", 3);
        Location skellige = new Location("description", "Skellige", "objective", 10);
        Location skelligeFlorest = new Location("description", "Pântano de Skellige", "objective", 11);
        Location jumanju = new Location("description", "Cidade perdida de Jumanju", "objective", 12);
        locations.adLocation(guilda);
        locations.adLocation(florest);
        locations.adLocation(monstersGroups);
        locations.adLocation(rammith);
        locations.adLocation(akatosh);
        locations.adLocation(cave);
        locations.adLocation(skellige);
        locations.adLocation(skelligeFlorest);
        locations.adLocation(jumanju);
        // Armadilhas
        Trap poison = new Trap("Veneno", 5);
        Trap arrow = new Trap("Flechas", 5);
        Trap gas = new Trap("Gás", 5);
        Trap trap = new Trap("Arataca", 5);
        do {
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
                p.toString();
                break;

            case "LOOK MONSTER":

                break;

            case "ATTACK":

                break;

            case "RUN":
                p.run();
                break;

            case "MAP":

                break;

            case "LOOK OBJECTIVE":
                p.lookObjective();
                break;

            case "LOOK COMANDS":
                p.lookComands();
                break;

            default:
                System.out.println("Por favor digite um comando válido!!\n");
                p.lookComands();
                break;
            }

        } while (way != "EXIT");

    }
}