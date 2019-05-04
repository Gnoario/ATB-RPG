import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class Location {
    private String description;
    private String tag;
    private String objective;
    private int locationMap;
    private int sizeStore = 0;
    private int sizeMonsters = 0;
    private int sizeTraps = 0;
    private int sizeP = 0;
    static String history = "History.txt";
    private List<Location> locations = new ArrayList<>();
    // private List<Monsters> monsters = new ArrayList<>();
    // private List<Trap> traps = new ArrayList<>();
    private Protagonist protagonist[] = new Protagonist[1];
    private Monster monsters[] = new Monster[4];
    private Trap traps[] = new Trap[4];
    private Object store[] = new Object[10];
    private Combat combat = new Combat();

    public Location(String description, String tag, String objective, int locationMap) {
        this.description = description;
        this.tag = tag;
        this.objective = objective;
        this.locationMap = locationMap;
    }

    public Location() {

    }

    public void addMonsters(Monster monster) {
        if (sizeMonsters >= 0 && sizeMonsters < 4) {
            monsters[sizeMonsters] = monster;
            sizeMonsters++;
        }
    }

    public void addProtagonist(Protagonist p) {
        if (sizeP >= 0 && sizeP < 1) {
            protagonist[sizeP] = p;
            sizeP++;
        }
    }

    public void addItem_Store(Object object) {
        if (sizeStore >= 0 && sizeStore < 10) {
            store[sizeStore] = object;
            sizeStore++;
        }
    }

    public void battle() {
        initMonsters();
    }

    // Loja
    public void store() {
        System.out.println("\tBem-vindo à loja, veja os itens disponíveis\n");
        for (int i = 0; i < store.length; i++) {
            if (store[i] != null) {
                if (store[i].getName().equals("Poção") || store[i].getName().equals("Reparador de armadura")) {
                    System.out.println("\n" + store[i].getName() + " = Preço: " + store[i].getPrice() + " Recuperação: "
                            + store[i].getAtribbute());
                } else {
                    System.out.println("\n" + store[i].getName() + " = Preço: " + store[i].getPrice() + " Dano: "
                            + store[i].getAtribbute());
                }

            }
        }
        System.out.println("\n");
    }

    // Comprar item da loja
    public void buyItem(String item) {
        System.out.println(protagonist[0].getGold());
        for (int i = 0; i < store.length; i++) {
            if (store[i] != null) {
                if (store[i].getName().equalsIgnoreCase(item)) {
                    if (store[i].getPrice() < protagonist[0].getGold()) {
                        protagonist[0].adObject(store[i]);
                        int gold = protagonist[0].getGold() - store[i].getPrice();
                        protagonist[0].setGold(gold);
                        System.out.println("Você obteve: " + store[i].getName());
                    } else {
                        System.out.println("Você não tem dinheiro suficiente!");
                    }
                }

            }
        }
    }

    public void addTraps(Trap trap) {
        if (sizeTraps >= 0 && sizeTraps < 4) {
            traps[sizeTraps] = trap;
            sizeTraps++;
        }
    }

    public void initMonsters() {

        if (protagonist[0].getLocation() == 2 || protagonist[0].getLocation() == 7
                || protagonist[0].getLocation() == 9) {
            for (int i = 0; i < 3; i++) {
                combat.batalha(monsters[0], protagonist[0], monsters[0].getDamage(), monsters[0].getDefense(),
                        monsters[0].getHealth());
                combat.batalha(monsters[1], protagonist[0], monsters[1].getDamage(), monsters[1].getDefense(),
                        monsters[1].getHealth());
                combat.batalha(monsters[2], protagonist[0], monsters[2].getDamage(), monsters[2].getDefense(),
                        monsters[2].getHealth());
            }
        } else if (protagonist[0].getLocation() == 3 || protagonist[0].getLocation() == 12) {
            combat.batalha(monsters[2], protagonist[0], monsters[2].getDamage(), monsters[2].getDefense(),
                    monsters[2].getHealth());
            combat.batalha(monsters[3], protagonist[0], monsters[3].getDamage(), monsters[3].getDefense(),
                    monsters[3].getHealth());
        }

        else {
            System.out.println("Não existe monstros no local.");
        }
        respawnMonsters();
        // int lvl_1 = random(0, 5);
        // int lvl_2 = random(0, 8);
        // int lvl_3 = random(0, 12);
        // monsters[0].setnElements(lvl_1);
        // monsters[1].setnElements(lvl_2);
        // monsters[2].setnElements(lvl_3);
        // monsters[3].setnElements(1);
    }

    public String lookMonsters() {
        for (int i = 0; i < monsters.length; i++) {
            if (protagonist[0].getLocation() == monsters[i].getLocation()
                    || protagonist[0].getLocation() == monsters[i].getLocationAux()
                    || protagonist[0].getLocation() == monsters[i].getLocationAux2()
                    || protagonist[0].getLocation() == monsters[i].getLocationAux3()) {
                return monsters[i].toString();
            }
        }
        return null;

    }

    public int initTraps() {
        int random = random(0, 3);
        System.out.println("Você caiu em uma armadilha: " + traps[random].getName() + "dano causado: "
                + traps[random].getDamage());
        return protagonist[0].getHealth() - traps[random].getDamage();
    }

    public int random(int min, int max) {
        Random r = new Random();
        return (r.nextInt(max - (min - 1)) + min);
    }

    public void respawnMonsters() {
        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                for (int j = 0; j < monsters.length; j++) {
                    monsters[j].setHealth(monsters[j].getMax_health());
                }

            }
        }, 0, 300000);

    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setObjective(String objective) {
        this.objective = objective;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public int getLocationMap() {
        return locationMap;
    }

    public String getObjective() {
        return objective;
    }

    public String getDescription() {
        return description;
    }

    public String getTag() {
        return tag;
    }

    public String getDescriptionFile(String tag) {
        return consultLocation(tag).getDescription();
    }

    public String getObjectiveFile(String tag) {
        return consultLocation(tag).getObjective();
    }

    public static List<Location> recoveryHistory() {

        // String print = p.getIdent() + ";" + nome + ";" + endereco + ";"
        // + nasc + ";" + cpf + ";" + altura + ";" + peso + ";" + salario;
        // Pessoa.Write(arq, print);
        // String conteudo = Pessoa.Read(arq);
        String linha = "";
        List<Location> lista = new ArrayList<>();
        try {

            FileReader arq = new FileReader(new File(history));
            BufferedReader lerArq = new BufferedReader(arq);

            linha = lerArq.readLine();

            while (linha != null) {
                Location l = new Location();
                String values[] = linha.split(";");
                l.setTag(values[0]);
                l.setDescription(values[1]);
                l.setObjective(values[2]);

                lista.add(l);
                // System.out.println("Nome: "+p.getNome()+" "+p.getSobrenome());
                // System.out.println("Login: "+p.getLogin());
                // System.out.println("Senha: "+p.getSenha());
                // System.out.println("Situação: "+p.getSituacao()+"\n");
                linha = lerArq.readLine();

            }
            arq.close();
        } catch (IOException ex) {
            System.out.println("Erro: Não foi possível ler o arquivo!");
        }
        return lista;
    }

    public Location consultLocation(String tag) {
        this.setLocations(recoveryHistory());
        for (int i = 0; i < getLocations().size(); i++) {
            Location location = getLocations().get(i);
            if (location.getTag().equalsIgnoreCase(tag)) {
                return location;
            }
        }
        return null;
    }

    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }

    public List<Location> getLocations() {
        return locations;
    }
}