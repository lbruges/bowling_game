package com.lbruges.bowling.model.frame;

import com.lbruges.bowling.model.roll.IRoll;
import com.lbruges.bowling.utils.Constants;

public class Spare extends Frame {

    public Spare(IRoll firstRoll, IRoll secondRoll) {
        super(firstRoll, secondRoll);
    }

    @Override
    public boolean isSpare() {
        return true;
    }

    @Override
    public String toString() {
        return super.firstRoll.toString() + Constants.getValueWithTabFormat("/");
    }
}
