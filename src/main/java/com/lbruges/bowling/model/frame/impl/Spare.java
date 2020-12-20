package com.lbruges.bowling.model.frame.impl;

import com.lbruges.bowling.model.frame.AbstractFrame;
import com.lbruges.bowling.model.frame.FrameType;
import com.lbruges.bowling.model.roll.IRoll;

import static com.lbruges.bowling.utils.UtilFunctions.getValueWithTabFormat;

public class Spare extends AbstractFrame {

    public Spare(IRoll firstRoll, IRoll secondRoll) {
        super(firstRoll, secondRoll);
    }

    @Override
    public FrameType getFrameType() {
        return FrameType.SPARE;
    }

    public String toString() {
        return getValueWithTabFormat(firstRoll.toString()) + "/";
    }

}
