package com.lbruges.bowling.model.frame;

/**
 * Frame behavioral interface.
 *
 * @author Laura Bruges
 */
public interface IFrame {

    int getTotalKnockedPins();
    int getFirstRollKnockedPins();
    FrameType getFrameType();

}
