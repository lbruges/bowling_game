package com.lbruges.bowling.model.frame;

import com.lbruges.bowling.model.roll.IRoll;

public class Spare extends Frame {

    private static final String SPARE_PLUS_BLANK_SPACE = "   /";

    public Spare(IRoll firstRoll, IRoll secondRoll) {
        super(firstRoll, secondRoll);
    }

    @Override
    public boolean isSpare() {
        return true;
    }

    @Override
    public String toString() {
        return super.firstRoll.toString() + SPARE_PLUS_BLANK_SPACE;
    }
}
