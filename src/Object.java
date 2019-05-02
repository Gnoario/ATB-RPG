/**
 * Object
 */
public class Object {

    private String name;
    private int atribbute;
    private int amount;

    public Object(String name, int atribbute, int amount){
        this.amount = amount;
        this.atribbute = atribbute;
        this.name = name;
    }
    /**
     * @return the amount
     */
    public int getAmount() {
        return amount;
    }

    /**
     * @return the atribbute
     */
    public int getAtribbute() {
        return atribbute;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(int amount) {
        this.amount = amount;
    }

    /**
     * @param atribbute the atribbute to set
     */
    public void setAtribbute(int atribbute) {
        this.atribbute = atribbute;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
}