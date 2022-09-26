import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.Random;
import java.util.ArrayList;
import java.util.List;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

//class #1, move to game class window
public class Game {
    //creates window
    JFrame window;
    Container container;
    //creates title panel
    JPanel titleNamePanel, startButtonPanel, mainTextPanel, choiceButtonPanel, playerStatsPanel;
    JLabel titleNameLabel, healthLabel, healthLabelNumber, attackLabel, attackLabelNumber, defenseLabel, defenseLabelNumber, speedLabel, speedLabelNumber, luckLabel, luckLabelNumber;
    Font titleFont = new Font("Papyrus", Font.PLAIN, 60);
    Font normalFont = new Font("Papyrus", Font.PLAIN, 20);
    Font statsFont = new Font("Papyrus", Font.PLAIN, 16);
    JButton startButton, choice1, choice2, choice3, choice4, reset;
    JTextArea mainTextArea;
    int playerHealth;
    int playerAttack;
    int playerDefense;
    int playerSpeed;
    int playerLuck;
    String position;

    int randomChance;


    titleScreenHandler tsHandler = new titleScreenHandler();
    ChoiceHandler choiceHandler = new ChoiceHandler();

    public static void main(String[] args) {

        new Game();
    }

    public Game() {

        //initialized JFrame
        window = new JFrame();
        window.setSize(800, 700);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.pink);
        window.setLayout(null);
        container = window.getContentPane();


        titleNamePanel = new JPanel();
        //makes space for text (x axis, y axis, width, height)
        titleNamePanel.setBounds(100, 100, 600, 150);
        titleNamePanel.setBackground(Color.pink);

        titleNameLabel = new JLabel("Stuck in Casino Game");
        titleNameLabel.setForeground(Color.black);
        titleNameLabel.setFont(titleFont);

        //makes the panel for button
        startButtonPanel = new JPanel();
        startButtonPanel.setBounds(300, 400, 200, 100);
        startButtonPanel.setBackground(Color.pink);

        //this makes the button, adds details
        startButton = new JButton("Start");
        startButton.setBackground(Color.CYAN);
        startButton.setForeground(Color.BLACK);
        startButton.setFont(normalFont);
        //when u click start button, it recognizes the click and call the tsHandler
        startButton.addActionListener(tsHandler);
        //in case there is a line around text, use this for each button
        startButton.setFocusPainted(false);

        //adds titleNamePanel to the Container IF U DONT HAVE THIS, WHAT U DID ABOVE WILL NOT SHOW UP
        container.add(titleNamePanel);
        container.add(startButtonPanel);
        startButtonPanel.add(startButton);
        //adds titleNameLabel to the titleNamePanel
        titleNamePanel.add(titleNameLabel);

        //makes window visible THIS HAS TO BE AT THE BOTTOM OF THE METHOD
        window.setVisible(true);

        //when u click start button, it recognizes the click and call the tsHandler
        startButton.addActionListener(tsHandler);
    }

    public void createGameScreen() {

        //disable button panel and title screen panel otherwise if u click button it will stay on the same page
        titleNamePanel.setVisible(false);
        startButton.setVisible(false);
        startButtonPanel.setVisible(false);

        mainTextPanel = new JPanel();
        mainTextPanel.setBounds(100, 100, 600, 250);
        mainTextPanel.setBackground(Color.pink);
        container.add(mainTextPanel);

        mainTextArea = new JTextArea("Main Text Area");
        mainTextArea.setBounds(100, 100, 600, 250);
        mainTextArea.setBackground(Color.pink);
        mainTextArea.setForeground(Color.black);
        mainTextArea.setFont(normalFont);
        //if the text is too long, it will be wrapped automatically
        mainTextArea.setLineWrap(true);
        mainTextPanel.add(mainTextArea);

        choiceButtonPanel = new JPanel();
        choiceButtonPanel.setBounds(200, 350, 300, 400);
        choiceButtonPanel.setBackground(Color.pink);
        //sets layout for button (rows, columns) i commented in out bc it looks wierd with it rn but we might use it later on
        choiceButtonPanel.setLayout(new GridLayout(4, 1));
        container.add(choiceButtonPanel);

        choice1 = new JButton("Choice 1");
        choice1.setBackground(Color.black);
        choice1.setForeground(Color.black);
        choice1.setFont(normalFont);
        choice1.setFocusPainted(false);
        choice1.addActionListener(choiceHandler);
        choice1.setActionCommand("c1");
        choiceButtonPanel.add(choice1);

        choice2 = new JButton("Choice 2");
        choice2.setBackground(Color.black);
        choice2.setForeground(Color.black);
        choice2.setFont(normalFont);
        choice2.setFocusPainted(false);
        choice2.addActionListener(choiceHandler);
        choice2.setActionCommand("c2");
        choiceButtonPanel.add(choice2);

        choice3 = new JButton("Choice 3 ");
        choice3.setBackground(Color.black);
        choice3.setForeground(Color.black);
        choice3.setFont(normalFont);
        choice3.addActionListener(choiceHandler);
        choice3.setActionCommand("c3");
        choiceButtonPanel.add(choice3);

        choice4 = new JButton("Choice 4 ");
        choice4.setBackground(Color.black);
        choice4.setForeground(Color.black);
        choice4.setFont(normalFont);
        choice4.addActionListener(choiceHandler);
        choice4.setActionCommand("c4");
        choiceButtonPanel.add(choice4);

        playerStatsPanel = new JPanel();
        playerStatsPanel.setBounds(100, 15, 600, 50);
        playerStatsPanel.setBackground(Color.white);
        playerStatsPanel.setLayout(new GridLayout(1, 4));
        container.add(playerStatsPanel);

        healthLabel = new JLabel("Health: ");
        healthLabel.setFont(statsFont);
        healthLabel.setForeground(Color.black);
        playerStatsPanel.add(healthLabel);

        healthLabelNumber = new JLabel();
        healthLabelNumber.setFont(statsFont);
        healthLabelNumber.setForeground(Color.black);
        playerStatsPanel.add(healthLabelNumber);


        attackLabel = new JLabel("Attack: ");
        attackLabel.setFont(statsFont);
        healthLabel.setForeground(Color.BLACK);
        playerStatsPanel.add(attackLabel);

        attackLabelNumber = new JLabel();
        attackLabelNumber.setFont(statsFont);
        attackLabelNumber.setForeground(Color.black);
        playerStatsPanel.add(attackLabelNumber);

        defenseLabel = new JLabel("Defense: ");
        defenseLabel.setFont(statsFont);
        defenseLabel.setForeground(Color.black);
        playerStatsPanel.add(defenseLabel);

        defenseLabelNumber = new JLabel();
        defenseLabelNumber.setFont(statsFont);
        defenseLabelNumber.setForeground(Color.black);
        playerStatsPanel.add(defenseLabelNumber);

        speedLabel = new JLabel("Speed: ");
        speedLabel.setFont(statsFont);
        speedLabel.setForeground(Color.black);
        playerStatsPanel.add(speedLabel);

        speedLabelNumber = new JLabel();
        speedLabelNumber.setFont(statsFont);
        speedLabelNumber.setForeground(Color.black);
        playerStatsPanel.add(speedLabelNumber);

        luckLabel = new JLabel("Luck: ");
        luckLabel.setFont(statsFont);
        luckLabel.setForeground(Color.black);
        playerStatsPanel.add(luckLabel);

        luckLabelNumber = new JLabel();
        luckLabelNumber.setFont(statsFont);
        luckLabelNumber.setForeground(Color.black);
        playerStatsPanel.add(luckLabelNumber);

        playerSetup();
    }

    public void playerSetup() {
        //set parameters
        playerHealth = 7;
        playerAttack = 7;
        playerSpeed = 9;
        playerDefense = 10;
        playerLuck = 8;

        healthLabelNumber.setText("" + playerHealth);
        speedLabelNumber.setText("" + playerSpeed);
        attackLabelNumber.setText("" + playerAttack);
        defenseLabelNumber.setText("" + playerDefense);
        luckLabelNumber.setText("" + playerLuck);
        casinoLobby();
    }

    public void casinoLobby() {
        position = "casinoLobby";
        mainTextArea.setText("U r in the casino lobby. The story will be in here. \n Guard: u cant be in here either solve a puzzle or leave to move on ");
        choice1.setText("Solve Puzzle");
        choice2.setText("Fight Casino Host");
        choice3.setText("Try to sneak in"); //random chance
        choice4.setText("Leave");
    }

    public void solvePuzzle() {
        position = "solvePuzzle";
        mainTextArea.setText("Casino Host: ok this is the puzzle ");
        choice1.setText(">");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");

    }

    public void attackHost() {
        position = "attackHost";
        mainTextArea.setText("Casino Host: omg u attacked me get ready to fight to death  \n u receive 3 damage "); //battle if u lose u die
        playerHealth = playerHealth - 3;
        healthLabelNumber.setText("" + playerHealth);
        choice1.setText(">");
        choice2.setText(">");
        choice3.setText("");
        choice4.setText("");
    }

    //u WILL HAVE A RANDOM CHANCE OF SNEAKING IN IF U DONT U WILL GO BACK TO LOBBY
    public void sneakIn() {
        position = "sneakIn";
        mainTextArea.setText("DO u want to sneak in through the bathrooms or through the kitchen?");
        choice1.setText("Bathrooms");
        choice2.setText("Kitchen");
        choice3.setText("Go back");
        choice4.setText("");

    }

    public void blockedExit() {
        position = "blockedExit";
        mainTextArea.setText(" u cant leave u need a key to exit and the boss has the key. u gotta get it and come back.");
        choice1.setText("Back to main lobby");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");

    }

    public void bathroomFailed() {
        position = "bathroomFailed";
        mainTextArea.setText("You got caught");
        choice1.setText("Restart Game");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");

    }

    public void bathroomSuccess() {
        position = "bathroomSuccess";
        mainTextArea.setText("You snuck in!");
        choice1.setText("Go to hallway");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");

    }
    public void hallway(){
            position = "hallway";
            mainTextArea.setText("You are now in the hallway");
            choice1.setText("leftDoor");
            choice2.setText("rightDoor");
            choice3.setText("frontDoor");
            choice4.setText("");
    }

    public void leftDoor(){
        position = "leftDoor";
        mainTextArea.setText("You are now in the Queens Area");
        choice1.setText("idk");
        choice2.setText("idk");
        choice3.setText("idk");
        choice4.setText("idk");

    }

    public void rightDoor(){
        position = "rightDoor";
        mainTextArea.setText("You are now in the KingsArea");
        choice1.setText("idk");
        choice2.setText("idk");
        choice3.setText("idk");
        choice4.setText("idk");

    }
    public void frontDoor() {
        position = "frontDoor";
        mainTextArea.setText("You are now in the Jacks Area");
        choice1.setText("idk");
        choice2.setText("idk");
        choice3.setText("idk");
        choice4.setText("idk");

    }


    public Random random = new Random();
    public boolean randomChance() {
        return random.nextBoolean();
    }
    /*public int randomChance() {
        if (random.nextBoolean()) {
            return 1;
        } else {
            return 0;
        }
    }*/

    //class #2 move to a class window
    public class titleScreenHandler implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            createGameScreen();
        }
    }
    public class ChoiceHandler implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            String yourChoice = event.getActionCommand(); //adds action command to whatever button is clicked. If u click c1 its will add that to the your choice string

            //add results to buttons



            switch(position){
                case "casinoLobby": //recognizes position
                    switch(yourChoice){
                        case "c1": solvePuzzle(); break;
                        case "c2": attackHost(); break;
                        case "c3": sneakIn(); break;
                        case "c4": blockedExit(); break;
                    }
                    break;

                case "solvePuzzle":
                    switch(yourChoice) {
                        case "c1": casinoLobby(); break;
                        case "c2": break;
                        case "c3": break;
                        case "c4": break;
                    }
                    break;

                case "attackHost":
                    switch (yourChoice){
                        case "c1": casinoLobby(); break;
                        case "c2": break;
                        case "c3": break;
                        case "c4": break;
                    }
                    break;

                case "sneakIn":
                    switch (yourChoice){
                        case "c1":
                            if (randomChance())
                            { bathroomFailed();}
                            else{
                                bathroomSuccess();}
                        case "c2":
                        case "c4":
                        case "c3": break;
                    }
                    break;


                case "hallway":
                    switch(yourChoice){
                        case "c1": leftDoor();break;
                        case "c2": rightDoor(); break;
                        case "c3": frontDoor(); break;
                        case "c4": break;
                    }
                    break;

                case "bathroomSuccess":
                     switch(yourChoice){
                         case "c1": hallway();break;
                         case "c2":  break;
                         case "c3":  break;
                         case "c4": break;
            }

        }
             }}}

