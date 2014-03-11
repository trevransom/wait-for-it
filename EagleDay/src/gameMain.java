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
//****************************************************************************************************************
//
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
			}
		});
		
	}
	
	private ImageIcon backgroundMapImage = new ImageIcon ("files/EagleDayMapFinal.png"); //loads map image
	
	// Declaration of variables
	private int day = 1;				//what day it currently is
	private int hour = 1;				//what hour of the day it is
	private int RAF_Commandlvl = 0; 	//RAF command level
	private int Luft_Commandlvl = 0;	//Luftwaffe command level
	private boolean phase = false; 		//FALSE = Planning phase / TRUE = Operations phase
	
	//GUI panels and components
	private Border blackline = BorderFactory.createLineBorder(Color.black);		//declaration of the blackline border
	private JButton play = null;			//declare play button
	private JButton newGame = null;			//declare newGame button
	private JPanel ControlPanel = null;		//declare the main control panel
	private JLabel background = null;				//declare the map label
	private JLabel dayLabel = null;					//declare the day label
	private JLabel hourLabel = null;				//declare the hour label
	private JLabel RAF_Commandlvl_Label = null;		//declare the RAF_Commandlevel label
	private JLabel Luft_Commandlvl_Label = null;	//declare the Luftwaffe_Command Level label
	
	
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
			this.newGame.setBounds(new Rectangle(1115, 5, 90, 25));	
			this.newGame.grabFocus();
			this.newGame.setText("New Game");
			//this.NewGame.addActionListener(new java.awt.event.ActionListener() {
				//public void actionPerformed(java.awt.event.ActionEvent e) {
					//ADD NEWGAME BUTTON CODE HERE (UNCOMMENT ABOVE 2 LINES WHEN IMPLEMENTING)
		}
		
		return this.newGame;
	}
	
	//Implements the play JButton
	private JButton getPlay() {
		if (this.play == null) {
			if (this.play == null) {
				this.play = new JButton();
				this.play.setBounds(new Rectangle(1203, 5, 75, 25));
				this.play.setText("Play");
				//this.play.addActionListener(new java.awt.event.ActionListener() {
					//public void actionPerformed(java.awt.event.ActionEvent e) {
						//ADD PLAY BUTTON CODE HERE (UNCOMMENT ABOVE 2 LINES WHEN IMPLEMENTING)
			}
		}
		return this.play;
	}

	private void initialize() {
		this.setSize(1280, 720);				//sets size-resolution for main window
		this.setTitle("Air Wars: Eagle Day");	//sets  title for main window
		this.setLocationRelativeTo(null);
		
		// Initializing GUI panels and components
		this.ControlPanel = new JPanel();
		this.ControlPanel.setLayout(new GridBagLayout());
		this.dayLabel = new JLabel();												//initializes the day label
		this.dayLabel.setBounds(new Rectangle(475, 590, 28, 20));
		this.dayLabel.setText("Day");
		this.dayLabel.setBorder(this.blackline);
		this.add(dayLabel);															//add dayLabel label to GUI
		this.hourLabel = new JLabel();												//initializes the hour label
		this.hourLabel.setBounds(new Rectangle(525, 590, 35, 20));
		this.hourLabel.setText("Hour");
		this.hourLabel.setBorder(this.blackline);
		this.add(hourLabel);														//add hourLabel label to GUI
		this.RAF_Commandlvl_Label = new JLabel();									//initializes the RAF command level label
		this.RAF_Commandlvl_Label.setBounds(new Rectangle(810, 590, 130, 20));
		this.RAF_Commandlvl_Label.setText("RAF Command Level");
		this.RAF_Commandlvl_Label.setBorder(this.blackline);
		this.add(RAF_Commandlvl_Label);												//add RAF_Commandlvl_Label label to GUI
		this.Luft_Commandlvl_Label = new JLabel();									//initializes the Luftwaffe command level label
		this.Luft_Commandlvl_Label.setBounds(new Rectangle(10, 590, 177, 20));
		this.Luft_Commandlvl_Label.setText("Luftwaffe Commmand Level");
		this.Luft_Commandlvl_Label.setBorder(this.blackline);
		this.add(Luft_Commandlvl_Label);											//add Luft_Commandlvl_Label label to GUI
		this.add(getNewGame(), null);												//add newGame button to GUI
		this.add(getPlay(), null);													//add play button to GUI
		
		
		//setLayout(new BorderLayout()); 
		JLabel background = new JLabel(backgroundMapImage);							//puts map image in window
		add(background);															//add image to GUI
	}
	
}
