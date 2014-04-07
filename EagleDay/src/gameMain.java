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

//first round the user sees all of the tokens, after placing all of them the UI 
//changes to show Abort and Damage. 

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
	
	
	//DECLARATION OF IMAGES
	private ImageIcon backgroundMapImage = new ImageIcon ("files/MapFinal.png"); 	//loads map image
	private ImageIcon test = new ImageIcon("files/CARD_TEST.png");
	//British Tokens
	private ImageIcon AA1_1 = new ImageIcon("britishTokens/AA1_1.jpg"); 
	private ImageIcon AA1_2 = new ImageIcon("britishTokens/AA1_2.jpg");
	private ImageIcon AA1_3 = new ImageIcon("britishTokens/AA1_3.jpg");
	private ImageIcon AA2_1 = new ImageIcon("britishTokens/AA2_1.jpg");
	private ImageIcon AA2_2 = new ImageIcon("britishTokens/AA2_2.jpg");
	private ImageIcon Blen = new ImageIcon("brisithTokens/Blen_1.jpg");
	private ImageIcon Decoy_1 = new ImageIcon("britishTokens/Decoy_1.jpg");
	private ImageIcon Decoy_2 = new ImageIcon("britishTokens/Decoy_2.jpg");
	private ImageIcon Decoy_3 = new ImageIcon("britishTokens/Decoy_3.jpg");
	private ImageIcon Defiant = new ImageIcon("britishTokens/Defiant_1.jpg");
	private ImageIcon HQ_10 = new ImageIcon("britishTokens/HQ_10group.jpg");
	private ImageIcon HQ_11 = new ImageIcon("britishTokens/HQ_11group.jpg");
	private ImageIcon HQ_12 = new ImageIcon("britishTokens/HQ_12group.jpg");
	private ImageIcon Hurri_1 = new ImageIcon("britishTokens/Hurri_1.jpg");
	private ImageIcon Hurri_2 = new ImageIcon("britishTokens/Hurri_2.jpg");
	private ImageIcon Hurri_3 = new ImageIcon("britishTokens/Hurri_3.jpg");
	private ImageIcon Spitfire_1 = new ImageIcon("britishTokens/Spitfire_1.jpg");
	private ImageIcon Spitfire_2 = new ImageIcon("britishTokens/Spitfire_2.jpg");
	//German Tokens
	private ImageIcon Do17_1 = new ImageIcon("germanTokens/Do17_1.jpg");
	private ImageIcon Do17_2 = new ImageIcon("germanTokens/Do17_2.jpg");
	private ImageIcon He111_1 = new ImageIcon("germanTokens/He111_1.jpg");
	private ImageIcon He111_2 = new ImageIcon("germanTokens/He111_2.jpg");
	private ImageIcon He111_3 = new ImageIcon("germanTokens/He111_3.jpg");
	private ImageIcon He111_4 = new ImageIcon("germanTokens/He111_4.jpg");
	private ImageIcon He115 = new ImageIcon("germanTokens/He115_1.jpg");
	private ImageIcon Ju87_1 = new ImageIcon("germanTokens/Ju87_1.png");
	private ImageIcon Ju87_2 = new ImageIcon("germanTokens/Ju87_2.jpg");
	private ImageIcon Ju88_1 = new ImageIcon("germanTokens/Ju88_1.jpg");
	private ImageIcon Ju88_2 = new ImageIcon("germanTokens/Ju88_2.jpg");
	private ImageIcon Ju88_3 = new ImageIcon("germanTokens/Ju88_3.jpg");
	private ImageIcon Me109_1 = new ImageIcon("germanTokens/Me109_1.jpg");
	private ImageIcon Me109_2 = new ImageIcon("germanTokens/Me109_2.jpg");
	private ImageIcon Me109_3 = new ImageIcon("germanTokens/Me109_3.jpg");
	private ImageIcon Me109_4 = new ImageIcon("germanTokens/Me109_4.jpg");
	private ImageIcon Me110_1 = new ImageIcon("germanTokens/Me110_1.jpg");
	private ImageIcon Me110_2 = new ImageIcon("germanTokens/Me110_2.jpg");
	//Cards
	private ImageIcon GED01 = new ImageIcon("cards/GED01.png");
	private ImageIcon GED02 = new ImageIcon("cards/GED02.png");
	private ImageIcon GED03 = new ImageIcon("cards/GED03.png");
	private ImageIcon GED04 = new ImageIcon("cards/GED04.png");
	private ImageIcon GED05 = new ImageIcon("cards/GED05.png");
	private ImageIcon GED06 = new ImageIcon("cards/GED06.png");
	private ImageIcon GED07 = new ImageIcon("cards/GED07.png");
	private ImageIcon GED08 = new ImageIcon("cards/GED08.png");
	private ImageIcon GED09 = new ImageIcon("cards/GED09.png");
	private ImageIcon BED10 = new ImageIcon("cards/BED10.png");
	private ImageIcon BED11 = new ImageIcon("cards/BED11.png");
	private ImageIcon BED12 = new ImageIcon("cards/BED12.png");
	private ImageIcon BED13 = new ImageIcon("cards/BED13.jpg");
	private ImageIcon BED14 = new ImageIcon("cards/BED14.jpg");
	private ImageIcon BED15 = new ImageIcon("cards/BED15.jpg");
	private ImageIcon BED16 = new ImageIcon("cards/BED16.jpg");
	private ImageIcon BED17 = new ImageIcon("cards/BED17.jpg");
	private ImageIcon BED18 = new ImageIcon("cards/BED18.jpg");
	
	

	// Declaration of variables	
	private int dice;			//variable for the rolling of die
	private String diceValue;	//The output variable for the final dice value after roll
	
	// these arrays are for the cardStack of cards. 
	// You have as many or as few cards as you choose.
	private Vector<ImageIcon> britishCardStack = new Vector<ImageIcon>();	//9 British cards
	private Vector<ImageIcon> germanCardStack = new Vector<ImageIcon>();	//9 German cards
	// these vectors hold the players cards
	private Vector<ImageIcon> britishCurrentCards = new Vector<ImageIcon>();	//British users current cards
	private Vector<ImageIcon> germanCurrentCards = new Vector<ImageIcon>();		//German users current cards
	
	//Vectors to hold the tokens at different intervals of the game
	private Vector<ImageIcon> britishTokenStack = new Vector<ImageIcon>();		//18 British Tokens to start
	private Vector<ImageIcon> germanTokenStack = new Vector<ImageIcon>();		//18 German Tokens to start
	private Vector<ImageIcon> britishAbortStack = new Vector<ImageIcon>();		//British aborted tokens
	private Vector<ImageIcon> britishDamageStack = new Vector<ImageIcon>();		//British damaged tokens
	private Vector<ImageIcon> germanAbortStack = new Vector<ImageIcon>();		//German aborted tokens
	private Vector<ImageIcon> germanDamageStack = new Vector<ImageIcon>();		//German damaged tokens
	

	
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
	private JLabel RAF_Abort = null;				//declare abort label for RAF
	private JLabel RAF_Damage = null;				//declare damage label for RAF
	private JLabel Luft_Abort = null;				//declare abort label for Luftwaffe
	private JLabel Luft_Damage = null;				//declare damage label for Luftwaffe
	private JLabel RAF_Commandlvl = null;			//RAF Command Level variable
	private JLabel RAF_Commandlvl_Label = null;		//declare the RAF_Commandlevel label
	private JLabel Luft_Commandlvl = null;			//Luft Command Level variable
	private JLabel Luft_Commandlvl_Label = null;	//declare the Luftwaffe_Command Level label
	private JLabel cardDisplay = null;				//declaration for the label to display the cards
	private JLabel RAF_TokenDisplay = null;			//declaration for RAF pieces display
	private JLabel Luft_TokenDisplay = null;		//declaration for the Luftwaffe pieces display
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
		
		this.RAF_TokenDisplay = new JLabel();
		this.RAF_TokenDisplay.setBounds(new Rectangle(10, 635, 50, 50));	
		this.RAF_TokenDisplay.setText("");
		this.RAF_TokenDisplay.setBackground(Color.black);
		this.RAF_TokenDisplay.setIcon(AA1_1);
		this.RAF_TokenDisplay.setBorder(this.loweredbevel);
		this.add(RAF_TokenDisplay);
		
		this.Luft_TokenDisplay = new JLabel();
		this.Luft_TokenDisplay.setBounds(new Rectangle(775, 635, 50, 50));	
		this.Luft_TokenDisplay.setText("");
		this.Luft_TokenDisplay.setBackground(Color.black);
		this.Luft_TokenDisplay.setIcon(AA1_1);
		this.Luft_TokenDisplay.setBorder(this.loweredbevel);
		this.add(Luft_TokenDisplay);
		
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
		
		//Add cards to vectors
		germanCardStack.add(GED01);		germanCardStack.add(GED02);		germanCardStack.add(GED03);
		germanCardStack.add(GED04);		germanCardStack.add(GED05);		germanCardStack.add(GED06);
		germanCardStack.add(GED07);		germanCardStack.add(GED08);		germanCardStack.add(GED09);
		britishCardStack.add(BED10);	britishCardStack.add(BED11);	britishCardStack.add(BED12);
		britishCardStack.add(BED13);	britishCardStack.add(BED14);	britishCardStack.add(BED15);
		britishCardStack.add(BED16);	britishCardStack.add(BED17);	britishCardStack.add(BED18);
		
		//Add tokens to vectors
		britishTokenStack.add(AA1_1);	britishTokenStack.add(AA1_2);		britishTokenStack.add(AA1_3);
		britishTokenStack.add(AA2_1);	britishTokenStack.add(AA2_2);		britishTokenStack.add(Blen);
		britishTokenStack.add(Decoy_1);	britishTokenStack.add(Decoy_2);		britishTokenStack.add(Decoy_3);
		britishTokenStack.add(Defiant);	britishTokenStack.add(HQ_10);		britishTokenStack.add(HQ_11);
		britishTokenStack.add(HQ_12);	britishTokenStack.add(Hurri_1);		britishTokenStack.add(Hurri_2);
		britishTokenStack.add(Hurri_3);	britishTokenStack.add(Spitfire_1);	britishTokenStack.add(Spitfire_2);
		germanTokenStack.add(Do17_1);	germanTokenStack.add(Do17_2);		germanTokenStack.add(He111_1);
		germanTokenStack.add(He111_2);	germanTokenStack.add(He111_3);		germanTokenStack.add(He111_4);
		germanTokenStack.add(He115);	germanTokenStack.add(Ju87_1);		germanTokenStack.add(Ju87_2);
		germanTokenStack.add(Ju88_1);	germanTokenStack.add(Ju88_2);		germanTokenStack.add(Ju88_3);
		germanTokenStack.add(Me109_1);	germanTokenStack.add(Me109_2);		germanTokenStack.add(Me109_3);
		germanTokenStack.add(Me109_4);	germanTokenStack.add(Me110_1);		germanTokenStack.add(Me110_2);
	}

	
}
