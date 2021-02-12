package GameText;

public class VisibilityManager {
    GUI gui;

    public VisibilityManager(GUI userInterface){
          gui = userInterface;
    }

    public void showTitleScreen(){

        //show the title screen
        gui.titleNamePanel.setVisible(true);
        gui.startButtonPanel.setVisible(true);

        //Hide the game screen
        gui.mainTextPanel.setVisible(false);
        gui.choiceButtonPanel.setVisible(false);
        gui.playerPanel.setVisible(false);

    }

    public void TitleToTown(){
       //show the title screen
        gui.titleNamePanel.setVisible(false);
        gui.startButtonPanel.setVisible(false);

        //Hide the game screen
        gui.mainTextPanel.setVisible(true);
        gui.choiceButtonPanel.setVisible(true);
        gui.playerPanel.setVisible(true);

    }
}
