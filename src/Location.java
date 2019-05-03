import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Location {
    private String description;
    private String tag;
    private String objective;
    private int locationMap;
    static String history = "History.txt";
    private List<Location> locations = new ArrayList<>();
    // private List<Monsters> monsters = new ArrayList<>();
    // private List<Trap> traps = new ArrayList<>();
    private Monster monsters[];
    private Trap traps[];

    public Location(String description, String tag, String objective, int locationMap) {
        this.description = description;
        this.tag = tag;
        this.objective = objective;
        this.locationMap = locationMap;
    }

    public Location() {

    }

    public void addMonsters(Monster monster) {
        int size = 0;
        if (size >= 0 && size < 10) {
            monsters[size] = monster;
            size++;
        }
    }

    public void addTraps(Trap trap) {
        int size = 0;
        if (size >= 0 && size < 10) {
            traps[size] = trap;
            size++;
        }
    }

    public void initMonsters() {

    }

    public void initTraps() {

    }

    public void respawnMonsters() {
        new Thread() {
            @Override
            public void run() {

                for (int i = 0; i < monsters.length; i++) {
                    monsters[i].setHealth(monsters[i].getMax_health());
                    ;
                }

            }
        }.start();

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