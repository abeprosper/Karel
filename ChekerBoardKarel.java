/*
 * File: CheckerboardKarel.java
 * ----------------------------
 * When you finish writing it, the CheckerboardKarel class should draw
 * a checkerboard using beepers, as described in Assignment 1.  You
 * should make sure that your program works for all of the sample
 * worlds supplied in the starter folder.
 */

import stanford.karel.*;

public class CheckerboardKarel extends SuperKarel {
    public void run() {
        putBeeperOnFirstSpot();
        fillRow();
        faceNorth();
        while(frontIsClear()) {
            fillRowTowardsWest();
            if (frontIsClear()) {
                fillRowTowardsEast();
            }
        }
    }

    /*
     * Fills checkerboard rows towards the East. Karel starts from
     * a previous filled row facing North.
     */
    private void fillRowTowardsEast() {
        if (beepersPresent()) {
            move();
            faceEast();
            fillRow();
            faceNorth();
        } else {
            // If currently there is a beeper when we move to the next row
            // we make sure to put a beeper on the first spot.
            move();
            faceEast();
            putBeeperOnFirstSpot();
            fillRow();
            faceNorth();
        }
    }

    /*
     * Fills checkerboard rows towards the West. Karel starts from
     * a previous filled row facing North.
     */
    private void fillRowTowardsWest() {
        if (beepersPresent()) {
            move();
            faceWest();
            fillRow();
            faceNorth();
        } else {
            // If currently there is a beeper when we move to the next row
            // we make sure to put a beeper on the first spot.
            move();
            faceWest();
            putBeeperOnFirstSpot();
            fillRow();
            faceNorth();
        }
    }

    /*
     * Puts beeper on the first spot of the row.
     */
    private void putBeeperOnFirstSpot() {
        putBeeper();
        if (frontIsClear()) {
           move();
        }
    }

    /*
     * Fills a row with a checkerboard pattern, alternating between spots.
     */
    private void fillRow() {
        while (frontIsClear()) {
            move();
            putBeeper();
            if (frontIsClear()) {
                move();
            }
        }
    }

    /*
     * Make Karel face West.
     */
    private void faceWest() {
        while(notFacingWest()) {
            turnLeft();
        }
    }

    /*
     * Make Karel face East.
     */
    private void faceEast() {
        while(notFacingEast()) {
            turnLeft();
        }
    }

    /*
     * Make Karel face North.
     */
    private void faceNorth() {
        while(notFacingNorth()) {
            turnLeft();
        }
    }
}
