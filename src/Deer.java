//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: Deer.java
// Files: Animal.java, Button.java, JunglePark.java, ParkGUI.java, Tiger.java, AddAnimalButton.java,
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
 * This class represents a Deer in the JunglePark application
 *
 */
public class Deer extends Animal {
  private static final int SCAN_RANGE = 175; // scan range area to check for a threat in the
                                             // neighborhood
  private static final String IMAGE_FILE_NAME = "images/deer.png";
  private static int nextID = 1; // class variable that represents the identifier of the next deer
                                 // to be created

  private static final String TYPE = "DR"; // A String that represents the deer type
  private final int id; // Deer's id: positive number that represents the order of the deer


  /**
   * Creates a new Deer object positioned at a random position of the display window
   * 
   * @param processing PApplet object that represents the display window
   */
  public Deer(JunglePark processing) {
    // Set Deer drawing parameters
    super(processing, IMAGE_FILE_NAME);
    // Set Deer identification fields
    id = nextID;
    this.label = TYPE + id; // String that identifies the current deer
    nextID++;
  }

  /**
   * Checks if there is a threat (a Tiger for instance) at the neighborhood
   * 
   * @param scanRange is an integer that represents the range of the area to be scanned around the
   *        animal
   */
  public boolean scanForThreat(int scanRange) {
    // iterate through the list of objects in the GUI
    for (int i = 0; i < processing.listGUI.size(); i++) {
      // if the object in the GUI is a Tiger object
      if (processing.listGUI.get(i) instanceof Tiger) {
        // create a Tiger object with the GUI element's values
        Tiger tempanimal = (Tiger) processing.listGUI.get(i);
        // calls Animal.java isClose passing through the temporary Tiger and scanRange
        if (super.isClose(tempanimal, scanRange)) {
          return true;
        }
      }
    }
    return false;
  }

  /**
   * Defines the behavior of a Deer object in the Jungle park
   * 
   * @see Animal.java action()
   */
  @Override
  public void action() {
    // call scanForThreat with scan_range
    if (scanForThreat(SCAN_RANGE)) {
      this.processing.fill(0); // specify font color: black
      this.processing.text("THREAT!", this.getPositionX(),
          this.getPositionY() - this.image.height / 2 - 4); // print out THREAT! above Deer image
    }
  }
}
