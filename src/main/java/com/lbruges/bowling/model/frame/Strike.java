package com.lbruges.bowling.model.frame;

import com.lbruges.bowling.model.roll.Roll;
import com.lbruges.bowling.utils.Constants;

public class Strike extends Frame {

    public Strike(Roll firstRoll) {
        super(firstRoll);
    }

    @Override
    public boolean isStrike() {
        return true;
    }

    @Override
    public String toString() {
        return Constants.STRIKE_PLUS_BLANK_SPACE;
    }
}
