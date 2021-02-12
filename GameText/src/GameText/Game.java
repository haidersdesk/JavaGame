package GameText;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game {

     ChoiceHandler cHandler = new ChoiceHandler();
     GUI gui = new GUI();
     VisibilityManager vm = new VisibilityManager(gui);
     Story story = new Story(this, gui, vm);

     String nextPosition1, nextPosition2, nextPosition3, nextPosition4;


    public Game(){
       gui.createUI(cHandler);
       story.defaultSetup();
       vm.showTitleScreen();
    }

    public class ChoiceHandler implements ActionListener {
        public void actionPerformed(ActionEvent event){
            String yourChoice = event.getActionCommand();

            switch(yourChoice){
                case "start": vm.TitleToTown(); story.exitGate(); break;
                case "room1": story.selectPosition(nextPosition1); break;
                case "room2": story.selectPosition(nextPosition2);break;
                case "room3": story.selectPosition(nextPosition3); break;
                case "room4": story.selectPosition(nextPosition4);break;

            }

        }

    }
}
