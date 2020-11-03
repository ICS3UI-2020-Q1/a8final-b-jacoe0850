import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main implements Runnable, ActionListener{

  // Class Variables  
  JPanel mainPanel;

  JButton countButton;
  JButton resetButton;

  JTextField countBox;

  JLabel counterLabel;
  int count;

  // Method to assemble our GUI
  public void run(){
    // Creats a JFrame that is 800 pixels by 600 pixels, and closes when you click on the X
    JFrame frame = new JFrame("Count");
    // Makes the X button close the program
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // makes the windows 800 pixel wide by 600 pixels tall
    frame.setSize(800,600);
    // shows the window
    frame.setVisible(true);

    mainPanel = new JPanel();
    mainPanel.setLayout(null);
    //add mainPanel to frame
    frame.add(mainPanel);
    //make the label, location and add to panel
    counterLabel = new JLabel("Counter:");
    counterLabel.setBounds(175,230,100,40);
    mainPanel.add(counterLabel);
    //make the textfield, location and add to panel
    countBox = new JTextField();
    countBox.setBounds(300,230,100,40);
    mainPanel.add(countBox);
    //make the buttons, location, action listening and putting it on the panel
    countButton = new JButton("count");
    resetButton = new JButton("reset");
    countButton.setBounds(175,200,100,20);
    resetButton.setBounds(280,200,95,20);
    countButton.addActionListener(this);
    resetButton.addActionListener(this);
    mainPanel.add(countButton);
    mainPanel.add(resetButton);
    //make it so user cannot type inside of textfield
    countBox.setEnabled(false);
  }

  // method called when a button is pressed
  public void actionPerformed(ActionEvent e){
    // get the command from the action
    String command = e.getActionCommand();
    // if statement for when you pres count
    if(command.equals("count")){
      if(count <= 9){
        count = count + 1;
        countBox.setText("" + count);
      }
    }
  // if statement for when you press reset
  if(command.equals("reset")){
    count = 0;
    countBox.setText("0");
  }
  }
  // Main method to start our program
  public static void main(String[] args){
    // Creates an instance of our program
    Main gui = new Main();
    // Lets the computer know to start it in the event thread
    SwingUtilities.invokeLater(gui);
  }
}
