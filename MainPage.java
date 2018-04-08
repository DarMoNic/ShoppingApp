import objectdraw.*;
import java.awt.Color;
import Acme.*;
import objectdraw.*;
import java.awt.event.*;
import javax.swing.*; //JPanel, JLabel, JButton, JSlider
import java.awt.*; //GridLayout, BorderLayout
import javax.swing.event.*; //ChangeListener, ChangeEvent


/**
 * 
 */

public class MainPage extends ActiveObject
		      implements MouseListener,
		      		 MouseMotionListener,
				 ChangeListener,
				 ActionListener{

  //line objects
  private Line horzL;
  private Line vertL;

  //factors
  private static final int DIVIDE_BY_TO_HALF = 2;

  //factor to grow by
  private static final int GROW_BY = 2;

  //starting size and half starting size
  private double START_SIZE;
  private double HALF_START_SIZE;

  //quadrant numbers
  private static final int UP_RIGHT_Q = 1;
  private static final int UP_LEFT_Q = 2;
  private static final int DOWN_LEFT_Q = 3;
  private static final int DOWN_RIGHT_Q = 4;

  //ovals involved
  private FilledOval filledOval;
  private FramedOval framedOval;

  //variable holding the quadrant the orb is in
  private int quadrant;

  //whether the program is paused or not
  private boolean isPaused;

  //JButtons
  public JButton runButton;
  private JButton pauseButton;
  private JButton clearOrbsButton;
  private JSlider slider;

  //vars to know if orbs are dragged
  private Location lastPoint;
  private boolean isGrabbed;

  //variable to store canvas
  private DrawingCanvas canvas;

  //proportion of where orbs are
  private double proporX;
  private double proporY;

  //distance from center of orb to mouse location
  private double mouseCenterDistX;
  private double mouseCenterDistY;

  //ints for center of orbs
  private double centerX;
  private double centerY;

  //var to hold the speed of the orbs growing
  public int speed;

  //padding of the screen so that orbs dont move off canvas
  private static final int PADDING = 6;
 
  //int to help with figuring out the delay time based on speed
  private static final int MAX_SPEED_PLUS_ONE = 101;

  //boolean determining if the orbs have been removed from canvas
  private boolean removed = false;


  /**
   * MainPage creates new orbs and starts the orb animation
   *
   * @param xLoc takes in the x location for the center of the orbs
   * @param yLoc takes in the y location for the center of the orbs
   * @param size takes in the size of the orbs
   * @param cvs takes in the canvas of the orbs
   * @param hLine takes in the horizontal line
   * @param vLine takes in the vertical line
   * @param runB takes in the runButton
   * @param pauseB takes in the pause button
   * @param clearB takes in the clearOrbsButton
   * @param pause takes in whether the orbs should be paused or not
   * @param slider takes in the slider 
   */
  
  public MainPage(double xLoc, double yLoc, double size, DrawingCanvas cvs,
                  Line hLine, Line vLine, JButton runB, JButton pauseB, 
		  JButton clearB, boolean pause, JSlider slider) {

    //setting param values to class variables
    START_SIZE = size;
    HALF_START_SIZE = size/DIVIDE_BY_TO_HALF;

    horzL = hLine;
    vertL = vLine;

    runButton = runB;
    pauseButton = pauseB;
    clearOrbsButton = clearB;
    this.slider = slider;

    canvas = cvs;

    centerX = xLoc;
    centerY = yLoc;

    isPaused = pause;

    //sets speed of orb to value of slider
    speed = slider.getValue();

    //update the proportions of the locations of the orbs
    proporX = centerX / canvas.getWidth();
    proporY = centerY / canvas.getHeight();


    //creates new filledOval and FramedOval
    filledOval = new FilledOval(xLoc - size/DIVIDE_BY_TO_HALF, 
      yLoc-HALF_START_SIZE, size, size, canvas);

    framedOval = new FramedOval(xLoc - size/DIVIDE_BY_TO_HALF, 
      yLoc-HALF_START_SIZE, size, size, canvas);

    
    //determins the quadrant of the orbs and sets color accordingly
    quadrant = whichQuadrant(xLoc, yLoc);
    
    if(quadrant == UP_RIGHT_Q) {

      filledOval.setColor(Color.MAGENTA);
      framedOval.setColor(Color.PINK);

    } else if(quadrant == UP_LEFT_Q) {

      filledOval.setColor(Color.CYAN);
      framedOval.setColor(Color.BLUE);

    } else if(quadrant == DOWN_LEFT_Q) {

      filledOval.setColor(Color.YELLOW);
      framedOval.setColor(Color.GREEN);

    } else {

      filledOval.setColor(Color.BLACK);
      framedOval.setColor(Color.GRAY);

    }

    //register listeners so their corresponding methods get called
    runButton.addActionListener(this);
    pauseButton.addActionListener(this);
    clearOrbsButton.addActionListener(this);
    slider.addChangeListener(this);

    canvas.addMouseListener(this);
    canvas.addMouseMotionListener(this);

    this.start();

  } //end MainPage constructor

  /**
   * whichQuadrant determins which quadrant the orb is in
   *
   * @param x takes in the x value of the orb
   * @param y takes in the y value of the orb
   *
   * @return the number of the quadrant it is in (1, 2, 3, or 4)
   */

  private int whichQuadrant(double x, double y) { 

    double vLineX = vertL.getStart().getX();
    double hLineY = horzL.getStart().getY();
  
    if(x < vLineX) {
      if(y < hLineY) 
	return UP_LEFT_Q;
      else
	return DOWN_LEFT_Q;
    } else {
      if(y < hLineY)
	return UP_RIGHT_Q;
      else
	return DOWN_RIGHT_Q;
    }

  } //end whichQuadrant()

  /**
   * changeColor changes the color of the concentric circles based on where 
   * they are in the quadrants
   */

  public void changeColor() { 

    //gets center of the filledOval
    int filledOvalX = (int)(filledOval.getX() + 
                      filledOval.getHeight() / DIVIDE_BY_TO_HALF);

    int filledOvalY = (int)(filledOval.getY() + 
                      filledOval.getHeight() / DIVIDE_BY_TO_HALF);

    
    //determins the quadrant of the orbs and sets color accordingly
    quadrant = whichQuadrant(filledOvalX, filledOvalY) ; 

    if(quadrant == UP_RIGHT_Q) {

      filledOval.setColor(Color.MAGENTA);
      framedOval.setColor(Color.PINK);

    } else if(quadrant == UP_LEFT_Q) {

      filledOval.setColor(Color.CYAN);
      framedOval.setColor(Color.BLUE);

    } else if(quadrant == DOWN_LEFT_Q) {

      filledOval.setColor(Color.YELLOW);
      framedOval.setColor(Color.GREEN);

    } else {

      filledOval.setColor(Color.BLACK);
      framedOval.setColor(Color.GRAY);

    }

  } //end changeColor()

  /**
   * move moves the orbs a given amount in each direction
   *
   * @param dx is the amount the orbs move in the x direction
   * @param dy is the amount the orbs move in the y direction
   */

  public void move(double dx, double dy) {

    filledOval.move(dx, dy);
    framedOval.move(dx, dy);

  } //end move()

  /**
   * moveTo moves the center of orbs to the given location
   *
   * @param x is the x location of where to move center of orbs to
   * @param y is the y location of where to move center of orbs to
   *
   */

  public void moveTo(double x, double y) {

    framedOval.moveTo(x - framedOval.getWidth() / DIVIDE_BY_TO_HALF ,
    		      y - framedOval.getHeight() / DIVIDE_BY_TO_HALF );
    filledOval.moveTo(x - filledOval.getWidth() / DIVIDE_BY_TO_HALF ,
    		      y - filledOval.getHeight() / DIVIDE_BY_TO_HALF );

  }

  /** 
   * reposition will reposition the center of the orbs to maintain
   * proportionality
   */

  public void reposition() {
    
    centerX = canvas.getWidth()*proporX;
    centerY = canvas.getHeight()*proporY;
  }

  /**
   * contains determines whether a point is contained inside either
   * of the orbs
   *
   * @param pt the point that we're determing whether it's inside orbs or not
   *
   * @return whether pt is inside one of the orbs
   */

  public boolean contains(Location pt) {

    return filledOval.contains(pt) || framedOval.contains(pt);

  }

  /**
   * run grows and shrinks the orb depending on its current size
   */

  public void run() {

    while(true && !removed) {
      
      //grows filledOrb and shrinks framedOrb
      while(filledOval.getHeight() < START_SIZE + HALF_START_SIZE) { 

	//only does animation if the orb isn't paused
        if(!isPaused) {

	  //increases the width and height of filledOval by grow
	  filledOval.setWidth(filledOval.getWidth() + GROW_BY);
	  filledOval.setHeight(filledOval.getHeight() + GROW_BY);

	  //decreases the width and height of framedOval by grow
	  framedOval.setWidth(framedOval.getWidth() - GROW_BY);
	  framedOval.setHeight(framedOval.getHeight() - GROW_BY);

	  //reposition the center of the orb to stay proportional
	  this.reposition();
	  this.moveTo(centerX, centerY);

	}
       
        //changes the color of the orbs if they change quadrants
	changeColor();
   
	//needed to create animation so it doesnt change too quickly
	this.pause(getPauseTime());

       	//reposition the center of the orb to stay proportional
	this.reposition();
	this.moveTo(centerX, centerY);

      } //end while loop

      //shrinks filledOrb and grows framedOrb
      while(filledOval.getHeight() >= START_SIZE - HALF_START_SIZE) {
 
	//only does animation if the orb isn't paused
        if(!isPaused) {

	  //decreases the width and height of filledOval by grow
	  filledOval.setWidth(filledOval.getWidth() - GROW_BY);
	  filledOval.setHeight(filledOval.getHeight() - GROW_BY);

	  //increases the width and height of framedOval by grow
	  framedOval.setWidth(framedOval.getWidth() + GROW_BY);
	  framedOval.setHeight(framedOval.getHeight() + GROW_BY);

	  //reposition the center of the orb to stay proportional
	  this.reposition();
	  this.moveTo(centerX, centerY);

        }

	//changes the color of the orbs if they move quadrants
	changeColor();
	
	//needed to create animation so it doesnt change too quickly
	this.pause(getPauseTime());

        //reposition the center of the orb to stay proportional
        this.reposition();
	this.moveTo(centerX, centerY);
      
      } //end while loop

    } //end forever loop

  } //end run()

  /**
   * getPauseTime determines the pause time of the orbs based on the speed from
   * slider
   *
   */

  private int getPauseTime() {

    return MAX_SPEED_PLUS_ONE - speed;
  }

  /**
   * mousePressed determines if mouse is in orbs and keep track of this point
   *
   * @param evt takes in the x and y coordinate of the mouse
   */

  public void mousePressed(MouseEvent evt) { 
    
    Location point = new Location( evt.getPoint() );
    isGrabbed = this.contains( point );
    this.lastPoint = point;

    //update distance from center of orbs to mouse location
    mouseCenterDistX = centerX - evt.getX();
    mouseCenterDistY = centerY - evt.getY();

  }

  /**
   * actionPerformed is called when the run button is clicked, and pauses / 
   * unpauses / clears the orbs according to the button that is pressed
   *
   * @param evt takes in a button action event
   */

  public void actionPerformed(ActionEvent evt) {

    //makes sure the ovals exists before removing them or changing isPaused
      
    if(evt.getSource() == pauseButton) {

      isPaused = true;
    
    } else if(evt.getSource() == runButton) {
    
      isPaused = false;
    
    } else if(evt.getSource() == clearOrbsButton) {
     
      //tells run() that the orbs have been removed
      removed = true;

      framedOval.removeFromCanvas();
      filledOval.removeFromCanvas();

      //dereferences the orbs from the buttons
      ((JButton)evt.getSource()).removeActionListener(this); 
      ((JDrawingCanvas)this.canvas).removeMouseListener(this);
      ((JDrawingCanvas)this.canvas).removeMouseMotionListener(this);
      
    }

  } //end actionPerformed()

  /** 
   * mouseDragged will move the orbs around if the mouse point is contained 
   * within the orbs
   *
   * @param evt takes in the x and y coordinate of the mouse
   */

  public void mouseDragged(MouseEvent evt) { 
    
    //boolean to figure out where mouseX with relation to center of orbs
    //is within border of screen
    boolean centerXInside = 
      evt.getX() < (canvas.getWidth() - PADDING - mouseCenterDistX) 
      && evt.getX() > PADDING - mouseCenterDistX;

    boolean centerYInside = 
      evt.getY() < (canvas.getHeight() - PADDING - mouseCenterDistY)
      && evt.getY() > PADDING - mouseCenterDistY;
    			    
    if(this.isGrabbed && centerXInside && centerYInside) {

      Location point = new Location( evt.getPoint() );
      this.move( point.getX() - this.lastPoint.getX(),
      		 point.getY() - this.lastPoint.getY()) ;
      
      //update center location
      centerX += point.getX() - this.lastPoint.getX();
      centerY += point.getY() - this.lastPoint.getY();

      this.lastPoint = point;
      
      //update the proportions of the locations of the orbs
      proporX = centerX / canvas.getWidth();
      proporY = centerY / canvas.getHeight();

    } //end if statement
    
  } //end mouseDragged()

  /**
   * stateChanged changes the speed to the value of the slider
   *
   * @param evt takes in the event that is changed
   */

  public void stateChanged(ChangeEvent evt) {

    speed = slider.getValue();
    
  } //end stateChanged()

  /**
   * mouseClicked is called when the mouse is clicked
   *
   * @param evt takes in the x and y coordinate of the mouse
   */

  public void mouseClicked(MouseEvent evt) { }

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

    
} //end MainPage class
