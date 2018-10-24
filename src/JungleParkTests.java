//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: JungleParkTests.java
// Files: Animal.java, Button.java, JunglePark.java, ParkGUI.java, Tiger.java, AddAnimalButton.java,
//////////////////// ClearButton.java, Deer.java, background.png, deer.png, tiger.png,
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
 * This class contains test methods to test the correctness of the JunglePark. This class extends
 * JunglePark
 *
 */
import java.util.ArrayList; // import arraylists

public class JungleParkTests extends JunglePark {

  private static JunglePark park; // PApplet object that represents the display
                                  // window of this program

  /**
   * This method checks whether isClose() called by a Deer returns true if a tiger is within its
   * scanRange area and false if called with another tiger as input parameter located outside the
   * scanRange area
   * 
   * @return true when test verifies correct functionality, and false otherwise.
   */
  public static boolean test1isCloseMethod() {
    boolean passed = true;

    // This is an example. You can define your own test scenario for this method
    // Create a deer and two tigers
    Deer d = new Deer(park);
    Tiger t1 = new Tiger(park);
    Tiger t2 = new Tiger(park);
    // Set deer at position(200,200)
    d.setPositionX(200);
    d.setPositionY(200);
    // Set first tiger at position(400,200)
    t1.setPositionX(400); // tiger is 200px away from deer
    t1.setPositionY(200);
    // Set second tiger at position(300,200)
    t2.setPositionX(300); // tiger is 100px away from deer
    t2.setPositionY(200);
    if (d.isClose(t1, 175)) { // bug! isClose() should return false here
      System.out.println("Deer's isClose is returning true when it should return false.");
      passed = false;
    }
    if (!d.isClose(t2, 175)) { // bug! isClose() should return true here
      System.out.println("Deer's isClose is returning false when it should return true.");
      passed = false;
    }

    /////////////////////////////////////
    park.listGUI.clear(); // clear all the content of listGUI to get ready for a next scenario

    return passed;
  }

  /**
   * This method checks whether isClose() called by a Tiger returns false if another tiger is
   * located outside its scanRange area
   * 
   * @return true when test verifies correct functionality, and false otherwise.
   */
  public static boolean test2isCloseMethod() {
    boolean passed = true;
    // TODO Define your test scenario here
    Deer d = new Deer(park);
    Tiger t1 = new Tiger(park);
    Tiger t2 = new Tiger(park);
    // Set deer at position(0,0)
    d.setPositionX(0);
    d.setPositionY(0);
    // Set first tiger at position(11,0)
    t1.setPositionX(11); // tiger is 11px away from deer
    t1.setPositionY(0);
    // Set second tiger at position(0,9)
    t2.setPositionX(0); // tiger is 9px away from deer
    t2.setPositionY(9);
    if (t1.isClose(t2, 10)) { // bug! isClose() should return false here
      System.out.println("Tiger's isClose is returning true when it should return false.");
      passed = false;
    }
    if (!t1.isClose(t2, 30)) { // bug! isClose() should return true here
      System.out.println("Tiger's isClose is returning false when it should return true.");
      passed = false;
    }

    /////////////////////////////////////
    park.listGUI.clear(); // clear all the content of listGUI to get ready for a next scenario

    return passed;
  }

  /**
   * This method checks whether the deer detects a Tiger present at its proximity
   * 
   * @return true when test verifies correct functionality, and false otherwise.
   */
  public static boolean test1DeerScanForThreatMethod() {
    boolean passed = true; // set passed to true
    Deer d = new Deer(park); // create new deer object
    Tiger t1 = new Tiger(park); // create new tiger object
    Tiger t2 = new Tiger(park); // create new tiger object
    // Set deer at position(0,0)
    d.setPositionX(0);
    d.setPositionY(0);
    // Set first tiger at position(11,0)
    t1.setPositionX(11); // tiger is 11px away from deer
    t1.setPositionY(0);
    // Set second tiger at position(0,110)
    t2.setPositionX(0); // tiger is 110 px away from deer
    t2.setPositionY(110);
    // add the deer and both tigers to the GUI arraylist
    park.listGUI.add(d);
    park.listGUI.add(t1);
    park.listGUI.add(t2);
    // call Deer's scanForThreat with a range of 8
    if (d.scanForThreat(8)) { // bug! isClose() should return false here
      System.out.println("Deer's scanForThreat is returning true when it should return false.");
      // set passed to false
      passed = false;
    }
    // call Deer's scanForThreat with a range of 150
    if (!d.scanForThreat(150)) { // bug! isClose() should return true here
      System.out.println("Deer's scanForThreat is returning false when it should return true.");
      // set passed to false
      passed = false;
    }


    /////////////////////////////////////
    park.listGUI.clear(); // clear all the content of listGUI to get ready for a next scenario

    return passed;
  }

  /**
   * This method checks whether your scanForThreat() method returns false if no Tiger is present
   * within a specific range distance from it
   * 
   * @return true when test verifies correct functionality, and false otherwise.
   */
  public static boolean test2DeerScanForThreatMethod() {
    boolean passed = true; // set passed to true
    Deer d = new Deer(park); // create new deer object
    park.listGUI.add(d); // add deer to GUI array
    // Set deer at position(0,0)
    d.setPositionX(0);
    d.setPositionY(0);
    // call deer object scan for threat with a huge range with no tigers in the park
    if (d.scanForThreat(10000000)) { // bug! isClose() should return false here
      System.out.println("Deer's scanForThreat is returning true when it should return false.");
      // set passed to false
      passed = false;
    }
    // create new tiger object
    Tiger t = new Tiger(park);
    // add tiger to GUI array
    park.listGUI.add(t);
    // set tiger position to (1,1)
    t.setPositionX(1);
    t.setPositionY(1);
    // call deer object scanForThreat
    if (!d.scanForThreat(4)) { // bug! isClose() should return true here
      System.out.println("Deer's scanForThreat is returning false when it should return true.");
      // set passed to false
      passed = false;
    }


    /////////////////////////////////////
    park.listGUI.clear(); // clear all the content of listGUI to get ready for a next scenario

    return passed;
  }

  /**
   * This method checks whether the tiger hops on the deer provided to the hop() method as input
   * argument. (1) The tiger should take the position of the deer. (2) The unfortunate deer should
   * be removed from the JunglePark listGUI. (3) The eatenDeerCount should be incremented.
   * 
   * @return true when test verifies correct functionality, and false otherwise.
   */
  public static boolean testTigerHopMethod() {
    boolean passed = true;
    // This is an example. You may develop different scenarios to assess further the correctness of
    // your hop() method
    // Create one deer and one tiger
    Deer d = new Deer(park);
    Tiger t = new Tiger(park);
    // Set the deer at position(250,250)
    d.setPositionX(250);
    d.setPositionY(250);
    // Set the tiger at position(300,300) tiger is 70.71px away from deer d1
    t.setPositionX(300);
    t.setPositionY(300);
    // add the tiger and the deer to the JunglePark (i.e. to listGUI)
    park.listGUI.add(d);
    park.listGUI.add(t);
    t.hop(d); // tiger hops on the deer
    if (t.getPositionX() != d.getPositionX() && t.getPositionY() != d.getPositionY()) {
      // tiger should move to the position of the deer
      System.out.println("Tiger did not move correctly when hopping.");
      passed = false;
    }
    if (park.listGUI.contains(d)) {
      // deer should be removed from the park
      System.out.println("Deer was not removed after being hopped on.");
      passed = false;
    }
    if (t.getDeerEatenCount() != 1) {
      // deerEatenCount should be incremented. It was 0
      System.out.println("deerEatenCount should be incremented after the tiger hopped on a deer.");
      passed = false;
    }

    /////////////////////////////////////
    park.listGUI.clear(); // clear all the content of listGUI to get ready for a next scenario

    return passed;
  }

  /**
   * runs JungleParkTests program as a PApplet client
   * 
   * @param args
   */
  public static void main(String[] args) {
    // Call PApplet.main(String className) to start this program as a PApplet client application
    PApplet.main("JungleParkTests");
  }

  /**
   * This is a callback method automatically called only one time when the PApplet application
   * starts as a result of calling PApplet.main("PAppletClassName"); Defines the initial environment
   * properties of this class/program As setup() is run only one time when this program starts, all
   * your test methods should be called in this method
   */
  @Override
  public void setup() {
    super.setup(); // calls the setup() method defined
    park = this; // set the park to the current instance of Jungle
    // Call test methods
    System.out.println("test1isCloseMethod(): " + test1isCloseMethod());
    System.out.println("test2isCloseMethod(): " + test2isCloseMethod());
    System.out.println("test1DeerScanForThreatMethod(): " + test1DeerScanForThreatMethod());
    System.out.println("test2DeerScanForThreatMethod(): " + test2DeerScanForThreatMethod());
    System.out.println("testTigerHopMethod(): " + testTigerHopMethod());

    // close PApplet display window (No need for the graphic mode for these tests)
    park.exit();

  }


}
