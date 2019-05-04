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
        // Nome/ataque/defesa/vida/vida_max/armadura/location/gold/special/aljavaMax
        Protagonist p = new Protagonist("Lireelf", 100, 50, 100, 400, 100, 0, 100, 2, 20);

        // Monstros
        // Nome/Ataque/defesa/vida/vida_max/armadura/location/gold/numero_monstros/locationsAux=>/2/3
        Monster goblin = new Monster("Goblin", 5, 1, 20, 60, 0, 3, 70, 1, 2, 7, 11);
        Monster orc = new Monster("Orc", 6, 2, 25, 25, 0, 3, 90, 1, 2, 7, 11);
        Monster ogro = new Monster("Ogro", 7, 2, 25, 25, 0, 12, 90, 1, 2, 7, 11);
        Monster lord_goblin = new Monster("Lord Goblin", 10, 5, 300, 300, 0, 12, 200, 1, 3, 3, 12);

        // Localizações
        // Descrição/Tag/Objetivo/localização
        Location location = new Location();
        Location guilda = new Location(location.getDescriptionFile("0"), "Guilda", location.getObjectiveFile("0"), 0);
        Location florest = new Location(location.getDescriptionFile("1"), "Floresta de Rammith",
                location.getObjectiveFile("1"), 1);
        Location monstersGroups = new Location(location.getDescriptionFile("2"), "Caverna Rasa",
                location.getObjectiveFile("2"), 2);
        Location rammith = new Location(location.getDescriptionFile("6"), "Rammith", location.getObjectiveFile("6"), 6);
        Location akatosh = new Location(location.getDescriptionFile("7"), "Monte Akatosh",
                location.getObjectiveFile("7"), 7);
        Location cave = new Location(location.getDescriptionFile("3"), "Caverna de Monstros",
                location.getObjectiveFile("3"), 3);
        Location skellige = new Location(location.getDescriptionFile("10"), "Skellige", location.getObjectiveFile("10"),
                10);
        Location skelligeFlorest = new Location(location.getDescriptionFile("11"), "Pântano de Skellige",
                location.getObjectiveFile("11"), 11);
        Location jumanju = new Location(location.getDescriptionFile("12"), "Cidade perdida de Jumanju",
                location.getObjectiveFile("12"), 12);

        // Armadilhas
        // Nome/Dano
        Trap poison = new Trap("Veneno", 5);
        Trap arrow_Trap = new Trap("Flechas", 5);
        Trap gas = new Trap("Gás", 5);
        Trap trap = new Trap("Arataca", 5);

        // Objetos disponíveis
        // nome/atributo/preço
        Object sword = new Object("Espada", 20, 50);
        Object lance = new Object("Lança", 25, 70);
        Object potion = new Object("Poção", 20, 20);
        Object arch = new Object("Arco", 10, 40);
        Object arrow = new Object("Flecha", 30, 10);
        Object armorRepair = new Object("Reparador de armadura", 10, 20);

        // adicionando monstros aos locais
        location.addMonsters(goblin);
        location.addMonsters(orc);
        location.addMonsters(ogro);
        location.addMonsters(lord_goblin);

        // adiocionando armadilhas nos locais
        location.addTraps(poison);
        location.addTraps(arrow_Trap);
        location.addTraps(gas);
        location.addTraps(trap);

        // adicionando itens à loja
        location.addItem_Store(sword);
        location.addItem_Store(lance);
        location.addItem_Store(potion);
        location.addItem_Store(arch);
        location.addItem_Store(arrow);
        location.addItem_Store(armorRepair);

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
        location.addProtagonist(p);

        // Menu
        System.out.println("\tBem-vindo ao jogo\n"
                + "Em qualquer momento você pode executar o comando LOOK COMANDS para olhar os comandos disponíveis.\n");
        System.out.println(
                "Você inicia o jogo na guilda, a qualquer momento você pode olhar o mapa ou olhar a descrição do local\n");
        System.out.println("\nPor favor digite um comando inicial: \n");
        do {
            if (p.getHealth() == 0) {
                System.out.println("Sua vida chegou a 0\n");
                String exit = "EXIT";
                way = exit;
            }
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
                System.out.println(location.lookMonsters());
                break;

            case "ATTACK":
                location.battle();
                break;

            case "RUN":
                p.run();
                System.out.println("Você retorna emergencialmente para o ponto inicial.");
                break;

            case "MAP":
                System.out.println(p.lookMap());
                break;

            case "INVENTORY":
                String use;
                Scanner equip = new Scanner(System.in);
                do {
                    p.seeBag();
                    System.out.println("Digite o item que deseja equipar, ou digite BACK para sair: ");
                    use = equip.nextLine();
                    p.equip(use);
                } while (!use.equalsIgnoreCase("BACK"));
                break;

            case "BUY":
                if (p.getLocation() == 0) {
                    String item;
                    Scanner buy = new Scanner(System.in);
                    do {
                        location.store();
                        System.out.println("Digite o item que deseja comprar, ou digite BACK para sair: ");
                        item = buy.nextLine();
                        location.buyItem(item);
                    } while (!item.equalsIgnoreCase("BACK"));
                } else {
                    System.out.println("Para entrar na loja, retorne para guilda.");
                }
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

        } while (!way.equalsIgnoreCase("EXIT"));

    }
}