//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: ParkGUI.java
// Files: Animal.java, Button.java, JunglePark.java, Tiger.java, Deer.java, AddAnimalButton.java,
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
 * This interface defines methods to be used by other JunglePark classes to draw in the GUI and
 * check is the mouse is over something, being pressed, or released.
 * 
 * @author Mouna Kacem
 *
 */
public interface ParkGUI {
  public void draw(); // draws a ParkGUI object (either an animal or a button) to the display window

  public void mousePressed(); // called each time the mouse is Pressed

  public void mouseReleased(); // called each time the mouse is Pressed

  public boolean isMouseOver(); // checks whether the mouse is over a ParkGUI object

}
