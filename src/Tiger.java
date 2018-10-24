//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: Tiger.java
// Files: Animal.java, Button.java, JunglePark.java, ParkGUI.java, Deer.java, AddAnimalButton.java,
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
 * This class represents a Tiger in the JunglePark application
 *
 */
public class Tiger extends Animal {
  private int deerEatenCount; // Number of Deers that the current tiger has eaten so far
  private static final int SCAN_RANGE = 100; // range dimension for scanning the neighborhood for
                                             // food
  private static final String IMAGE_FILE_NAME = "images/tiger.png";
  private static int nextID = 1; // class variable that represents the identifier of the next tiger
                                 // to be created
  // Tiger's identification fields
  private static final String TYPE = "TGR"; // A String that represents the tiger type
  private final int id; // Tiger's id: positive number that represents the order of the tiger


  /**
   * Creates a new Tiger object positioned at a random position of the display window
   * 
   * @param processing PApplet object that represents the display window
   */
  public Tiger(JunglePark processing) {
    // Set Tiger drawing parameters
    super(processing, IMAGE_FILE_NAME);

    // Set Tiger identification fields
    id = nextID;
    this.deerEatenCount = 0; // int that holds the amount of deer eaten by the current tiger
    this.label = TYPE + id; // String that identifies the current tiger
    nextID++;
  }

  /**
   * Getter to return the deerEatenCount by the current tiger
   * 
   * @return deerEatenCount by the current tiger
   */
  public int getDeerEatenCount() {
    return deerEatenCount; // return number of deer eaten by current tiger
  }

  /**
   * Current tiger hops onto the deer object from input
   * 
   * @param food representing a deer object
   */
  public void hop(Deer food) {
    // set current tiger's position to input deer's position
    this.setPositionX(food.getPositionX());
    this.setPositionY(food.getPositionY());
    // increments deerEatenCount because this deer was just eaten
    deerEatenCount++;
    // remove deer that was eaten from array of GUI objects
    processing.listGUI.remove(food);
  }

  /**
   * Defines the Tiger's behavior in the Jungle Park
   * 
   */
  @Override
  public void action() {
    // iterate through the list of objects in GUI
    for (int i = 0; i < processing.listGUI.size(); i++) {
      // if the object in the GUI is a deer
      if (processing.listGUI.get(i) instanceof Deer) {
        // create a temporary deer object with the same values as the deer element in the GUI
        Deer temp = (Deer) processing.listGUI.get(i);
        // calls isClose in Animal.java to see if the deer is within the tiger's range
        if (super.isClose(temp, SCAN_RANGE)) {
          // release the mouse
          processing.mouseReleased();
          // call hop and pass in the deer as input
          hop(temp);
        }
      }
    }
    // if a tiger has eaten at least one deer
    if (deerEatenCount > 0)
      displayDeerEatenCount(); // display deerEatenCount
  }


  /**
   * Displays the number of eaten deers if any on the top of the tiger image
   */
  public void displayDeerEatenCount() {
    this.processing.fill(0); // specify font color: black
    // display deerEatenCount on the top of the Tiger's image
    this.processing.text(deerEatenCount, this.getPositionX(),
        this.getPositionY() - this.image.height / 2 - 4);
  }
}
