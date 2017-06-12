/*
 * File: StoneMasonKarel.java

 * --------------------------
 * The StoneMasonKarel subclass as it appears here does nothing.
 * When you finish writing it, it should solve the "repair the quad"
 * problem from Assignment 1.  In addition to editing the program,
 * you should be sure to edit this comment so that it no longer
 * indicates that the program does nothing.
 */

import stanford.karel.*;

public class StoneMasonKarel extends SuperKarel {
    public void run() {
        while (thereAreMoreColumnsToFix()) {
            fixColumn();
            moveToNextColumn();
        }
        // Make sure that we fix the last column.
        fixColumn();
    }

    /** Check if there are more columns that needs to be fixed */
    private boolean thereAreMoreColumnsToFix() {
        return frontIsClear();
    }

    /** Go up the column adding missing beepers and then return at the bottom. */
    private void fixColumn() {
        addMissingBeepers();
        returnToBottomOfColumn();
    }

    /** Add missing beepers to a column */
    private void addMissingBeepers() {
        turnLeft(); //Face upwards
        while (frontIsClear()) {
            if (noBeepersPresent()) {
                putBeeper();
            }
            move();
        }
        // Make sure we add a beeper on the last spot.
        if (noBeepersPresent()) {
            putBeeper();
        }
    }

    /** Return to the bottom of the column after fixing it */
    private void returnToBottomOfColumn() {
        turnLeft();
        turnLeft();
        while (frontIsClear()) {
            move();
       }
        turnLeft();
    }

    /** Move to the next column which is four steps from the current spot */
    private void moveToNextColumn() {
        for (int i=0; i<4; i++) {
            move();
        }
    }
}
