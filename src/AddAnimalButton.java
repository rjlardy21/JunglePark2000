//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: AddAnimalButton.java
// Files: Animal.java, Button.java, JunglePark.java, ParkGUI.java, Tiger.java, Deer.java,
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
 * This class allows the user to add a button that when pressed adds either a tiger or a deer to the
 * park. This class extends Button.java
 *
 */
public class AddAnimalButton extends Button {
  private String type; // type of the animal to add

  /**
   * This is a constructor for AddAnimalButton
   *
   * @param type represents the type of animal
   * @param x represents the x position of the button
   * @param y represents the y position of the button
   * @param park represents the JunglePark object
   */
  public AddAnimalButton(String type, float x, float y, JunglePark park) {
    super(x, y, park); // call button.java constructor with the inputted x, y, and park
    this.type = type.toLowerCase(); // set object type to inputted type
    this.label = "Add " + type; // set object label to Add + type of animal
  }

  /**
   * When the user presses a button, this class determines if the mouse is over the addTiger or
   * addDeer button and adds the correct animal to the GUI
   *
   * @see ParkGUI.java mousePressed()
   */
  @Override
  public void mousePressed() {
    // if mouse is over a button
    if (isMouseOver()) {
      // determine whether mouse is over tiger or deer button
      switch (type) {
        case "tiger":
          // create a new Tiger and add it to the JunglePark
          Tiger temptiger = new Tiger(processing);
          this.processing.listGUI.add(temptiger);
          break;
        case "deer":
          // create a new Deer and add it to the JunglePark
          Deer tempdeer = new Deer(processing);
          this.processing.listGUI.add(tempdeer);
          break;
      }
    }
  }
}
