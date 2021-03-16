import java.awt.Color;
import java.util.Arrays;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class Game {
    private Gui gui;
    private Room room1, room2, room3, room4;
    private Room map[] ;
    private Person[] persons;

    public Game(){


        //Skapa rum!
        room1 = new Room("\nEnter!"," \nThis is the Entrance Room, Water dripping! a bucket is in this room",gui);
        room2 = new Room("\nKitchen", "\nThis is a Yellow kitchen, There is Fridge in this room",gui);
        room3 = new Room("\nLiving Room", "\nLiving room has a Green Theme, There is a Big Sofa in this room",gui);
        room4 = new Room("\nBed Room", "\nThis is a Purple Themed Room. There is a big bed in the center ",gui);

        map = new Room[4];
        map[0] = room1;  map[1] = room2; map[2] = room3; map[3] = room4;

        //Gameobjects
        GameObject bucket = new GameObject("bucket",true);
        GameObject cake = new GameObject("cake", true);
        GameObject lamp = new GameObject("lamp",false);
        GameObject pillow = new GameObject("pillow",true);

        Container box = new Container("BLUE BOX", false, true, gui);

        room1.addObject(null); room1.addObject(bucket); room1.addObject(box);
        room2.addObject(null); room2.addObject(cake); room2.addObject(box);
        room3.addObject(null); room3.addObject(lamp);room3.addObject(box);
        room4.addObject(null); room4.addObject(pillow); room4.addObject(box);


        Person newPlayer1 = new Person("You", 0, gui);
        room1.addNpc(newPlayer1);
        Person Jonas = new Person("Jonas", 3, gui);
        room2.addNpc(Jonas);
        Person Simon = new Person("Simon", 2, gui);
        room3.addNpc(Simon);
        Person Niklas= new Person("Niklas", 1, gui);
        room4.addNpc(Niklas);

        persons = new Person[3];
        persons[0] = Jonas;
        persons[1] = Simon;
        persons[2] = Niklas;

        ScheduledThreadPoolExecutor pool = new ScheduledThreadPoolExecutor(10);
        pool.scheduleAtFixedRate( Jonas, 20, 20, TimeUnit.SECONDS);
        pool.scheduleAtFixedRate( Simon, 10, 30, TimeUnit.SECONDS);
        pool.scheduleAtFixedRate( Niklas, 30, 10, TimeUnit.SECONDS);

        try {
            sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Inventory inventory = newPlayer1.getInventory();

        this.gui = new Gui();


        boolean gameOn=true;
        int rumIndex=0;

        while (gameOn) {
            try {
                int npcId = (int) (Math.random() * 3 );
                performNpcMove(npcId);
            } catch (InterruptedException e){

            }

            String command = gui.getCommand();
            if (!command.equals("-1")) {

                if (command.equals("1")  ) {
                    if (rumIndex == 1 ){
                        rumIndex = 0;
                        gui.panel.setBackground(Color.cyan);
                    }


                }

                if (command.equals("2")) {
                    if (rumIndex == 0 || rumIndex== 2){
                        rumIndex = 1;
                        gui.panel.setBackground(Color.yellow);

                    }

                }
                if (command.equals("3")) {
                    if (rumIndex == 1 || rumIndex== 3){
                        rumIndex = 2;
                        gui.panel.setBackground(Color.green);

                    }

                }
                if (command.equals("4")) {
                    if (rumIndex == 2){
                        rumIndex = 3;
                        gui.panel.setBackground(Color.magenta);
                    }


                }


                //Pick
                if (command.startsWith("pick")  ) {
                    String objectName = command.substring(5);
                    System.out.println(objectName);

                    if (map[rumIndex].getInventory().contains(objectName)) {
                        GameObject gameObject =
                                map[rumIndex].getInventory().returnGameObject(objectName);
                        if (gameObject.isMoveable()) {
                            System.out.println(gameObject.isMoveable());
                            boolean success = newPlayer1.getInventory().addObject(gameObject);
                            if (success) {
                                map[rumIndex].getInventory().removeObject(gameObject);
                            }
                        }
                    }

                }


                if (command.startsWith("leave")  ) {

                    if (command.contains("bucket")  ) {
                        map[rumIndex].addObject(bucket);
                        newPlayer1.getInventory().removeObject(bucket);
                    }
                    if (command.contains("cake")  ) {
                        map[rumIndex].addObject(cake);
                        newPlayer1.getInventory().removeObject(cake);
                    }
                    if (command.contains("lamp")  ) {
                        map[rumIndex].addObject(lamp);
                        newPlayer1.getInventory().removeObject(lamp);
                    }
                    if (command.contains("pillow")  ) {
                        map[rumIndex].addObject(pillow);
                        newPlayer1.getInventory().removeObject(pillow);
                    }
                }
                if (command.equals("exit")  ) {

                    gui.setMessage("Game over");
                    gameOn=false;

                }

            }



            gui.setShowPlayer(newPlayer1,map[rumIndex],rumIndex );
            gui.setShowInventory(inventory);


            gui.setShowRoom1("\n "+map[0]);
            gui.setShowPlayer(newPlayer1,map[rumIndex],rumIndex );


            gui.setShowRoom2("\n "+map[1]);
            gui.setShowPlayer(newPlayer1,map[rumIndex],rumIndex );


            gui.setShowRoom3("\n "+map[2]);
            gui.setShowPlayer(newPlayer1,map[rumIndex],rumIndex );


            gui.setShowRoom4("\n "+map[3]);
            gui.setShowPlayer(newPlayer1,map[rumIndex],rumIndex );

            gui.setMessage("Game over");
        }


    }

    private void performNpcMove(int npcId) throws InterruptedException {
        Person selectedNpc = persons[npcId];
        int action = (int) (Math.random() * 3 + 1);
        sleep(1000);
        switch(action) {
            case 1:
                selectedNpc.move();
                break;
            case 2:
                if(selectedNpc.getInventory().getFirstObject() == null && map[selectedNpc.getPosition()-1].getInventory().getFirstObject() != null) {
                    GameObject objectToGet = map[selectedNpc.getPosition()-1].getInventory().getFirstObject();
                    selectedNpc.takeFromRoom(objectToGet);
                    map[selectedNpc.getPosition()-1].getInventory().removeObject(objectToGet);
                }
                break;
            case 3:
                if(selectedNpc.getInventory().getFirstObject() != null && map[selectedNpc.getPosition()-1].getInventory().getFirstEmptyIndex() != -1) {
                    GameObject objectToDrop = selectedNpc.getInventory().getFirstObject();
                    selectedNpc.leaveToRoom(objectToDrop);
                    map[selectedNpc.getPosition()-1].getInventory().addObject(objectToDrop);
                    break;
                }

        }
    }

    public Person[] getPersonsInRoom( int index){
        Person[] inRoom = Arrays.stream(persons).filter(person -> {
            if (person.getPosition() == index) {
                return true;
            }
            return false;
        }).toArray(Person[]::new);
        return inRoom;
    }


}