//****************************************************************************************************************
// Air Wars: Eagle Day project for CSCI 450 Software Engineering
//***IF YOU MAKE CHANGES TO THE CODE, PLEASE MAKE CLEAR AND CONCISE COMMENTS***
//When coding, please make sure when you are done, we have a clean build that always runs, if you create an 
//	unstable build and you are done working, revert it to the last stable build and just comment out any code
//	you want to keep to work on later. But make sure the commented code is still in an organized manner so other 
//	people will be able to work around it, and if the code is unneeded please remove it.
//Keep the code clean 
//		- Make all variable and class names understandable and clear
//		- Indent lines in the correct manner to insure organization and readability
//		- Erase unneeded code and unused variables 
//		- Make good comments on everything so everyone can understand what every line is doing	
//When dealing with files relating to the project
//		- Please make all file names clear and understandable
//		- Please upload all the files to the project Dropbox so everyone has access
//		- Java in Eclipse works with file extensions .jpg, .png, and .gif 
//
//**********LEARN AND UNDERSTAND HOW THE CODE WORKS BEFORE MAKING ANY CHANGES TO REDUCE NUMBER OF ERRORS**********
//****************************************************************************************************************

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.awt.Color;

import javax.swing.border.*;


public class gameMain extends JFrame {

	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				gameMain thisClass = new gameMain();
				thisClass.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				thisClass.setVisible(true);
				thisClass.setResizable(false);		//Makes window static and not resizable
			}
		});
	}
	
	private ImageIcon backgroundMapImage = new ImageIcon ("files/MapFinal.png"); //loads map image
	private ImageIcon test = new ImageIcon("files/CARD_TEST.png");

	// Declaration of variables	
	private int dice;			//variable for the rolling of die
	private String diceValue;	//The output variable for the final dice value after roll
	
	// these arrays are for the cardStack of cards.
	// You have as many or as few cards as you choose.
	private String[] britishCardStack = new String[10];
	private String[] germanCardStack = new String[10];
	
	// these vectors hold the players cards
	private Vector<String> Player1Cards = new Vector<String>();
	private Vector<String> Player2Cards = new Vector<String>();
	
	// Declaration of GUI panels and components
	private Border blackline = BorderFactory.createLineBorder(Color.black);		//declaration of the blackline border
	private Border loweredbevel = BorderFactory.createLoweredBevelBorder();		//declaration of border to create card border
	
	private JButton endTurn = null;			//declare play button / endTurn button
	private JButton newGame = null;			//declare newGame button
	private JButton help = null;			//declare help button
	private JButton displayRoster = null;	//declare the displayRoster button to display the roster to user
	private JButton drawCards = null;		//declare drawCard button
	private JButton rollDie = null;			//declare rollDie button
	private JButton cardLeft = null;		//declare button that moves cards to the left so user can view them
	private JButton cardRight = null;		//declare button that moves cards to the right so user can view them
	
	private JPanel ControlPanel = null;		//declare the main control panel
	
	private JTextArea messagebox = null;	//declare the message box to display text to the user
	
	private JLabel background = null;				//declare the map label
	private JLabel day = null;						//day variable
	private JLabel dayLabel = null;					//declare the day label
	private JLabel hour = null;						//hour variable
	private JLabel hourLabel = null;				//declare the hour label
	private JLabel phase = null;					//phase variable
	private JLabel phaseLabel = null;				//declare the phase label
	private JLabel RAF_Commandlvl = null;			//RAF Command Level variable
	private JLabel RAF_Commandlvl_Label = null;		//declare the RAF_Commandlevel label
	private JLabel Luft_Commandlvl = null;			//Luft Command Level variable
	private JLabel Luft_Commandlvl_Label = null;	//declare the Luftwaffe_Command Level label
	private JLabel cardDisplay = null;				//declaration for the label to display the cards
	private JLabel currentPlayer = null;			//current player variable
	private JLabel currentPlayerLabel = null;		//declare the current player label
	private JLabel messageboxLabel = null;			//declare the box that displays messages to the user 
	private JLabel dieValue = null; 				//variable for the die Value

	
	
	/**
	 * This is the default constructor 
	 */
	public gameMain() {
		super();
		initialize();
	}
	
	//Implements the newGame JButton
	private JButton getNewGame() {
		if (this.newGame == null) {
			this.newGame = new JButton();
			this.newGame.setBounds(new Rectangle(967, 5, 90, 25));	
			this.newGame.grabFocus();
			this.newGame.setText("New Game"); 
			//this.NewGame.addActionListener(new java.awt.event.ActionListener() {
				//public void actionPerformed(java.awt.event.ActionEvent e) {
					//ADD NEWGAME BUTTON CODE HERE (UNCOMMENT ABOVE 2 LINES WHEN IMPLEMENTING)
		}
		return this.newGame;
	}

	
	//Implements the endTurn JButton
	private JButton getEndTurn() {
		if (this.endTurn == null) {
			this.endTurn = new JButton();
			this.endTurn.setBounds(new Rectangle(967, 420, 150, 25));
			this.endTurn.setText("End Turn");
			//this.play.addActionListener(new java.awt.event.ActionListener() {
				//public void actionPerformed(java.awt.event.ActionEvent e) {
					//ADD PLAY BUTTON CODE HERE (UNCOMMENT ABOVE 2 LINES WHEN IMPLEMENTING)
			
		}
		return this.endTurn;
	}
	
	//Implements the help JButton
	private JButton getHelp() {
		if (this.help == null) {
			this.help = new JButton();
			this.help.setBounds(new Rectangle(1175, 5, 90, 25));
			this.help.setText("Help");
			this.help.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					JFrame helpWindow = new JFrame("Help Menu");
					JLabel emptyLabel = new JLabel("");
			        emptyLabel.setPreferredSize(new Dimension(500, 300));		//set dimensions of help window
			        helpWindow.getContentPane().add(emptyLabel, BorderLayout.CENTER);
			        
			        //INSERT CODE FOR INSTRUCTIONS AND GAME KEYS HERE

			        //Display the help menu window
			        helpWindow.pack();
					helpWindow.setVisible(true);
				}
			});
		}
		return this.help;
	}
	
	//Implements the displayRoster JButton
	private JButton getDisplayRoster() {
		if (this.displayRoster == null) {
			this.displayRoster = new JButton();
			this.displayRoster.setBounds(new Rectangle(1053, 40, 125, 25));
			this.displayRoster.setText("Display Roster");
			//this.displayRoster.addActionListener(new java.awt.event.ActionListener() {
				//public void actionPerformed(java.awt.event.ActionEvent e) {
					//ADD DISPLAY ROSTER BUTTON CODE HERE (UNCOMMENT ABOVE 2 LINES WHEN IMPLEMENTING)
		}
		return this.displayRoster;
	}
	
	//Implements the drawCards JButton
	private JButton getDrawCards() {
		if (this.drawCards == null) {
			this.drawCards = new JButton();
			this.drawCards.setBounds(new Rectangle(1053, 115, 125, 25));
			this.drawCards.setText("Draw Cards");
			//this.displayRoster.addActionListener(new java.awt.event.ActionListener() {
				//public void actionPerformed(java.awt.event.ActionEvent e) {
					//ADD DISPLAY ROSTER BUTTON CODE HERE (UNCOMMENT ABOVE 2 LINES WHEN IMPLEMENTING)
		}
		return this.drawCards;
	}
	
	//Implements the cardLeft JButton
	private JButton getCardLeft() {
		if (this.cardLeft == null) {
			this.cardLeft = new JButton();
			this.cardLeft.setBounds(new Rectangle(1090, 377, 20, 25));
			this.cardLeft.setText("<");
			//this.displayRoster.addActionListener(new java.awt.event.ActionListener() {
				//public void actionPerformed(java.awt.event.ActionEvent e) {
					//ADD DISPLAY ROSTER BUTTON CODE HERE (UNCOMMENT ABOVE 2 LINES WHEN IMPLEMENTING)
		}
		return this.cardLeft;
	}
	
	//Implements the cardRight JButton
	private JButton getCardRight() {
		if (this.cardRight == null) {
			this.cardRight = new JButton();
			this.cardRight.setBounds(new Rectangle(1120, 377, 20, 25));
			this.cardRight.setText(">");
			//this.displayRoster.addActionListener(new java.awt.event.ActionListener() {
				//public void actionPerformed(java.awt.event.ActionEvent e) {
					//ADD DISPLAY ROSTER BUTTON CODE HERE (UNCOMMENT ABOVE 2 LINES WHEN IMPLEMENTING)
		}
		return this.cardRight;
	}
	
	//Implements the rollDie JButton
	private JButton getRollDie() {
		if (this.rollDie == null) {
			this.rollDie = new JButton();
			this.rollDie.setBounds(new Rectangle(1115, 420, 150, 25));
			this.rollDie.setText("Roll Die");
			this.rollDie.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					String diceValue = " ";
					dice = (int)(Math.random()*11) + 2;
					diceValue = "Value: " + dice;
					gameMain.this.dieValue.setText(diceValue);
				}
			});
		}	
		return this.rollDie;
	}
         

	private void initialize() {
		this.setSize(1280, 720);				//sets size-resolution for main window
		this.setTitle("Air Wars: Eagle Day");	//sets  title for main window
		this.setLocationRelativeTo(null);
		
		// Initializing GUI panels and components
		this.ControlPanel = new JPanel();
		this.ControlPanel.setLayout(new GridBagLayout());		//set layout for panels and components
		
		this.currentPlayerLabel = new JLabel();
		this.currentPlayerLabel.setBounds(new Rectangle(1040, 70, 125, 25));
		this.currentPlayerLabel.setText("Current Player: ");
		this.add(currentPlayerLabel);
		this.currentPlayer = new JLabel();
		this.currentPlayer.setBounds(new Rectangle(1140, 70, 125, 25));
		this.currentPlayer.setText("British");		// British and German are the players
		this.add(currentPlayer);
		
		this.dayLabel = new JLabel();												
		this.dayLabel.setBounds(new Rectangle(375, 590, 28, 20));
		this.dayLabel.setText("Day");
		this.add(dayLabel);															
		this.day = new JLabel();
		this.day.setBounds(new Rectangle(375, 610, 28, 20));
		this.day.setText("1");
		this.day.setBorder(this.blackline);
		this.day.setHorizontalAlignment(SwingConstants.CENTER);
		this.add(day);
		
		this.hourLabel = new JLabel();												
		this.hourLabel.setBounds(new Rectangle(425, 590, 35, 20));	
		this.hourLabel.setText("Hour");
		this.add(hourLabel);														
		this.hour = new JLabel();
		this.hour.setBounds(new Rectangle (425, 610, 35, 20));
		this.hour.setText("1");
		this.hour.setBorder(this.blackline);
		this.hour.setHorizontalAlignment(SwingConstants.CENTER);
		this.add(hour);
		
		this.phaseLabel = new JLabel();
		this.phaseLabel.setBounds(new Rectangle(498, 590, 40, 20));
		this.phaseLabel.setText("Phase");
		this.add(phaseLabel);
		this.phase = new JLabel();
		this.phase.setBounds(new Rectangle(475, 610, 90, 20));
		this.phase.setText("Planning");
		this.phase.setBorder(this.blackline);
		this.phase.setHorizontalAlignment(SwingConstants.CENTER);
		this.add(phase);
		
		this.RAF_Commandlvl_Label = new JLabel();									
		this.RAF_Commandlvl_Label.setBounds(new Rectangle(10, 590, 130, 20));
		this.RAF_Commandlvl_Label.setText("RAF Command Level");
		this.add(RAF_Commandlvl_Label);												
		this.RAF_Commandlvl = new JLabel();
		this.RAF_Commandlvl.setBounds(new Rectangle(10, 610, 130, 20));
		this.RAF_Commandlvl.setText("1");
		this.RAF_Commandlvl.setBorder(this.blackline);
		this.RAF_Commandlvl.setHorizontalAlignment(SwingConstants.CENTER);
		this.add(RAF_Commandlvl);
		
		this.Luft_Commandlvl_Label = new JLabel();									
		this.Luft_Commandlvl_Label.setBounds(new Rectangle(775, 590, 177, 20));
		this.Luft_Commandlvl_Label.setText("Luftwaffe Commmand Level");
		this.add(Luft_Commandlvl_Label);											
		this.Luft_Commandlvl = new JLabel();
		this.Luft_Commandlvl.setBounds(new Rectangle(775, 610, 177, 20));
		this.Luft_Commandlvl.setText("1");
		this.Luft_Commandlvl.setBorder(this.blackline);
		this.Luft_Commandlvl.setHorizontalAlignment(SwingConstants.CENTER);
		this.add(Luft_Commandlvl);
		
		this.cardDisplay = new JLabel();
		this.cardDisplay.setBounds(new Rectangle(1045, 140, 140, 230));	
		this.cardDisplay.setText("");
		this.cardDisplay.setBackground(Color.black);
		this.cardDisplay.setIcon(test);
		this.cardDisplay.setBorder(this.loweredbevel);
		this.add(cardDisplay);
		
		this.dieValue = new JLabel();
		this.dieValue.setBounds(new Rectangle(1115, 450, 150, 25));
		this.dieValue.setText("");
		this.dieValue.setBorder(this.blackline);
		this.dieValue.setHorizontalAlignment(SwingConstants.CENTER);
		this.add(dieValue);
		
		this.messagebox = new JTextArea();
		this.messagebox.setBounds(new Rectangle(965, 490, 300, 100));	
		this.messagebox.setText("");
		this.messagebox.setBorder(this.blackline);
		messagebox.setBackground(new Color(220, 220, 250));	
		this.messagebox.setEditable(false);
		this.add(messagebox, null);
		this.messageboxLabel = new JLabel();
		this.messageboxLabel.setBounds(new Rectangle(965, 470, 100, 25));
		this.messageboxLabel.setText("Message Box");
		this.add(messageboxLabel);
		
		//add JButtons to GUI
		this.add(getNewGame(), null);				//add newGame button to GUI
		this.add(getEndTurn(), null);				//add play button to GUI
		this.add(getHelp(), null);					//add help button to GUI 
		this.add(getRollDie(), null);				//add rollDie button to GUI
		this.add(getDisplayRoster(), null);			//add displayRoster button to GUI
		this.add(getDrawCards(), null);				//add drawCards button to GUI
		this.add(getCardLeft(), null);				//add cardLeft button to GUI
		this.add(getCardRight(), null);				//add cardRight button to GUI
		
		
		//setLayout(new BorderLayout()); 		
		JLabel background = new JLabel(backgroundMapImage);
		//background.setLayout(new OverlayLayout(background));	//overlay for multiple images
		add(background);		
	}

	
}
