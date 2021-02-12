public abstract class Npc {
    String name;
    Inventory inventory;


    public Npc(String name2){
        this.name = name2;
        this.inventory = new Inventory(1);
    }

    public Inventory getInventory(){
        return this.inventory;
    }


    public String toString (){

        return this.name + " are carrying " + this.inventory;
    }

}
