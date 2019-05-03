public class Protagonist extends Character {
    int danoLanca;
    int danoEspada;
    int danoFlecha;
    int aljavaMax;
    int special;

    public Protagonist(String name, int damage, int defense, int health, int max_health, int arm, int location,
            int gold, int special, int danoLanca, int danoEspada, int danoFlecha, int aljavaMax) {
        super(name, damage, defense, health, max_health, arm, gold, location);
        this.special = special;
        this.danoLanca = danoEspada;
        this.danoFlecha = danoFlecha;
        this.danoEspada = danoEspada;
        this.aljavaMax = aljavaMax;
    }

    // Olhar objetivo do mapa
    public String lookObjective() {
        String obj = "";
        for (int i = 0; i < locations.length; i++) {
            if (locations[i].getLocationMap() == super.getLocation()) {
                obj = locations[i].getObjective();
            }

        }
        return obj;
    }

    // Olhar o local que você se encontra dentro do jogo e a descrição
    public String lookLocation() {
        String description = "";
        String tag = "";
        for (int i = 0; i < locations.length; i++) {
            if (locations[i].getLocationMap() == super.getLocation()) {
                description = locations[i].getDescription();
                tag = locations[i].getTag();
            }

        }
        return "\n" + tag + "\n" + description;
    }

    // O jogador retorna para guilda, emergencialmente
    public void run() {
        super.setLocation(0);
    }

    // Olhar os comandos disponíveis
    public String lookComands() {
        return "\tLEFT, RIGHT, UP, DOWN -        MOVE\n" + "\tATTACK -       ATTACK MONSTERS\n"
                + "\tSTATUS -       LOOK STATUS PROTAGONIST\n" + "\tLOOK MONSTER - LOOK MONSTERS THE AREA\n"
                + "\tRUN - RUN FOR INIT\n" + "\tEXIT -     CLOSE THE GAME\n" + "\tMAP - LOOK THE MAP\n"
                + "\tLOOK OBJECTIVE -      LOOK OBJECTIVE LOCAL\n" + "\tLOOK COMANDS -      LOOK THE COMANDS\n"
                + "\tLOOK LOCATIONS -       LOOK THE LOCATIONS\n";
    }

    public String lookMap() {
        return "\n\t                                           Floresta de Rammith------Caverna Rasa\n"
                + "\t                                                      |                     |\n"
                + "tJumanju------Floresta de Skellige-----Skellige------Guilda               Caverna\n"
                + "\t                                                      |                     |\n"
                + "\t                                                   Rammith------------Monte Akatosh\n";
    }

    // Movimentos do jogador
    public void movePlayer(String direction) {
        if (super.getLocation() == 0) {
            if (direction.equalsIgnoreCase("UP")) {
                super.setLocation(1);
            }
            if (direction.equalsIgnoreCase("DOWN")) {
                super.setLocation(6);
            }
            if (direction.equalsIgnoreCase("LEFT")) {
                super.setLocation(10);
            }
            if (direction.equalsIgnoreCase("RIGHT")) {
                System.out.println("Por favor olhe o mapa.");
            }

        } else if (super.getLocation() == 1) {
            if (direction.equalsIgnoreCase("UP")) {
                System.out.println("Por favor olhe o mapa.");
            }
            if (direction.equalsIgnoreCase("DOWN")) {
                super.setLocation(0);
            }
            if (direction.equalsIgnoreCase("LEFT")) {
                System.out.println("Por favor olhe o mapa.");
            }
            if (direction.equalsIgnoreCase("RIGHT")) {
                super.setLocation(2);
            }

        } else if (super.getLocation() == 2) {
            if (direction.equalsIgnoreCase("UP")) {
                System.out.println("Por favor olhe o mapa.");
            }
            if (direction.equalsIgnoreCase("DOWN")) {
                super.setLocation(3);
            }
            if (direction.equalsIgnoreCase("LEFT")) {
                super.setLocation(1);
            }
            if (direction.equalsIgnoreCase("RIGHT")) {
                System.out.println("Por favor olhe o mapa.");
            }

        } else if (super.getLocation() == 3) {
            if (direction.equalsIgnoreCase("UP")) {
                super.setLocation(2);
            }
            if (direction.equalsIgnoreCase("DOWN")) {
                super.setLocation(12);
            }
            if (direction.equalsIgnoreCase("LEFT")) {
                System.out.println("Por favor olhe o mapa.");
            }
            if (direction.equalsIgnoreCase("RIGHT")) {
                System.out.println("Por favor olhe o mapa.");
            }

        } else if (super.getLocation() == 6) {
            if (direction.equalsIgnoreCase("UP")) {
                super.setLocation(0);
            }
            if (direction.equalsIgnoreCase("DOWN")) {
                System.out.println("Por favor olhe o mapa.");
            }
            if (direction.equalsIgnoreCase("LEFT")) {
                System.out.println("Por favor olhe o mapa.");
            }
            if (direction.equalsIgnoreCase("RIGHT")) {
                super.setLocation(7);
            }

        } else if (super.getLocation() == 7) {
            if (direction.equalsIgnoreCase("UP")) {
                super.setLocation(3);
            }
            if (direction.equalsIgnoreCase("DOWN")) {
                System.out.println("Por favor olhe o mapa.");
            }
            if (direction.equalsIgnoreCase("LEFT")) {
                super.setLocation(6);
            }
            if (direction.equalsIgnoreCase("RIGHT")) {
                System.out.println("Por favor olhe o mapa.");
            }

        } else if (super.getLocation() == 10) {
            if (direction.equalsIgnoreCase("UP")) {
                System.out.println("Por favor olhe o mapa.");
            }
            if (direction.equalsIgnoreCase("DOWN")) {
                System.out.println("Por favor olhe o mapa.");
            }
            if (direction.equalsIgnoreCase("LEFT")) {
                super.setLocation(11);
            }
            if (direction.equalsIgnoreCase("RIGHT")) {
                super.setLocation(0);
            }

        } else if (super.getLocation() == 11) {
            if (direction.equalsIgnoreCase("UP")) {
                System.out.println("Por favor olhe o mapa.");
            }
            if (direction.equalsIgnoreCase("DOWN")) {
                System.out.println("Por favor olhe o mapa.");
            }
            if (direction.equalsIgnoreCase("LEFT")) {
                super.setLocation(12);
            }
            if (direction.equalsIgnoreCase("RIGHT")) {
                super.setLocation(10);
            }

        } else if (super.getLocation() == 12) {
            if (direction.equalsIgnoreCase("UP")) {
                System.out.println("Por favor olhe o mapa.");
            }
            if (direction.equalsIgnoreCase("DOWN")) {
                System.out.println("Por favor olhe o mapa.");
            }
            if (direction.equalsIgnoreCase("LEFT")) {
                super.setLocation(13);
            }
            if (direction.equalsIgnoreCase("RIGHT")) {
                super.setLocation(11);
            }

        }
    }

}