package com.lbruges.bowling.model.roll;

import com.lbruges.bowling.utils.Constants;

public class FoulRoll implements IRoll {

    @Override
    public int getKnockedPins() {
        return 0;
    }

    @Override
    public String toString() {
        return Constants.getValueWithTabFormat(Constants.FOUL_REP);
    }

}
