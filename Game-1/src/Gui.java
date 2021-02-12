import javax.swing.*;
import java.awt.Color;


import java.awt.*;
import java.awt.event.ActionListener;


public class Gui extends JFrame {

    private static final long serialVersionUID = 1L;
    JPanel panel;
    private JTextArea  Room1,Room2,Room3,Room4;
    private JTextField input;
    private JTextArea inventory;
    private String command;
    private boolean gotCommand;
    private JButton button;
    static JLabel text = new JLabel();




    public Gui(){
        Font fontA= new Font("Courier New", Font.PLAIN, 20);
        Font fontB= new Font("Courier New", Font.PLAIN, 12);
        Font fontC= new Font("Courier New", Font.ITALIC, 14);


        this.gotCommand = false;
        this.command = "";
        this.setTitle("TextGame");
        this.setSize(1270, 850);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setUpElements();
        setUpPanel();
        this.add(panel);
        this.setVisible(true);
        this.setResizable(false);
        this.panel.add(text);
        this.panel.setBackground(Color.cyan);
        text.setFont(fontB);
        text.setText("\n");



        input.setFont(fontA);
        Room1.setFont(fontB);
        Room2.setFont(fontC);
        Room3.setFont(fontC);
        Room4.setFont(fontC);

        this.inventory.setFont(fontB);
        this.button.setFont(fontC);

        this.Room1.setBackground(Color.cyan);
        this.Room2.setBackground(Color.yellow);
        this.Room3.setBackground(Color.green);
        this.Room4.setBackground(Color.magenta);

    }

    // Returnera det senaste commitade kommandot
    public String getCommand() {
        if (this.gotCommand) {
            return this.command;
        }
        return "-1";

    }

    // Här kan man updatera respektive fält:
    public void setShowRoom1(String roomDescription) {
        this.Room1.setText(roomDescription);
    }

    public void setShowRoom2(String roomDescription) {
        this.Room2.setText(roomDescription);
    }

    public void setShowRoom3(String roomDescription) {
        this.Room3.setText(roomDescription);
    }

    public void setShowRoom4(String roomDescription) {
        this.Room4.setText(roomDescription);
    }

    public void setShowInventory(Inventory i) {
        this.inventory.setText(":::::::::::"+i.toString()+":::::::::::");
    }

    // *******************
    public void setShowPlayer(Person p, Room room, int position) {

        if (position == 0) {
            this.Room1.setText("\n" + p.toString() + " \n" + room);
        }

        if (position == 1) {
            this.Room2.setText("\n" + p.toString() + "\n" + room);
        }
        if (position == 2) {
            this.Room3.setText("\n" + p.toString() + " \n" + room);
        }
        if (position == 3) {
            this.Room4.setText("\n" + p.toString() + "\n" + room);
        }
    }

    // Nedantåenda spaghetti är inte vacker...

    public void gotCommand() {
        this.gotCommand = false;
    }

    private void setUpPanel() {

        this.panel.add(Room1);
        this.panel.add(Room2);
        this.panel.add(Room3);
        this.panel.add(Room4);

        this.panel.add(input);
        this.panel.add(inventory);
        this.panel.add(button);

    }

    private void setUpElements() {
        this.panel = new JPanel(new GridLayout(4, 4));
        // this.showRoom = new JTextArea("Room: ");
        this.Room1 = new JTextArea("r1: \n");// nunu
        this.Room2 = new JTextArea("r2: \n");// nunu
        this.Room3 = new JTextArea("r3: \n");// nunu
        this.Room4 = new JTextArea("r4: \n");// nunu

        // this.showPersons = new JTextArea("Persons");
        this.inventory = new JTextArea("Inventory");
        this.input = new JTextField("");

        // this.showPersons.setEditable(false);
        this.Room1.setEditable(false);
        this.Room2.setEditable(false);
        this.Room3.setEditable(false);
        this.Room4.setEditable(false);
        this.inventory.setEditable(false);

        ActionListener inputListener = e -> {
            this.command = input.getText();
            this.gotCommand = true;
        };

        input.addActionListener(inputListener);

        this.button = new JButton("Commit");
        this.button.addActionListener(inputListener);

    }

    public void setMessage(String string) {
        text.setText("Choose Rooms <1-4>\n Pick up <pick + item> \nLeave <leave + item>" );
    }




}