package com.lbruges.bowling.model.roll;

import com.lbruges.bowling.utils.Constants;

public class FoulRoll implements IRoll {

    @Override
    public int getKnockedPins() {
        return 0;
    }

    @Override
    public String toString() {
        return Constants.FOUL_REP + Constants.ROLL_BASE_BLANK_SPACE.substring(1);
    }

}
