
public class Player  {

    private String name;
    private Inventory inventory;
    Gui gui;

    public Player(String name2, int startRoom, Gui gui) {
        this.gui = gui;
        this.name = name;
        this.inventory  = new Inventory(6,gui);

    }

    public Inventory getInventory(){
        return this.inventory;
    }

    public String toString(){
        return this.name+ " is carrying " + this.inventory;
     }




}