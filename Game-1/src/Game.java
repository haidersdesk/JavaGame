import java.awt.Color;

public class Game {
    private Gui gui;
    private Room room1, room2, room3, room4;
    private Room map[] ;

    public Game(){


        //Skapa rum!
        room1 = new Room("\nEnter!"," \nThis is the Entrance Room, Water dripping! a bucket is in this room");
        room2 = new Room("\nKitchen", "\nThis is a Yellow kitchen, There is Fridge in this room");
        room3 = new Room("\nLiving Room", "\nLiving room has a Green Theme, There is a Big Sofa in this room");
        room4 = new Room("\nBed Room", "\nThis is a Purple Themed Room. There is a big bed in the center ");

        map = new Room[4];
        map[0] = room1;  map[1] = room2; map[2] = room3; map[3] = room4;

        //Gameobjects
        GameObject bucket = new GameObject("bucket",true);
        GameObject cake = new GameObject("cake", false);
        GameObject lamp = new GameObject("lamp",false);
        GameObject pillow = new GameObject("pillow",false);

        Container box = new Container("BLUE BOX", false, true);

        room1.addObject(null); room1.addObject(bucket); room1.addObject(box);
        room2.addObject(null); room2.addObject(cake); room2.addObject(box);
        room3.addObject(null); room3.addObject(lamp);room3.addObject(box);
        room4.addObject(null); room4.addObject(pillow); room4.addObject(box);


        Person newPlayer1 = new Person("You");

        Inventory inventory = new Inventory(2);
        inventory.addObject(bucket);
        inventory.addObject(cake);
        inventory.addObject(lamp);
        inventory.addObject(pillow);

        this.gui = new Gui();

        boolean gameOn=true;
        int rumIndex=0;

        while (gameOn) {

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
                if (command.contains("pick")  ) {

                    if (command.contains("bucket")  ) {
                        map[rumIndex].removeObject(bucket);
                        newPlayer1.getInventory().addObject(bucket);
                    }
                    if (command.contains("cake")  ) {
                        map[rumIndex].removeObject(cake);
                        newPlayer1.getInventory().addObject(cake);
                    }
                    if (command.contains("lamp")  ) {
                        map[rumIndex].removeObject(lamp);
                        newPlayer1.getInventory().addObject(lamp);
                    }
                    if (command.contains("pillow")  ) {
                        map[rumIndex].removeObject(pillow);
                        newPlayer1.getInventory().addObject(pillow);
                    }

                }


                if (command.contains("leave")  ) {

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



}