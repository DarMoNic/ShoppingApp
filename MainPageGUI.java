/*
 * Name: Darya Verzhbinsky
 * Login: cs11famn
 * Date: November 7, 2017 
 * File: MainPageGUI.java
 * Sources of Help: PA4, Java documentation, PIAZZA was extremely helpful,
 * 		    James Guidry (tutor)
 *
 * This program sets up the MainPage GUI that handles mouse events, draws 
 * lines, moves lines, and contains buttons that fire different action events
 * to occur and change the state of the orbs 
 */

import Acme.*;
import objectdraw.*;
import java.awt.event.*;
import javax.swing.*; //JPanel, JLabel, JButton, JSlider
import java.awt.*; //GridLayout, BorderLayout
import javax.swing.event.*; //ChangeListener, ChangeEvent

/**
 * MainPageGUI sets up variables used in the program, begins the program, and 
 * contains the mouse handler events necessary to run the program
 */

public class MainPageGUI extends WindowController
			 implements MouseListener,
			 	    MouseMotionListener,
				    ChangeListener,
				    ActionListener{

  //canvas dimensions
  private static final int CANVAS_WIDTH = 600;
  private static final int CANVAS_HEIGHT = 600;
  private static final int HALF_CANV_WID = CANVAS_WIDTH / 2;
  private static final int HALF_CANV_HEI = CANVAS_HEIGHT / 2;

  //screen padding for the borders
  private static final int SCREEN_PADDING = 6;
  
  // //line objects
  // private Line vertL; 
  // private Line horzL; 

  // //if lines have been pressed boolean
  // private boolean horzIsPressed = false;
  // private boolean vertIsPressed = false;

  // //point where mouse was last seen
  // private Location lastPoint;

  // //orb size
  // private static final int ORB_SIZE = 60;

  // //proportion of where lines are
  // private double proporHorz = 0.5;
  // private double proporVert = 0.5;

  // //JButtons
  // public JButton runButton;
  // private JButton pauseButton;
  // private JButton clearOrbsButton;

  // //JSlider
  // private JSlider slider;
  // private JLabel sliderLabel;

  // //label strings
  // private static final String HEADER = "Crazy Orb Controls";
  // private static final String RUN = "Run";
  // private static final String PAUSE = "Pause";
  // private static final String CLEAR_ORBS = "Clear Orbs";
  // private static final String SLIDER_LABEL = "The speed is ";
  // private static final String SLIDER_PAUSE_LABEL = "The speed is paused ";

  // //buttoncontrolPanel col and row nums
  // private static final int NUM_COLS = 1;
  // private static final int NUM_ROWS = 2;

  // //number for the speed of the orbs
  // private static final int MIN_SPEED = 1;
  // private static final int MAX_SPEED = 100;
  // private static final int DEFAULT_SPEED = 50;

  // //if the orbs should be paused or not
  // private boolean paused = false;

  /**
   * begin lets the lines appear when program starts, adds all the panels and
   * buttons to the screen, and binds the buttons and slider to the canvas
   */

  public void begin() {

    // //panel where buttons will go
    // JPanel buttonControlPanel = new JPanel();
    // buttonControlPanel.setLayout(new GridLayout(NUM_ROWS, NUM_COLS));

    // //adds Crazy Orb Controls label in the center at the top 
    // JPanel labelPanel = new JPanel();
    // JLabel header = new JLabel(HEADER);
    // labelPanel.add(header, SwingConstants.CENTER);

    // //creates panel for buttons, and adds each button
    // JPanel buttonPanel = new JPanel();

    // runButton = new JButton(RUN);
    // pauseButton = new JButton(PAUSE);
    // clearOrbsButton = new JButton(CLEAR_ORBS);

    // buttonPanel.add(runButton);
    // buttonPanel.add(pauseButton);
    // buttonPanel.add(clearOrbsButton);

    // //adds the label panel and the button panel to north area
    // buttonControlPanel.add(labelPanel);
    // buttonControlPanel.add(buttonPanel);
    // this.add(buttonControlPanel, BorderLayout.NORTH);

    // //creates slider control panel and new Jslider
    // JPanel sliderControlPanel = new JPanel();
    // slider = new JSlider(JSlider.HORIZONTAL, MIN_SPEED, MAX_SPEED, 
    //     	         DEFAULT_SPEED);
    // sliderLabel = new JLabel(SLIDER_LABEL + slider.getValue());

    // //adds slider label and slider to control panel
    // sliderControlPanel.add(sliderLabel);
    // sliderControlPanel.add(slider);
    // this.add(sliderControlPanel, BorderLayout.SOUTH);
    
    // //VALIDATE!!! to make everything work
    // this.validate();

    // //sets up the coordinates of the lines
    // int beginX = (int)(canvas.getWidth() * proporVert);
    // int beginY = (int)(canvas.getHeight() * proporHorz);

    // //creates and shows the lines
    // vertL = new Line(beginX, 0, beginX, canvas.getHeight(), canvas);
    // horzL = new Line(0, beginY, canvas.getWidth(), beginY, canvas);

    // vertL.show();
    // horzL.show();

    //binds the EH as listener for mouse and mouse motion events
    this.canvas.addMouseListener(this);
    this.canvas.addMouseMotionListener(this);

    // //register listeners so their corresponding methods get called
    // slider.addChangeListener(this);

    // runButton.addActionListener(this);
    // pauseButton.addActionListener(this);
    // clearOrbsButton.addActionListener(this);
    
  } //end begin()

  /**
   * main creates the Acme.mainframe to have program run
   *
   * @param args takes in the cmd line args from the terminal
   */

  public static void main(String[] args) {

    new Acme.MainFrame(new MainPageGUI(), args, CANVAS_WIDTH, CANVAS_HEIGHT);
    
  } // end main()

  /**
   * stateChanged sets slider label to the updated value of the slider and 
   * changes the speed of the orbs
   *
   * @param evt takes in the event that is changed
   */

  public void stateChanged(ChangeEvent evt) {

    // if(paused) {
    //   sliderLabel.setText(SLIDER_PAUSE_LABEL + "(" + slider.getValue() + ")");
    // } else {
    //   sliderLabel.setText(SLIDER_LABEL + slider.getValue() );
    // }
    
  } //end stateChanged()

  /**
   * mousePressed determines if the lines have been pressed
   *
   * @param evt takes in the x and y coordinate of the mouse
   */

  public void mousePressed(MouseEvent evt) {

    // Location point = new Location(evt.getPoint());

    // //determines if the vertical line is pressed    
    // vertIsPressed = vertL.contains(point);

    // //determines if the horizontal line is pressed
    // horzIsPressed = horzL.contains(point);
    
    // lastPoint = point;

  } //end mousePressed

  /**
   * mouseClicked creates a new orb centered around the mouse location
   *
   * @param evt takes in the x and y coordinate of the mouse
   */

  public void mouseClicked(MouseEvent evt) {

    Button button = new Button(evt.getX(), evt.getY(), "blah", canvas);

    // MainPage mainPage = new MainPage(evt.getX(), evt.getY(), ORB_SIZE, canvas, 
    //  				     horzL, vertL,runButton, pauseButton, 
				//      clearOrbsButton, paused, slider );

  } //end mouseClicked
  
  /** 
   * mouseDragged will move the lines around with the mouse if the mouse
   * is inside the lines
   *
   * @param evt takes in the x and y coordinate of the mouse
   */

  public void mouseDragged(MouseEvent evt) {

    // //boolean representing if the mouseX is within border of screen
    // boolean vertP = evt.getX() < (canvas.getWidth() - SCREEN_PADDING) &&
    //                 evt.getX() > SCREEN_PADDING;

    // //boolean representing if the mouseY is within border of screen
    // boolean horzP = evt.getY() < canvas.getHeight() - SCREEN_PADDING &&
    //                 evt.getY() > SCREEN_PADDING;

    // if(horzIsPressed && vertIsPressed && horzP && vertP) {
      
    //   //move the lines
    //   vertL.move(evt.getX() - lastPoint.getX(), 0);
    //   horzL.move(0, evt.getY() - lastPoint.getY() );
     
    //   lastPoint = new Location(evt.getPoint());

    // }

    // //is vertical line is pressed, move the line horizontally only
    // if(vertIsPressed && vertP) {
      
    //   //move the line
    //   vertL.move(evt.getX() - lastPoint.getX(), 0);
     
    //   lastPoint = new Location(evt.getPoint());
    // }

    // //if horizontal line is pressed, move the line vertically only
    // if(horzIsPressed && horzP) {
            
    //   //move the line
    //   horzL.move(0, evt.getY() - lastPoint.getY() );

    //   lastPoint = new Location(evt.getPoint());
    // }

    // //update the proportions of the locations of the lines
    // proporHorz = (double)(horzL.getEnd().getY()) / canvas.getHeight();
    // proporVert = (double)(vertL.getEnd().getX()) / canvas.getWidth();

  } //end mouseDragged()

  /**
   * paint is called when the size of the screen is changed and updates the 
   * location of the points to make the lines proportional
   *
   * @param g contains different state information needed for the basic
   * rendering operations that Java supports 
   * (descr. copied from: https://docs.oracle.com/javase/7/docs/api/java/awt/
   * Graphics.html)
   */

  public void paint(java.awt.Graphics g) {
    
    //calls the superclass's version of method
    super.paint(g);

    // //checks if the lines already exist
    // if(vertL != null && horzL != null) {

    //   //calculates the change in each direction
    //   int changeY = (int)(canvas.getHeight()*proporHorz 
		  //   - horzL.getEnd().getY());

    //   int changeX = (int)(canvas.getWidth()*proporVert 
		  //   - vertL.getEnd().getX());

    //   //creates new endpoints for the lines
    //   int newX = (int)(vertL.getEnd().getX() + changeX);
    //   int newY = (int)(horzL.getEnd().getY() + changeY);
      
    //   //sets the location of line to updated locations
    //   vertL.setEndPoints(newX, 0, newX, canvas.getHeight());
    //   horzL.setEndPoints(0, newY, canvas.getWidth(), newY);
    // }

  } //end paint()

  /**
   * actionPerformed is called when the buttons are pressed
   * does appropriate things to orbs based on which orb is pressed
   * 
   * @param evt takes in a mouse event
   */

  public void actionPerformed(ActionEvent evt) {

    // if(evt.getSource() == runButton) {
    //   paused = false;
    // } else if(evt.getSource() == pauseButton) {
    //   paused = true;
    // }

    // //change label of slider based on if orbs are paused or not
    // if(paused) {
    //   sliderLabel.setText(SLIDER_PAUSE_LABEL + "(" + slider.getValue() + ")");
    // } else {
    //   sliderLabel.setText(SLIDER_LABEL + slider.getValue() );
    // }

  } // end actionPerformed()

  /**
   * mouseEntered is called when the mouse enters the screen
   *
   * @param evt takes in a mouse event
   */
  
  public void mouseEntered(MouseEvent evt) { } 

  /**
   * mouseExited is called when the mouse exits the screen
   *
   * @param evt takes in a mouse event
   */

  public void mouseExited(MouseEvent evt) { } 

  /**
   * mouseReleased is called when the mouse is released on the screen
   *
   * @param evt takes in a mouse event
   */

  public void mouseReleased(MouseEvent evt) { } 

  /**
   * mouseMoved is called when the mouse moves on the screen the screen
   *
   * @param evt takes in a mouse event
   */

  public void mouseMoved(MouseEvent evt) { }

} // end MainPageGUI class
