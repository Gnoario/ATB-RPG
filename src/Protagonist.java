
public class Protagonist extends Character {
    int danoLanca;
    int danoEspada;
    int danoFlecha;
    int aljavaMax;
    int special;
    // Location locations;

    public Protagonist(String nome, int ataque, int defesa, int vida, int armadura, Location location, int special,
            int danoLanca, int danoEspada, int danoFlecha, int aljavaMax) {
        super(nome, ataque, defesa, vida, armadura, location);
        this.special = special;
        this.danoLanca = danoEspada;
        this.danoFlecha = danoFlecha;
        this.danoEspada = danoEspada;
        this.aljavaMax = aljavaMax;
    }

    public void run(Location guilda) {
        super.setLocation(guilda);
    }

    public void lookObjective() {
        // if (super.getLocation() == locations.getLocationMap()) {
            System.out.println(super.location.getObjective());
        // }
    }

    public String lookComands() {
        return "LEFT, RIGHT, UP, DOWN - MOVE\n" + "ATTACK - ATTACK MONSTERS\n" + "STATUS - LOOK STATUS PROTAGONIST\n"
                + "LOOK MONSTER - LOOK MONSTERS THE AREA\n" + "RUN - RUN FOR INIT\n" + "EXIT - CLOSE THE GAME\n"
                + "MAP - LOOK THE MAP\n" + "LOOK OBJECTIVE - LOOK OBJECTIVE LOCAL\n"
                + "LOOK COMANDS - LOOK THE COMANDS\n";
    }

    public void movePlayer(String direction) {
        if (super.getLocation()) {
            if (direction == "UP") {
                super.setLocation(1);
            }
            if (direction == "DOWN") {
                super.setLocation(6);
            }
            if (direction == "LEFT") {
                super.setLocation(10);
            }
            if (direction == "RIGHT") {
                System.out.println("Por favor olhe o mapa.");
            }

        } else if (super.getLocation() == 1) {
            if (direction == "UP") {
                System.out.println("Por favor olhe o mapa.");
            }
            if (direction == "DOWN") {
                super.setLocation(0);
            }
            if (direction == "LEFT") {
                System.out.println("Por favor olhe o mapa.");
            }
            if (direction == "RIGHT") {
                super.setLocation(2);
            }

        } else if (super.getLocation() == 2) {
            if (direction == "UP") {
                System.out.println("Por favor olhe o mapa.");
            }
            if (direction == "DOWN") {
                super.setLocation(3);
            }
            if (direction == "LEFT") {
                super.setLocation(1);
            }
            if (direction == "RIGHT") {
                System.out.println("Por favor olhe o mapa.");
            }

        } else if (super.getLocation() == 3) {
            if (direction == "UP") {
                super.setLocation(2);
            }
            if (direction == "DOWN") {
                super.setLocation(12);
            }
            if (direction == "LEFT") {
                System.out.println("Por favor olhe o mapa.");
            }
            if (direction == "RIGHT") {
                System.out.println("Por favor olhe o mapa.");
            }

        } else if (super.getLocation() == 6) {
            if (direction == "UP") {
                super.setLocation(0);
            }
            if (direction == "DOWN") {
                System.out.println("Por favor olhe o mapa.");
            }
            if (direction == "LEFT") {
                System.out.println("Por favor olhe o mapa.");
            }
            if (direction == "RIGHT") {
                super.setLocation(7);
            }

        } else if (super.getLocation() == 7) {
            if (direction == "UP") {
                super.setLocation(3);
            }
            if (direction == "DOWN") {
                System.out.println("Por favor olhe o mapa.");
            }
            if (direction == "LEFT") {
                super.setLocation(6);
            }
            if (direction == "RIGHT") {
                System.out.println("Por favor olhe o mapa.");
            }

        } else if (super.getLocation() == 10) {
            if (direction == "UP") {
                System.out.println("Por favor olhe o mapa.");
            }
            if (direction == "DOWN") {
                System.out.println("Por favor olhe o mapa.");
            }
            if (direction == "LEFT") {
                super.setLocation(11);
            }
            if (direction == "RIGHT") {
                super.setLocation(0);
            }

        } else if (super.getLocation() == 11) {
            if (direction == "UP") {
                System.out.println("Por favor olhe o mapa.");
            }
            if (direction == "DOWN") {
                System.out.println("Por favor olhe o mapa.");
            }
            if (direction == "LEFT") {
                super.setLocation(12);
            }
            if (direction == "RIGHT") {
                super.setLocation(10);
            }

        } else if (super.getLocation() == 12) {
            if (direction == "UP") {
                System.out.println("Por favor olhe o mapa.");
            }
            if (direction == "DOWN") {
                System.out.println("Por favor olhe o mapa.");
            }
            if (direction == "LEFT") {
                super.setLocation(13);
            }
            if (direction == "RIGHT") {
                super.setLocation(11);
            }

        }
    }

}