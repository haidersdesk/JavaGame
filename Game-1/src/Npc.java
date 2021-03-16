public abstract class Npc {
    String name;
    Inventory inventory;
    Gui gui;

    public Npc(String name2, Gui gui){
        this.gui = gui;
        this.name = name2;
        this.inventory = new Inventory(1, gui);
    }

    public Inventory getInventory(){
        return this.inventory;
    }


    public String toString (){

        return this.name + " are carrying " + this.inventory;
    }

}
