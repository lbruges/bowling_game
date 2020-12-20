package com.lbruges.bowling.model.roll.impl;

import com.lbruges.bowling.model.roll.IRoll;
import com.lbruges.bowling.utils.Constants;

public class Foul implements IRoll {

    @Override
    public int getKnockedPins() {
        return 0;
    }

    @Override
    public String toString() {
        return Constants.getValueWithTabFormat(Constants.FOUL_REP);
    }

}
