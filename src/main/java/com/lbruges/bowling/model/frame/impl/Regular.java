package com.lbruges.bowling.model.frame.impl;

import com.lbruges.bowling.model.frame.AbstractFrame;
import com.lbruges.bowling.model.frame.FrameType;
import com.lbruges.bowling.model.roll.IRoll;

public class Regular extends AbstractFrame {

    public Regular(IRoll firstRoll, IRoll secondRoll) {
        super(firstRoll, secondRoll);
    }

    @Override
    public FrameType getFrameType() {
        return FrameType.REGULAR;
    }

    public String toString() {
        return firstRoll.toString() + secondRoll.toString();
    }

}
