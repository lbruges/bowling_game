package com.lbruges.bowling.model.frame;

import com.lbruges.bowling.model.roll.Roll;
import com.lbruges.bowling.utils.Constants;

public class Spare extends Frame {

    public Spare(Roll firstRoll, Roll secondRoll) {
        super(firstRoll, secondRoll);
    }

    @Override
    public boolean isSpare() {
        return true;
    }

    @Override
    public String toString() {
        return super.firstRoll.toString() + Constants.SPARE_PLUS_BLANK_SPACE;
    }
}
