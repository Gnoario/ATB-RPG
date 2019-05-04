/**
 * Object
 */
public class Object {

    private String name;
    private int atribbute;
    private int amount;
    private int price;

    public Object(String name, int atribbute, int price) {
        this.price = price;
        this.atribbute = atribbute;
        this.name = name;
    }

    public Object(){
        
    }

    /**
     * @return the price
     */
    public int getPrice() {
        return price;
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

    public void store(String item) {

    }
}