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
        Protagonist p = new Protagonist("Lireelf", 100, 50, 100, 100, 100, 0, 2, 25, 20, 40, 20);

        // Monstros
        // Nome/Ataque/defesa/vida/vida_max/armadura/location
        Monsters goblin = new Monsters("Goblin", 10, 100, 60, 60, 0, 0);
        Monsters orc = new Monsters("Orc", 10, 100, 60, 60, 0, 0);
        Monsters ogro = new Monsters("Ogro", 10, 100, 60, 60, 0, 0);
        Monsters lord_goblin = new Monsters("Lord Goblin", 10, 100, 60, 60, 0, 0);

        // Localizações
        // Descrição/Tag/Objetivo/localização
        Location location = new Location();
        Location guilda = new Location(location.getDescriptionFile("tag"), "Guilda", location.getObjectiveFile("tag"),
                0);
        Location florest = new Location(location.getDescriptionFile("tag"), "Floresta de Rammith",
                location.getObjectiveFile("tag"), 1);
        Location monstersGroups = new Location(location.getDescriptionFile("tag"), "Caverna Rasa",
                location.getObjectiveFile("tag"), 2);
        Location rammith = new Location(location.getDescriptionFile("tag"), "Rammith", location.getObjectiveFile("tag"),
                6);
        Location akatosh = new Location(location.getDescriptionFile("tag"), "Monte Akatosh",
                location.getObjectiveFile("tag"), 7);
        Location cave = new Location(location.getDescriptionFile("tag"), "Caverna de Monstros",
                location.getObjectiveFile("tag"), 3);
        Location skellige = new Location(location.getDescriptionFile("tag"), "Skellige",
                location.getObjectiveFile("tag"), 10);
        Location skelligeFlorest = new Location(location.getDescriptionFile("tag"), "Pântano de Skellige",
                location.getObjectiveFile("tag"), 11);
        Location jumanju = new Location(location.getDescriptionFile("tag"), "Cidade perdida de Jumanju",
                location.getObjectiveFile("tag"), 12);

        // adicionando locais para o jogador caminhar pelo mapa
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
                "\tBem-vindo ao jogo\n" + "Aqui estão os comandos do jogo, divirta-se!!\n" + p.lookComands());
        System.out.println(
                "\tVocê inicia o jogo na guilda, a qualquer momento você pode olhar o mapa ou olhar a descrição do local\n");
        do {
            System.out.println("\nPor favor digite um comando: \n");
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

            case "LOOK LOCATION":
                System.out.println(p.lookLocation());
                break;

            case "EXIT":
                System.out.println("Adeus até breve!!");
                scanner.close();
                break;

            default:
                System.out.println("Por favor digite um comando válido!!\nDigite LOOK COMANDS para ver os comandos.\n");
                // System.out.println(p.lookComands());
                break;
            }

        } while (!way.equals("EXIT"));

    }
}