package com.lbruges.bowling.model.frame;

import com.lbruges.bowling.model.roll.Roll;

import static com.lbruges.bowling.utils.Constants.ROLL_BASE_BLANK_SPACE;

public class Strike extends Frame {

    private static final String STRIKE_PLUS_BLANK_SPACE = "X   ";

    public Strike(Roll firstRoll) {
        super(firstRoll);
    }

    @Override
    public boolean isStrike() {
        return true;
    }

    @Override
    public String toString() {
        return ROLL_BASE_BLANK_SPACE + STRIKE_PLUS_BLANK_SPACE;
    }

}
