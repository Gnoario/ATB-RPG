public class Protagonist extends Character {
    int aljavaMax;
    int special;
    int nElements = 0;
    Object bag[] = new Object[30];

    public Protagonist(String name, int damage, int defense, int health, int max_health, int arm, int location,
            int gold, int special, int aljavaMax) {
        super(name, damage, defense, health, max_health, arm, location, gold);
        this.special = special;
        this.aljavaMax = aljavaMax;
    }

    /**
     * @return the special
     */
    public int getSpecial() {
        return special;
    }

    /**
     * @param special the special to set
     */
    public void setSpecial(int special) {
        this.special = special;
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

    public void adObject(Object object) {
        if (nElements >= 0 && nElements < 30) {
            bag[nElements] = object;
            nElements++;
        } else {
            System.out.println("\nVocê atingiu o limite máximo do seu inventário\n");
        }
    }

    /**
     * @return the bag
     */
    public Object[] getBag() {
        return bag;
    }

    /**
     * @param bag the bag to set
     */
    public void setBag(Object[] bag) {
        this.bag = bag;
    }

    public void seeBag() {
        if (bag[0] != null) {
            for (int i = 0; i < bag.length; i++) {
                if (bag[i] != null) {
                    System.out.println("[ " + bag[i].getName() + " ] ");
                }

            }
        } else {
            System.out.println("\nVocê não possui nada em seu inventário\n");
        }

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

    @Override
    public int getGold() {
        return super.getGold();
    }

    public void equip(String name) {
        for (int i = 0; i < bag.length; i++) {
            if (bag[i] != null) {
                if (name.equalsIgnoreCase("POÇÃO") || name.equalsIgnoreCase("Reparador de Armadura")) {
                    if (bag[i].getName().equals(name)) {
                        int health = bag[i].getAtribbute() + super.getHealth();
                        super.setHealth(health);
                        if (super.getHealth() > 400) {
                            super.setHealth(super.getMax_health());
                        }
                    }
                } else if (bag[i].getName().equalsIgnoreCase(name)) {
                    super.setDamage(0);
                    int damage = bag[i].getAtribbute() + super.getDamage();
                    super.setDamage(damage);
                } else {
                    System.out.println("Você não possui esse item.");
                }
            }

        }
    }

    // O jogador retorna para guilda, emergencialmente
    public void run() {
        super.setLocation(0);
    }

    // Olhar os comandos disponíveis
    public String lookComands() {
        return "\tLEFT, RIGHT, UP, DOWN - > MOVE\n" + "\tATTACK - > ATTACK MONSTERS\n"
                + "\tSTATUS - > LOOK STATUS PROTAGONIST\n" + "\tLOOK MONSTER - > LOOK MONSTERS THE AREA\n"
                + "\tRUN - > RUN FOR INIT\n" + "\tEXIT - > CLOSE THE GAME\n" + "\tMAP - > LOOK THE MAP\n"
                + "\tLOOK OBJECTIVE - > LOOK OBJECTIVE LOCAL\n" + "\tLOOK COMANDS - > LOOK THE COMANDS\n"
                + "\tLOOK LOCATIONS - > LOOK THE LOCATIONS\n" + "\tBUY - > BUY ITENS\n"
                + "\tINVENTORY - > OPEN INVENTORY\n";
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
                locations[0].initTraps();
            }
            if (direction.equalsIgnoreCase("DOWN")) {
                super.setLocation(3);
            }
            if (direction.equalsIgnoreCase("LEFT")) {
                super.setLocation(1);
            }
            if (direction.equalsIgnoreCase("RIGHT")) {
                locations[0].initTraps();
            }

        } else if (super.getLocation() == 3) {
            if (direction.equalsIgnoreCase("UP")) {
                super.setLocation(2);
            }
            if (direction.equalsIgnoreCase("DOWN")) {
                super.setLocation(12);
            }
            if (direction.equalsIgnoreCase("LEFT")) {
                locations[0].initTraps();
            }
            if (direction.equalsIgnoreCase("RIGHT")) {
                locations[0].initTraps();
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
                locations[0].initTraps();
            }
            if (direction.equalsIgnoreCase("LEFT")) {
                super.setLocation(6);
            }
            if (direction.equalsIgnoreCase("RIGHT")) {
                locations[0].initTraps();
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
                locations[0].initTraps();
            }
            if (direction.equalsIgnoreCase("DOWN")) {
                locations[0].initTraps();
            }
            if (direction.equalsIgnoreCase("LEFT")) {
                super.setLocation(12);
            }
            if (direction.equalsIgnoreCase("RIGHT")) {
                super.setLocation(10);
            }

        } else if (super.getLocation() == 12) {
            if (direction.equalsIgnoreCase("UP")) {
                locations[0].initTraps();
            }
            if (direction.equalsIgnoreCase("DOWN")) {
                locations[0].initTraps();
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