/* 
 * Name: Darya Verzhbinsky
 * Login: cs11famn
 * Date: November 7, 2017
 * File: CrazyOrb.java
 * Sources of Help: PA4, Java documentation, PIAZZA was extremely helpful,
 *        James Guidry (tutor)
 *
 * This program creates the CrazyOrb class that will create orbs that grow 
 * and shrink based on whether they are paused or not. they can also be 
 * dragged around and deleted from canvas
 */

import objectdraw.*;
import java.awt.Color;
import Acme.*;
import objectdraw.*;
import java.awt.event.*;
import javax.swing.*; //JPanel, JLabel, JButton, JSlider
import java.awt.*; //GridLayout, BorderLayout
import javax.swing.event.*; //ChangeListener, ChangeEvent


/**
 * CrazyOrb sets up all the methods and variables for the orbs, creates the 
 * orbs, and contains the run() method that starts the animation of the orbs
 * it also handles mouse events and button events
 */

public class Button extends ActiveObject
          implements MouseListener,
               MouseMotionListener,
         ChangeListener,
         ActionListener{

  //location of top left corner of button
  private int myX, myY;

  //color of button
  private int myColor;

  //to keep track of the type of button
  private String myType;

  //actual button
  private FilledRect button;

  //variable to store canvas
  private DrawingCanvas canvas;

  /**
   * 
   */
  
  public Button(int x, int y, String type, DrawingCanvas cvs) {

    //setting param values to class variables
    this.myX = x;
    this.myY = y;
    this.myType = type;

    this.canvas = cvs;

    //sets up the button
    if(myType.equals("blah")) {
      button = new FilledRect(myX, myY, 100,100, this.canvas);
    } else {
      button = new FilledRect(myX, myY, 100,100, this.canvas);

    }
    
    //start animation
    this.start();

  } //end Button constructor


  /**
   * changeColor changes the color of the concentric circles based on where 
   * they are in the quadrants
   */

  public void changeColor() { 
    
    if(this.mouseIsInside()) {
      button.setColor(Color.RED);
    } else {
      button.setColor(Color.BLUE);
    }

  } //end changeColor()

  /**
   * mouseIsInside
   */

  public boolean mouseIsInside() {
    Location mouseLocation = new Location(MouseInfo.getPointerInfo().getLocation());

    return button.contains(mouseLocation);

  }

  /**
   * run
   */

  public void run() {

    while(true) {

      this.changeColor();

    } //end forever loop

  } //end run()

  /**
   * mousePressed determines if mouse is in orbs and keep track of this point
   *
   * @param evt takes in the x and y coordinate of the mouse
   */

  public void mousePressed(MouseEvent evt) { 
    
    Location point = new Location( evt.getPoint() );
    


    // isGrabbed = this.contains( point );
    // this.lastPoint = point;

    // //update distance from center of orbs to mouse location
    // mouseCenterDistX = centerX - evt.getX();
    // mouseCenterDistY = centerY - evt.getY();

  }

  /**
   * actionPerformed is called when the run button is clicked, and pauses / 
   * unpauses / clears the orbs according to the button that is pressed
   *
   * @param evt takes in a button action event
   */

  public void actionPerformed(ActionEvent evt) {

    //makes sure the ovals exists before removing them or changing isPaused
      
    // if(evt.getSource() == pauseButton) {

    //   isPaused = true;
    
    // } else if(evt.getSource() == runButton) {
    
    //   isPaused = false;
    
    // } else if(evt.getSource() == clearOrbsButton) {
     
    //   //tells run() that the orbs have been removed
    //   removed = true;

    //   framedOval.removeFromCanvas();
    //   filledOval.removeFromCanvas();

    //   //dereferences the orbs from the buttons
    //   ((JButton)evt.getSource()).removeActionListener(this); 
    //   ((JDrawingCanvas)this.canvas).removeMouseListener(this);
    //   ((JDrawingCanvas)this.canvas).removeMouseMotionListener(this);
      
    // }

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
    // boolean centerXInside = 
    //   evt.getX() < (canvas.getWidth() - PADDING - mouseCenterDistX) 
    //   && evt.getX() > PADDING - mouseCenterDistX;

    // boolean centerYInside = 
    //   evt.getY() < (canvas.getHeight() - PADDING - mouseCenterDistY)
    //   && evt.getY() > PADDING - mouseCenterDistY;
              
    // if(this.isGrabbed && centerXInside && centerYInside) {

    //   Location point = new Location( evt.getPoint() );
    //   this.move( point.getX() - this.lastPoint.getX(),
    //        point.getY() - this.lastPoint.getY()) ;
      
    //   //update center location
    //   centerX += point.getX() - this.lastPoint.getX();
    //   centerY += point.getY() - this.lastPoint.getY();

    //   this.lastPoint = point;
      
    //   //update the proportions of the locations of the orbs
    //   proporX = centerX / canvas.getWidth();
    //   proporY = centerY / canvas.getHeight();

    // } //end if statement
    
  } //end mouseDragged()

  /**
   * stateChanged changes the speed to the value of the slider
   *
   * @param evt takes in the event that is changed
   */

  public void stateChanged(ChangeEvent evt) {

    //speed = slider.getValue();
    
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

    
} //end CrazyOrb class




















// public class Buttons {

//   //location of top left corner of button
//   private int myX, myY;

//   //color of button
//   private int myColor;

//   //to keep track of the type of button
//   private String myType;

//   //actual button
//   private FilledRect button;

//   //variable to store canvas
//   private DrawingCanvas canvas;

//   /**
//    * 
//    */

//   public void show() {
//     this.button = new FramedRect(this.myX, this.myY, 100, 100,);
//   }

//   /**
//    * main creates the Acme.mainframe to have program run
//    *
//    * @param args takes in the cmd line args from the terminal
//    */

//   public static void main(String[] args) {

//     new Acme.MainFrame(new MainPageGUI(), args, CANVAS_WIDTH, CANVAS_HEIGHT);
    
//   } // end main()

//   /**
//    * stateChanged sets slider label to the updated value of the slider and 
//    * changes the speed of the orbs
//    *
//    * @param evt takes in the event that is changed
//    */

//   public void stateChanged(ChangeEvent evt) {

//     if(paused) {
//       sliderLabel.setText(SLIDER_PAUSE_LABEL + "(" + slider.getValue() + ")");
//     } else {
//       sliderLabel.setText(SLIDER_LABEL + slider.getValue() );
//     }
    
//   } //end stateChanged()

//   /**
//    * mousePressed determines if the lines have been pressed
//    *
//    * @param evt takes in the x and y coordinate of the mouse
//    */

//   public void mousePressed(MouseEvent evt) {

//     Location point = new Location(evt.getPoint());

//     //determines if the vertical line is pressed    
//     vertIsPressed = vertL.contains(point);

//     //determines if the horizontal line is pressed
//     horzIsPressed = horzL.contains(point);
    
//     lastPoint = point;

//   } //end mousePressed

//   /**
//    * mouseClicked creates a new orb centered around the mouse location
//    *
//    * @param evt takes in the x and y coordinate of the mouse
//    */

//   public void mouseClicked(MouseEvent evt) {

//     MainPage mainPage = new MainPage(evt.getX(), evt.getY(), ORB_SIZE, canvas, 
//      				     horzL, vertL,runButton, pauseButton, 
// 				     clearOrbsButton, paused, slider );

//   } //end mouseClicked
  
//   /** 
//    * mouseDragged will move the lines around with the mouse if the mouse
//    * is inside the lines
//    *
//    * @param evt takes in the x and y coordinate of the mouse
//    */

//   public void mouseDragged(MouseEvent evt) {

//     //boolean representing if the mouseX is within border of screen
//     boolean vertP = evt.getX() < (canvas.getWidth() - SCREEN_PADDING) &&
//                     evt.getX() > SCREEN_PADDING;

//     //boolean representing if the mouseY is within border of screen
//     boolean horzP = evt.getY() < canvas.getHeight() - SCREEN_PADDING &&
//                     evt.getY() > SCREEN_PADDING;

//     if(horzIsPressed && vertIsPressed && horzP && vertP) {
      
//       //move the lines
//       vertL.move(evt.getX() - lastPoint.getX(), 0);
//       horzL.move(0, evt.getY() - lastPoint.getY() );
     
//       lastPoint = new Location(evt.getPoint());

//     }

//     //is vertical line is pressed, move the line horizontally only
//     if(vertIsPressed && vertP) {
      
//       //move the line
//       vertL.move(evt.getX() - lastPoint.getX(), 0);
     
//       lastPoint = new Location(evt.getPoint());
//     }

//     //if horizontal line is pressed, move the line vertically only
//     if(horzIsPressed && horzP) {
            
//       //move the line
//       horzL.move(0, evt.getY() - lastPoint.getY() );

//       lastPoint = new Location(evt.getPoint());
//     }

//     //update the proportions of the locations of the lines
//     proporHorz = (double)(horzL.getEnd().getY()) / canvas.getHeight();
//     proporVert = (double)(vertL.getEnd().getX()) / canvas.getWidth();

//   } //end mouseDragged()

//   /**
//    * paint is called when the size of the screen is changed and updates the 
//    * location of the points to make the lines proportional
//    *
//    * @param g contains different state information needed for the basic
//    * rendering operations that Java supports 
//    * (descr. copied from: https://docs.oracle.com/javase/7/docs/api/java/awt/
//    * Graphics.html)
//    */

//   public void paint(java.awt.Graphics g) {
    
//     //calls the superclass's version of method
//     super.paint(g);

//     //checks if the lines already exist
//     if(vertL != null && horzL != null) {

//       //calculates the change in each direction
//       int changeY = (int)(canvas.getHeight()*proporHorz 
// 		    - horzL.getEnd().getY());

//       int changeX = (int)(canvas.getWidth()*proporVert 
// 		    - vertL.getEnd().getX());

//       //creates new endpoints for the lines
//       int newX = (int)(vertL.getEnd().getX() + changeX);
//       int newY = (int)(horzL.getEnd().getY() + changeY);
      
//       //sets the location of line to updated locations
//       vertL.setEndPoints(newX, 0, newX, canvas.getHeight());
//       horzL.setEndPoints(0, newY, canvas.getWidth(), newY);
//     }

//   } //end paint()

//   /**
//    * actionPerformed is called when the buttons are pressed
//    * does appropriate things to orbs based on which orb is pressed
//    * 
//    * @param evt takes in a mouse event
//    */

//   public void actionPerformed(ActionEvent evt) {

//     if(evt.getSource() == runButton) {
//       paused = false;
//     } else if(evt.getSource() == pauseButton) {
//       paused = true;
//     }

//     //change label of slider based on if orbs are paused or not
//     if(paused) {
//       sliderLabel.setText(SLIDER_PAUSE_LABEL + "(" + slider.getValue() + ")");
//     } else {
//       sliderLabel.setText(SLIDER_LABEL + slider.getValue() );
//     }

//   } // end actionPerformed()

//   /**
//    * mouseEntered is called when the mouse enters the screen
//    *
//    * @param evt takes in a mouse event
//    */
  
//   public void mouseEntered(MouseEvent evt) { } 

//   /**
//    * mouseExited is called when the mouse exits the screen
//    *
//    * @param evt takes in a mouse event
//    */

//   public void mouseExited(MouseEvent evt) { } 

//   /**
//    * mouseReleased is called when the mouse is released on the screen
//    *
//    * @param evt takes in a mouse event
//    */

//   public void mouseReleased(MouseEvent evt) { } 

//   /**
//    * mouseMoved is called when the mouse moves on the screen the screen
//    *
//    * @param evt takes in a mouse event
//    */

//   public void mouseMoved(MouseEvent evt) { }

// } // end MainPageGUI class
