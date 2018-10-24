//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: ClearButton.java
// Files: Animal.java, Button.java, JunglePark.java, ParkGUI.java, Tiger.java, Deer.java,
//////////////////// AddAnimalButton.java, JungleParkTests.java, background.png, deer.png,
//////////////////// tiger.png,
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
 * This class allows the user to add a button that when pressed clears the animals out of the park.
 * This class extends Button.java
 *
 */
public class ClearButton extends Button {
  /**
   * This constructor calls Button constructor with inputs x, y, and park
   */
  public ClearButton(float x, float y, JunglePark park) {
    // call Button.java constructor with inputs x, y, and park
    super(x, y, park);
    // set object label to "clear park"
    this.label = "Clear Park";
  }

  /**
   * When the button is pressed, every Animal in the GUI gets removed
   * 
   * @see ParkGUI.java mousePressed()
   */
  @Override
  public void mousePressed() {
    // iterate through GUI array
    for (int i = 0; i < this.processing.listGUI.size(); i++) {
      // if element in GUI array is an animal
      if (this.processing.listGUI.get(i) instanceof Animal) {
        // remove this animal from the GUI array
        this.processing.listGUI.remove(i);
        // decrement i to not skip over any elements
        i = i - 1;
      }
    }
  }


}
