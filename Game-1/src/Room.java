import java.util.stream.Stream;

public class Room  {
    private String name;
    private String description;
    private Inventory inventory;
    private Person[] person;
    private Gui gui;

    public Room(String roomName, String roomDescription, Gui gui){
        this.gui = gui;
        this.person = new Person[4];
        this.name = roomName;
        this.description= roomDescription;
        this.inventory = new Inventory(4, gui);
    }
    public void addNpc(Person person) {

        this.person = Stream.concat(Stream.of(this.person),Stream.of(person)).toArray(Person[]::new);
    }

    public Person getPersons(){
        return this.person[0];
    }
    public void addObject(GameObject go){
        this.inventory.addObject(go);

    }

    public void setPersons(Person[] person){
        this.person = person;

    }
    public Inventory getInventory(){
        return this.inventory;
    }
    //remove
    public void removeObject(GameObject go) {
        this.inventory.removeObject(go);

    }
    public String toString(){
        return name+" : "+description +"\n" +inventory;
    }

}