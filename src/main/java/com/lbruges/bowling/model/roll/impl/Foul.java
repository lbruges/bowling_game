package com.lbruges.bowling.model.roll.impl;

import com.lbruges.bowling.model.roll.IRoll;
import com.lbruges.bowling.utils.Constants;

import static com.lbruges.bowling.utils.UtilFunctions.getValueWithTabFormat;

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
