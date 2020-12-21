package com.lbruges.bowling.model.roll.impl;

import com.lbruges.bowling.model.roll.IRoll;
import com.lbruges.bowling.utils.Constants;

/**
 * Foul roll with a 0 value representation.
 *
 * @author Laura Bruges
 */
public class Foul implements IRoll {

    @Override
    public int getKnockedPins() {
        return 0;
    }

    @Override
    public String toString() {
        return Constants.FOUL_REP;
    }

}
