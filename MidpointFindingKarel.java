/*
 * File: MidpointFindingKarel.java
 * -------------------------------
 * When you finish writing it, the MidpointFindingKarel class should
 * leave a beeper on the corner closest to the center of 1st Street
 * (or either of the two central corners if 1st Street has an even
 * number of corners).  Karel can put down additional beepers as it
 * looks for the midpoint, but must pick them up again before it
 * stops.  The world may be of any size, but you are allowed to
 * assume that it is at least as tall as it is wide.
 */

import stanford.karel.*;

public class MidpointFindingKarel extends SuperKarel {
    public void run() {
        while (true) {
            if (beepersPresent()) {
                // We have found the midpoint so we exit
                break;
            }
            putBeeper();

            // For the case where the world is just one column, Karel should
            // stop.
            if (frontIsBlocked()) {
                break;
            }

            moveUntilStopedByWallOrBeeper();

            // If Karel stops cause he found a beeper, pick up the beeper and
            // turn around.
            if (beepersPresent()) {
                pickBeeper();
                turnAround();
                move();
            } else {
                turnAround();
            }
        }
    }

    /*
     * Move until Karel sees a wall or a beeper.
     */
    private void moveUntilStopedByWallOrBeeper() {
        move();
        while (frontIsClear() && noBeepersPresent()) {
            move();
        }
    }
}
