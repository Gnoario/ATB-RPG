
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author natha
 */
public class Monster extends Character {
    int nElements;
    int locationAux;
    int locationAux2;
    int locationAux3;

    public Monster(String name, int damage, int defense, int health, int max_health, int arm, int location, int gold,
            int nElements, int locationAux, int locationAux2, int locationAux3) {
        super(name, damage, defense, health, max_health, arm, location, gold);
        this.nElements = nElements;
        this.locationAux = locationAux;
        this.locationAux2 = locationAux2;
        this.locationAux3 = locationAux3;
    }

    /**
     * @return the nElements
     */
    public int getnElements() {
        return nElements;
    }

    /**
     * @return the locationAux
     */
    public int getLocationAux() {
        return locationAux;
    }

    /**
     * @return the locationAux2
     */
    public int getLocationAux2() {
        return locationAux2;
    }

    /**
     * @return the locationAux3
     */
    public int getLocationAux3() {
        return locationAux3;
    }

    /**
     * @param nElements the nElements to set
     */
    public void setnElements(int nElements) {
        this.nElements = nElements;
    }
}
