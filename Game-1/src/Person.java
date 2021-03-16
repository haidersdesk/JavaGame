public class Person extends Npc implements Runnable{

    private int position;
    public Person(String name, int startRoom, Gui g){
        super(name, g);
        this.position = startRoom;
    }

    public synchronized void move(){
        int slump = (int) (Math.random()*4 +1);
        this.position = slump;
        System.out.println(this.name + " is moving " + " to room " + this.position );
    }

    public void takeFromRoom(GameObject object){
        this.getInventory().addObject(object);
        System.out.println(this.name+  " has taken " + object.getName());
    }

    public void leaveToRoom(GameObject object){
        getInventory().removeObject(object);
        System.out.println(this.name+ " dropped " + object.getName());
    }

    public int getPosition(){
        return position;
    }

    @Override
    public void run(){
    }

}