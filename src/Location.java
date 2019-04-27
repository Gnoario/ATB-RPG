import sun.security.util.Length;

public class Location {
    private String description;
    private String tag;
    private String objective;
    private int locationMap;
    int size;

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


}