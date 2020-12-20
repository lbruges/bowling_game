package com.lbruges.bowling.model.frame.impl;

import com.lbruges.bowling.model.frame.AbstractFrame;
import com.lbruges.bowling.model.frame.FrameType;
import com.lbruges.bowling.model.roll.IRoll;

import static com.lbruges.bowling.utils.UtilFunctions.getValueWithTabFormat;

public class Strike extends AbstractFrame {

    public Strike(IRoll firstRoll) {
        super(firstRoll);
    }

    @Override
    public FrameType getFrameType() {
        return FrameType.STRIKE;
    }

    public String toString() {
        return getValueWithTabFormat("") + "X";
    }

}
