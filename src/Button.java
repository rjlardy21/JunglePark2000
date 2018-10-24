//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: Button.java
// Files: Animal.java, JunglePark.java, ParkGUI.java, Tiger.java, Deer.java, AddAnimalButton.java,
//////////////////// ClearButton.java, JungleParkTests.java, background.png, deer.png, tiger.png,
//////////////////// processingLibrary.jar
// Course: CS300 Fall 2018
//
// Author: Reece Lardy
// Email: RLardy@wisc.edu
// Lecturer's Name: Alexander Brooks
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Students who get help from sources other than their partner must fully
// acknowledge and credit those sources of help here. Instructors and TAs do
// not need to be credited here, but tutors, friends, relatives, room mates,
// strangers, and others do. If you received no outside help from either type
// of source, then please explicitly indicate NONE.
//
// Persons: (identify each person and describe their help in detail)
// Online Sources: (identify each URL and describe their assistance in detail)
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////
/**
 * This class is a super class for any Button that can be added to a PApplet application It
 * implements the interface ParkGUI
 * 
 * @author Mouna Kacem
 */

public class Button implements ParkGUI {
  private static final int WIDTH = 85; // Width of the Button
  private static final int HEIGHT = 32; // Height of the Button
  protected JunglePark processing; // PApplet object where the button will be displayed
  private float[] position; // array storing x and y positions of the Button with respect to
                            // the display window
  protected String label; // text/label that represents the button

  /**
   * Constructor for a new button object
   * 
   * @param x represents the x position of the button
   * @param y represents the y position of the button
   * @param processing represents the current jungle park object
   */
  public Button(float x, float y, JunglePark processing) {
    this.processing = processing; // sets object processing to input processing
    this.position = new float[2]; // create new position array for button
    this.position[0] = x; // set input x position to x position in array
    this.position[1] = y; // set input y position to y position in array
    this.label = "Button"; // set label to Button
  }

  /**
   * Draws the button in the parkGUI
   * 
   * @see draw() in ParkGUI
   */
  @Override
  public void draw() {
    this.processing.stroke(0);// set line value to black
    if (isMouseOver())
      processing.fill(100); // set the fill color to dark gray if the mouse is over the button
    else
      processing.fill(200); // set the fill color to light gray otherwise

    // draw the button (rectangle with a centered text)
    processing.rect(position[0] - WIDTH / 2.0f, position[1] - HEIGHT / 2.0f,
        position[0] + WIDTH / 2.0f, position[1] + HEIGHT / 2.0f);
    processing.fill(0); // set the fill color to black
    processing.text(label, position[0], position[1]); // display the text of the current button
  }

  /**
   * Prints to console if user presses their mouse over a button
   * 
   * @see mousePressed() in ParkGUI
   */
  @Override
  public void mousePressed() {
    if (isMouseOver()) // if mouse is over the button
      System.out.println("A button was pressed."); // prints feedback
  }

  /**
   * Method unused by program but must be implemented because it is part of the interface
   * 
   * @see mouseReleased() in ParkGUI
   */
  @Override
  public void mouseReleased() {}

  /**
   * Checks whether the mouse is over a ParkGUI object
   * 
   * @see isMouseOver() in ParkGUI
   */
  @Override
  public boolean isMouseOver() {
    // if the mouse is within the area of the display window where the button is
    if (this.processing.mouseX > this.position[0] - WIDTH / 2
        && this.processing.mouseX < this.position[0] + WIDTH / 2
        && this.processing.mouseY > this.position[1] - HEIGHT / 2
        && this.processing.mouseY < this.position[1] + HEIGHT / 2)
      return true;
    // returns true if yes
    return false;
    // otherwise returns false
  }
}
