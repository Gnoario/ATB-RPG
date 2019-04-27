import sun.security.util.Length;

public class Location {
    private String description;
    private String tag;
    private String objective;
    private int locationMap;
    int size;

    Location locations[] = new Location[9];

    public Location(String description, String tag, String objective, int locationMap){
        this.description = description;
        this.tag = tag;
        this.objective = objective;
        this.locationMap = locationMap;
    }

    public Location(){
        
    }

    public int getLocationMap(){
        return locationMap;
    }

    public String getObjective(){
        return objective;
    }

    public String getDescription(){
        return description;
    }

    public String getTag(){
        return tag;
    }

    public void lookLocation() {

    }

    public Location get(int indice) {
        if (indice >= 0 && indice < size) {
            return locations[indice];
        }
        return null;
    }

    public void adLocation(Location location) {
        if (size >= 0 && size < 9) {
            locations[size] = location;
            size++;
        }
    }
    //olhar os objetivos que tem que fazer na área


    public void lookMap() {

    }

}