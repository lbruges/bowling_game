package com.lbruges.bowling.model.roll.impl;

import com.lbruges.bowling.model.roll.IRoll;

/**
 * Represents a pseudo roll for completing a possible extra roll (Spare as last regular frame).
 *
 * @author Laura Bruges
 */
public class Dummy implements IRoll {

    @Override
    public int getKnockedPins() {
        return 0;
    }

    @Override
    public String toString() {
        return "";
    }
}
