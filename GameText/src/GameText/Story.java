package GameText;


import java.util.Locale;
import java.util.Random;

public class Story {

    Game game;
    GUI gui;
    VisibilityManager vm;
    Player player = new Player();
    Npc enemy;
    int key;
    private Inventory inventory;
    GameObject go;
    GameObject_Knife knife;
    GameObject_Sword sword;


    public Story(Game g, GUI userInterface, VisibilityManager vManager){
        game = g;
        gui = userInterface;
        vm = vManager;
    }

    public void defaultSetup(){
        player.hp = 10;
        gui.hpNumberLabel.setText(""+player.hp);


        player.inventory = new Inventory(1);
        player.inventory.addObject(new GameObject_Knife());
        player.getCurrentWeapon();

        System.out.println(player.getCurrentWeapon());

        gui.weaponNameLabel.setText(player.inventory.showName());

        key = 0;
    }

    public void selectPosition(String nextPosition){
        switch(nextPosition){
            case "exitGate": exitGate(); break;
            case "readNote": readNote();break;
            case "breakLock": breakLock();break;
            case "hallWay": hallWay();break;
            case "kitchen": kitchen();break;
            case "storeRoom": storeRoom(); break;
            case "livingRoom": livingRoom(); break;
            case "fight": fight();break;
            case "playerAttack": playerAttack(); break;
            case "enemyAttack": enemyAttack();break;
            case "win": win(); break;
            case "lose": lose(); break;
            case "ending": ending(); break;
            case "toTitle": toTitle();break;
            case "pickSword": pickSword(); break;
            case "pickDagger": pickDagger(); break;
            case "pickMagicHerbs": pickMagicHerbs(); break;


        }
    }

    public void exitGate(){
        gui.mainTextArea.setText("You are at exit Gate. \nThere is a note on the gate \n\n What do you do?");
        gui.choice1.setText("Read the Note");
        gui.choice2.setText("Break the Lock");
        gui.choice3.setText("Leave");
        gui.choice4.setText("");

        game.nextPosition1 = "readNote";
        game.nextPosition2 = "breakLock";
        game.nextPosition3 = "hallWay";
        game.nextPosition4 = "";
    }

    public void readNote(){

        if(key==0){
        gui.mainTextArea.setText("This door shall not open. \nUnless you possess a Silver ring to Enter" );
        gui.choice1.setText(">");
        gui.choice2.setText("");
        gui.choice3.setText("");
        gui.choice4.setText("");

        game.nextPosition1 = "exitGate";
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
        }
        else if(key == 1)
        {
            ending();
        }

    }

    public void breakLock(){
        gui.mainTextArea.setText("There is no use!. \n\nMagic lock casts a spell & You gave up \n (You receive 3 damage)" );
        player.hp = player.hp -3;
        gui.hpNumberLabel.setText(""+player.hp);
        gui.choice1.setText(">");
        gui.choice2.setText("");
        gui.choice3.setText("");
        gui.choice4.setText("");

        game.nextPosition1 = "exitGate";
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = "";

    }

    public void hallWay(){
        gui.mainTextArea.setText("You are at the Hallway. \n\n If you back you will go back to exitGate " );
        gui.choice1.setText("Go to Kitchen");
        gui.choice2.setText("Go to StoreRoom");
        gui.choice3.setText("Go to exitGate");
        gui.choice4.setText("Go to livingRoom");

        game.nextPosition1 = "kitchen";
        game.nextPosition2 = "storeRoom";
        game.nextPosition3 = "exitGate";
        game.nextPosition4 = "livingRoom";

    }

    public void kitchen(){
        gui.mainTextArea.setText("There is food in the fridge. \n You eat food\n\n (Your HP is recovered by 2) " );
        player.hp = player.hp +2;
        gui.hpNumberLabel.setText(""+player.hp);
        gui.choice1.setText("Go Back");
        gui.choice2.setText("");
        gui.choice3.setText("");
        gui.choice4.setText("");

        game.nextPosition1 = "hallWay";
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = "";

    }

    public void storeRoom(){
        gui.mainTextArea.setText("You walked in to store Room & found a few weapons\n\nSword\n\nDagger\n\nMagicHerbs" );


        gui.choice1.setText("Go Back");
        gui.choice2.setText("pick-Sword");
        gui.choice3.setText("pick-Dagger");
        gui.choice4.setText("pick-MagicHerbs");



        game.nextPosition1 = "hallWay";
        game.nextPosition2 = "pickSword";
        game.nextPosition3 = "pickDagger";
        game.nextPosition4 = "pickMagicHerbs";

    }

    public void livingRoom(){
        int i  = new  Random().nextInt(100)+1;
        if(i<50) {
            enemy = new Npc_Troll();
        }else
        {
            enemy = new Npc_Oger();

       }
        enemy = new Npc_Troll();

        gui.mainTextArea.setText("You Encounter a "+ enemy.name+ "!" );
        gui.choice1.setText("Fight");
        gui.choice2.setText("Run");
        gui.choice3.setText("");
        gui.choice4.setText("");

        game.nextPosition1 = "fight";
        game.nextPosition2 = "hallWay";
        game.nextPosition3 = "";
        game.nextPosition4 = "";

    }

    public void fight(){
        gui.mainTextArea.setText(enemy.name+ ": "+enemy.hp+ "\n\n What do you do?" );
        gui.choice1.setText("Attack");
        gui.choice2.setText("Run");
        gui.choice3.setText("");
        gui.choice4.setText("");

        game.nextPosition1 = "playerAttack";
        game.nextPosition2 = "hallWay";
        game.nextPosition3 = "";
        game.nextPosition4 = "";

    }

    public void playerAttack(){
        int playerDamage = new Random().nextInt(player.getCurrentWeaponDamage());
        System.out.println(player.getCurrentWeaponDamage());
        gui.mainTextArea.setText("You attacked the " +enemy.name +" and gave " +playerDamage + "damage!");
        enemy.hp = enemy.hp -playerDamage;
        gui.choice1.setText("Attack");
        gui.choice2.setText("Run");
        gui.choice3.setText("");
        gui.choice4.setText("");


        if (enemy.hp>0){
            game.nextPosition1 = "enemyAttack";
            game.nextPosition2 = "";
            game.nextPosition3 = "";
            game.nextPosition4 = "";

        }else if (enemy.hp<1){
            game.nextPosition1 = "win";
            game.nextPosition2 = "";
            game.nextPosition3 = "";
            game.nextPosition4 = "";

        }

    }
         public void enemyAttack(){
            int enemyDamage = new Random().nextInt(enemy.attack);
            gui.mainTextArea.setText(enemy.attackMessage + "\nYou received " + enemyDamage + " damage!" );
            player.hp = player.hp - enemyDamage;
            gui.hpNumberLabel.setText(""+player.hp);
             gui.choice1.setText(">");
             gui.choice2.setText("");
             gui.choice3.setText("");
             gui.choice4.setText("");

             if (player.hp>0) {
                 game.nextPosition1 = "fight";
                 game.nextPosition2 = "";
                 game.nextPosition3 = "";
                 game.nextPosition4 = "";

             }else if (player.hp<1) {
                 game.nextPosition1 = "lose";
                 game.nextPosition2 = "";
                 game.nextPosition3 = "";
                 game.nextPosition4 = "";
             }

         }

         public void win(){
          gui.mainTextArea.setText("You have defeated the "+ enemy.name + "!"+"\nThe "+ enemy.name+ " dropped a golden key\n\n(You obtained Key!)" );
          key = 1;
             gui.choice1.setText("Go Back");
             gui.choice2.setText("");
             gui.choice3.setText("");
             gui.choice4.setText("");

             game.nextPosition1 ="hallWay";
             game.nextPosition2 = "";
             game.nextPosition3 = "";
             game.nextPosition4 = "";


         }

    public void lose(){
        gui.mainTextArea.setText("You are dead!\n\n <GAME OVER>" );

        gui.choice1.setText("To the title Screen");
        gui.choice2.setText("");
        gui.choice3.setText("");
        gui.choice4.setText("");

        game.nextPosition1 ="toTitle";
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = "";


    }

    public void ending(){
         gui.mainTextArea.setText("Oh you killed the " + enemy.name+"!"+"\nYou Possess the Key. You May Exit Hero!!");

        gui.choice1.setVisible(false);
        gui.choice2.setVisible(false);
        gui.choice3.setVisible(false);
        gui.choice4.setVisible(false);

    }

    public void pickSword(){
        player.inventory.addObject(new GameObject_Sword());

        gui.weaponNameLabel.setText(player.inventory.showName());

    }

    public void pickDagger(){
        player.inventory.addObject(new GameObject_Dagger());
        gui.weaponNameLabel.setText(player.inventory.showName());
    }

    public void pickMagicHerbs(){
        player.inventory.addObject(new GameObjects_MagicHerbs());
        gui.weaponNameLabel.setText(player.inventory.showName());
    }

    public void toTitle(){

        defaultSetup();
        vm.showTitleScreen();
    }
}
